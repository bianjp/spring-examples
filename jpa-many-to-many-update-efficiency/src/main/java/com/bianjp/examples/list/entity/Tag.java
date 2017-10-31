package com.bianjp.examples.list.entity;

import com.bianjp.examples.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Tag extends BaseEntity {
  @ManyToMany(mappedBy = "tags", fetch = FetchType.EAGER)
  private List<Post> posts = new ArrayList<>();

  public List<Post> getPosts() {
    return posts;
  }

  public void setPosts(List<Post> posts) {
    this.posts = posts;
  }
}
