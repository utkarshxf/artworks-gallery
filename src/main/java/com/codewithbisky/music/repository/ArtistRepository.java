package com.codewithbisky.music.repository;

import com.codewithbisky.music.model.Artist;
import com.codewithbisky.music.model.projection.ArtistProjection;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.Optional;

public interface ArtistRepository extends Neo4jRepository<Artist,String> {

    @Query("MATCH (artist: Artist {id: $artistId}) RETURN artist.id As id, artist.name as name")
    Optional<ArtistProjection>  findByIdProjection(@Param("artistId")String id);

    @Query("MATCH (artist: Artist {id: $artistId}) " +
            "MATCH (year: Year {year: $releasedYear}) " +
            "MATCH (artwork: Artwork {id: $artworkId}) " +
            "MATCH (genre: Genre {id: $genreId}) " +
            "MERGE (artist)-[:CREATED {createdAt: $createdAt}]->(artwork) "+
            "MERGE (artwork)-[:BELONGS_TO_GENRE {createdAt: $createdAt}]->(genre) "+
            "MERGE (artwork)-[:RELEASED_IN {createdAt: $createdAt}]->(year)"
    )
    void addArtistAndArtworkRelationship(@Param("artistId") String artistId,
                                         @Param("releasedYear") Integer releasedYear,
                                         @Param("artworkId") String artworkId,
                                         @Param("createdAt") LocalDateTime localDateTime,
                                         @Param("genreId") String genreId);


}
