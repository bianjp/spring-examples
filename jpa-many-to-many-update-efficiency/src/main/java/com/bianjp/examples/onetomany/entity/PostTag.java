package com.bianjp.examples.onetomany.entity;

import com.bianjp.examples.BaseEntity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.util.Objects;

@Entity
public class PostTag extends BaseEntity {
  @ManyToOne(cascade = CascadeType.REFRESH)
  private Post post;

  @ManyToOne private Tag tag;

  public PostTag() {}

  public PostTag(Post post, Tag tag) {
    this.post = post;
    this.tag = tag;
  }

  public Post getPost() {
    return post;
  }

  public void setPost(Post post) {
    this.post = post;
  }

  public Tag getTag() {
    return tag;
  }

  public void setTag(Tag tag) {
    this.tag = tag;
  }

  @Override
  public int hashCode() {
    return Objects.hash(post, tag);
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) {
      return true;
    } else if (other == null || this.getClass() != other.getClass()) {
      return false;
    } else {
      PostTag otherEntity = (PostTag) other;
      return Objects.equals(post, otherEntity.post) && Objects.equals(tag, otherEntity.tag);
    }
  }
}
