package com.epam.jmp.mongodb.dao.interfaces;

import com.epam.jmp.mongodb.model.Post;


public interface PostDAO
{
    void addPost(Post post);

    Post removePost(Post postost);

    Post[] getPosts();

    Post getPostById(long id);

    Post[] getPostByUserId(long userId);
}
