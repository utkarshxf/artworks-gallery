package com.codewithbisky.music.dto;

import com.codewithbisky.music.model.ArtType;
import com.codewithbisky.music.model.StorageType;

import java.time.LocalDateTime;

public record ArtworkRecord(String title,
                            String storageId,
                            StorageType storageType,
                            ArtType artType,
                            String albumId,
                            String genreId,
                            long duration,
                            LocalDateTime releasedDate,
                            Integer releaseYear) {
}
