package com.codewithbisky.music.service;

import com.codewithbisky.music.model.Album;
import com.codewithbisky.music.repository.AlbumRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

import static com.codewithbisky.music.model.Status.DRAFT;


@Service
@RequiredArgsConstructor
@Slf4j
public class AlbumServiceImpl implements  AlbumService{

    private final AlbumRepository albumRepository;
    private final YearService yearService;
    @Override
    public Album create(Album album, Integer releasedYear, String artistId) {

        Album build = Album.builder()
                .name(album.getName())
                .description(album.getDescription())
                .status(DRAFT).build();
        Album save = albumRepository.save(build);
        yearService.create(releasedYear);
        albumRepository.addReleasedYearAndArtist(artistId,save.getId(),releasedYear,LocalDateTime.now());
        return save;
    }

    @Override
    public void deleteById(String id) {

        albumRepository.deleteById(id);
    }

    @Override
    public void userLikeAnAlbum(String albumId, String userId) {


        albumRepository.userLikesAlbum(userId,albumId, LocalDateTime.now());

    }

    @Override
    public void userDikeLikeAnAlbum(String albumId, String userId) {

        albumRepository.userDislikeAlbum(userId,albumId);
    }
}
