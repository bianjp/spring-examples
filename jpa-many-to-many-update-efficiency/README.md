# JPA update many-to-many efficiency

Check SQL executed when updating many-to-many relationship.

Used in blog post [JPA many-to-many update efficiency](https://bianjp.com/posts/2017/10/31/jpa-many-to-many-update-efficiency). 

3 sub-package use different methods to present many-to-many relationship:

* list: Represent @ManyToMany with `java.util.List`
* set: Represent @ManyToMany with `java.util.Set`
* onetomany: Split into two bidirectional `@OneToMany`

## Run

```bash
../gradlew bootRun -P testPackage=list
../gradlew bootRun -P testPackage=set
../gradlew bootRun -P testPackage=onetomany
```

## Sample output

Irrelevant output are filtered.

list:

    ================= Adding a tag =================
    Hibernate: delete from post_tag where post_id=?
    Hibernate: insert into post_tag (post_id, tag_id) values (?, ?)
    Hibernate: insert into post_tag (post_id, tag_id) values (?, ?)
    ================= Removing a tag =================
    Hibernate: delete from post_tag where post_id=?
    Hibernate: insert into post_tag (post_id, tag_id) values (?, ?)

set:

    ================= Adding a tag =================
    Hibernate: insert into post_tag (post_id, tag_id) values (?, ?)
    ================= Removing a tag =================
    Hibernate: delete from post_tag where post_id=? and tag_id=?
    
onetomany:

    ================= Adding a tag =================
    Hibernate: insert into post_tag (id, post_id, tag_id) values (null, ?, ?)
    ================= Removing a tag =================
