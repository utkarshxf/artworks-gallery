package com.codewithbisky.music.model.projection;

import com.codewithbisky.music.model.Year;

public interface ArtworkProjection {
    String getId();
    String getDescription();
    String getName();
    String getStatus();
    String getDuration();
    String getStorageId();
    String getStorageType();
    String getType();
    Year getYear();
}
