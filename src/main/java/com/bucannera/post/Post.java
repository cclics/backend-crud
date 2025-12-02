package com.bucannera.post;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Post {

    private @Id
    @GeneratedValue Long id;
    private String title;
    private String body;

    Post() {}

    public Post(String title, String body) {

        this.title = title;
        this.body = body;
    }

    public Long getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public String getBody() {
        return this.body;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o)
            return true;
        if (!(o instanceof Post))
            return false;
        Post post = (Post) o;
        return Objects.equals(this.id, post.id) && Objects.equals(this.title, post.title)
                && Objects.equals(this.body, post.body);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.title, this.body);
    }

    @Override
    public String toString() {
        return "Post{" + "id=" + this.id + ", title='" + this.title + '\'' + ", body='" + this.body + '\'' + '}';
    }
}