package com.codewithbisky.music.service;

import com.codewithbisky.music.dto.UserRegistrationRequestRecord;
import com.codewithbisky.music.model.User;

public interface UserService {

    User createUser(UserRegistrationRequestRecord user);
    void deleteByUserId(String id);
    void userFollowArtist(String userId,String artistId);
    void userUnFollowArtist(String userId,String artistId);
}
