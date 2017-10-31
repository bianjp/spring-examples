package com.bianjp.examples.onetomany.entity;

import com.bianjp.examples.BaseEntity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Tag extends BaseEntity {
  @OneToMany(
    mappedBy = "tag",
    cascade = CascadeType.ALL,
    orphanRemoval = true,
    fetch = FetchType.EAGER
  )
  private List<PostTag> postTags = new ArrayList<>();

  public List<PostTag> getPostTags() {
    return postTags;
  }

  public void setPostTags(List<PostTag> postTags) {
    this.postTags = postTags;
  }
}
