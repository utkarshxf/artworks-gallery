package com.codewithbisky.music.service;

import com.codewithbisky.music.model.Genre;

public interface GenreService {
    Genre create(Genre genre);
    void addArtistToGenre(String genreId, String artistId);
    void removeArtistFromGenre(String genreId, String artistId);
    void addArtworkToGenre(String genreId, String artworkId);
    void removeArtworkFromGenre(String genreId, String artworkId);
}
