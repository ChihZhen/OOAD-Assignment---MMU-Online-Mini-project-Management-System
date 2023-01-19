package com.example.ooad.model;

import org.springframework.stereotype.Component;

import com.example.ooad.entity.Comment;
import com.example.ooad.repository.CommentRepository;

@Component
public class CommentModel extends Model<Comment> {

    public CommentModel(CommentRepository repository) {
        super(repository);
    }

}
