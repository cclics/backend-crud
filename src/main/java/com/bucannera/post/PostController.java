package com.bucannera.post;

import java.util.List;

import org.springframework.web.bind.annotation.*;

@RestController
class PostController {

    private final PostRepository repository;

    PostController(PostRepository repository) {
        this.repository = repository;
    }

    // Aggregate root
    // tag::get-aggregate-root[]
    @GetMapping("/posts")
    List<Post> all() {
        return repository.findAll();
    }
    // end::get-aggregate-root[]

    @PostMapping("/posts")
    Post newPost(@RequestBody Post newPost) {
        return repository.save(newPost);
    }

    // Single item

    @GetMapping("/posts/{id}")
    Post one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new PostNotFoundException(id));
    }

    @PutMapping("/posts/{id}")
    Post replacePost(@RequestBody Post newPost, @PathVariable Long id) {

        return repository.findById(id)
                .map(post -> {
                    post.setTitle(newPost.getTitle());
                    post.setBody(newPost.getBody());
                    return repository.save(post);
                })
                .orElseGet(() -> {
                    return repository.save(newPost);
                });
    }

    @DeleteMapping("/posts/{id}")
    void deletePost(@PathVariable Long id) {
        repository.deleteById(id);
    }
}

