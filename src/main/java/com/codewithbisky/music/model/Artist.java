package com.codewithbisky.music.model;


import com.codewithbisky.music.model.relationship.AlbumRelationship;
import com.codewithbisky.music.model.relationship.ArtistRelationship;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.List;

@Node("Artist")
@Getter
@Setter
@Builder
public class Artist {

    @Id
    private String id;
    private String name;

    @Relationship(value = "BELONGS_TO_GENRE")
    private Genre genre;

    @Relationship("CREATED")
    private List<ArtistRelationship> artworks;

    @Relationship("CREATED")
    private List<AlbumRelationship> albums;

}
