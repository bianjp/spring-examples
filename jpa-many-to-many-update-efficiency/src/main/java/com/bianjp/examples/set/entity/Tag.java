package com.bianjp.examples.set.entity;

import com.bianjp.examples.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Tag extends BaseEntity {
  @ManyToMany(mappedBy = "tags", fetch = FetchType.EAGER)
  private Set<Post> posts = new HashSet<>();

  public Set<Post> getPosts() {
    return posts;
  }

  public void setPosts(Set<Post> posts) {
    this.posts = posts;
  }
}
