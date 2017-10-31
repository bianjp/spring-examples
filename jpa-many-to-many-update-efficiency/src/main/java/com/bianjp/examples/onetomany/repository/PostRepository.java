package com.bianjp.examples.onetomany.repository;

import com.bianjp.examples.onetomany.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Integer> {
}
