package com.codewithbisky.music.service;

import com.codewithbisky.music.dto.ArtworkRecord;
import com.codewithbisky.music.model.Artwork;

public interface ArtworkService {

    Artwork create(ArtworkRecord artworkRecord, String artistId);
    void deleteById(String id);

    void userLikeAArtwork(String artworkId, String userId);
    void userDisLikeAArtwork(String artworkId, String userId);

}
