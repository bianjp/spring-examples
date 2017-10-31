package com.bianjp.examples.list.repository;

import com.bianjp.examples.list.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Integer> {
}
