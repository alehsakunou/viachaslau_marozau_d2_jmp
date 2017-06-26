package com.epam.jmp.mongodb.dao.interfaces;

import com.epam.jmp.mongodb.model.Like;

public interface LikeDAO
{
    void addLike(Like like);

    Like removeLike(Like like);

    Like[] getLikes();

    Like getLikeById(long id);

    Like[] getLikeByUserId(long userId);
}
