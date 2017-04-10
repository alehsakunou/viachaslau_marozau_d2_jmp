package com.epam.jmp.spring.dao.interfaces;

import com.epam.jmp.spring.model.Like;

/**
 * Created by Viachaslau_Marozau on 4/3/2017.
 */
public interface LikeDAO
{
    void addLike(Like like);

    Like removeLike(Like like);

    Like[] getLikes();

    Like getLikeById(long id);

    Like[] getLikeByUserId(long userId);
}
