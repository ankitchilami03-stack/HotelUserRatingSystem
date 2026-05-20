package com.lcwd.user.service.Services;

import com.lcwd.user.service.entities.User;

import java.util.List;

public interface UserServices
{
    //user operation

    //create
    User saveUser(User user);

    //get All User
    List<User> getAllUser();

    //get user based on id
    User getUser(String userId);

    //TODO:delte
    //TODO:update
}
