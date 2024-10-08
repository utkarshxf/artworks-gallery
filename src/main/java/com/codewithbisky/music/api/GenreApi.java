package com.codewithbisky.music.api;


import com.codewithbisky.music.model.Genre;
import com.codewithbisky.music.service.GenreService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/genres")
@RequiredArgsConstructor
public class GenreApi {

    private final GenreService genreService;


    @PostMapping
    public ResponseEntity<?> createNewGenre(@RequestBody Genre genre){

        genreService.create(genre);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @PutMapping("/{genreId}/artist/{artistId}/assign-artist")
    public void addArtistToGenre(@PathVariable String genreId, @PathVariable String artistId) {

        genreService.addArtistToGenre(genreId,artistId);
    }
    @PutMapping("/{genreId}/artwork/{artworkId}/assign-artwork")
    public void addArtworkToGenre(@PathVariable String genreId, @PathVariable String artworkId) {

        genreService.addArtworkToGenre(genreId,artworkId);
    }

    @PutMapping("/{genreId}/artist/{artistId}/un-assign-artist")
    public void removeArtistFromGenre(@PathVariable String genreId, @PathVariable String artistId) {

        genreService.removeArtistFromGenre(genreId,artistId);
    }
    @PutMapping("/{genreId}/artwork/{artworkId}/un-assign-artwork")
    public void removeArtworkFromGenre(@PathVariable String genreId, @PathVariable String artworkId) {

        genreService.removeArtworkFromGenre(genreId,artworkId);
    }

}
