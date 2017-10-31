package com.bianjp.examples.set;

import com.bianjp.examples.set.entity.Post;
import com.bianjp.examples.set.entity.Tag;
import com.bianjp.examples.set.repository.PostRepository;
import com.bianjp.examples.set.repository.TagRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {
  private final PostRepository postRepository;
  private final TagRepository tagRepository;

  public Application(PostRepository postRepository, TagRepository tagRepository) {
    this.postRepository = postRepository;
    this.tagRepository = tagRepository;
  }

  @Override
  public void run(String... args) throws Exception {
    Post post1 = postRepository.findOne(1);
    Post post2 = postRepository.findOne(2);
    Tag tag2 = tagRepository.findOne(2);

    System.out.println("================= Adding a tag =================");
    post1.addTag(tag2);
    postRepository.saveAndFlush(post1);

    System.out.println("================= Removing a tag =================");
    post2.removeTag(tag2);
    postRepository.saveAndFlush(post2);
  }

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }
}
