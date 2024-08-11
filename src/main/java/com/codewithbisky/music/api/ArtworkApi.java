package com.codewithbisky.music.api;

import com.codewithbisky.music.dto.ArtworkRecord;
import com.codewithbisky.music.service.ArtworkService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/artwork")
@RequiredArgsConstructor
public class ArtworkApi {

    private  final ArtworkService artworkService;

    @PostMapping("/artist/{artistId}")
    public ResponseEntity<ArtworkRecord> createNewArtwork(@RequestBody ArtworkRecord requestRecord, @PathVariable String artistId){

        artworkService.create(requestRecord,artistId);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/user/like/{artworkId}/{userId}")
    public void userLikeAArtwork(@PathVariable String artworkId, @PathVariable String userId) {
        artworkService.userLikeAArtwork(artworkId, userId);
    }

}
