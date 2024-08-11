package com.codewithbisky.music.service;

import com.codewithbisky.music.model.Album;

public interface AlbumService {

    Album create(Album album, Integer releasedYear, String artistId);
    void deleteById(String id);
    void userLikeAnAlbum(String albumId,String userId);
    void userDikeLikeAnAlbum(String albumId,String userId);
}
