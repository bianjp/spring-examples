package com.bianjp.examples.onetomany.repository;

import com.bianjp.examples.onetomany.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Integer> {
}
