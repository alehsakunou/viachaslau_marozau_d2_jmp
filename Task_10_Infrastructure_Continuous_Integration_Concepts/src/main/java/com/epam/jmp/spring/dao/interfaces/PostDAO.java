package com.epam.jmp.spring.dao.interfaces;

import com.epam.jmp.spring.model.Post;

/**
 * Created by Viachaslau_Marozau on 4/3/2017.
 */
public interface PostDAO
{
    void addPost(Post post);

    Post removePost(Post postost);

    Post[] getPosts();

    Post getPostById(long id);

    Post[] getPostByUserId(long userId);
}
