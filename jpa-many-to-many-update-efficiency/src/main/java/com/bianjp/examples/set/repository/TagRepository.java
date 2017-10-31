package com.bianjp.examples.set.repository;

import com.bianjp.examples.set.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Integer> {
}
