package com.bianjp.examples.set.entity;

import com.bianjp.examples.BaseEntity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Post extends BaseEntity {
  @ManyToMany(
    fetch = FetchType.EAGER,
    cascade = {CascadeType.PERSIST, CascadeType.MERGE}
  )
  @JoinTable(
    name = "post_tag",
    joinColumns = @JoinColumn(name = "post_id"),
    inverseJoinColumns = @JoinColumn(name = "tag_id")
  )
  private Set<Tag> tags = new HashSet<>();

  public Set<Tag> getTags() {
    return tags;
  }

  public void setTags(Set<Tag> tags) {
    this.tags = tags;
  }

  public void addTag(Tag tag) {
    tags.add(tag);
    tag.getPosts().add(this);
  }

  public void removeTag(Tag tag) {
    tags.remove(tag);
    tag.getPosts().remove(this);
  }
}
