package com.codewithbisky.music.repository;

import com.codewithbisky.music.model.User;
import com.codewithbisky.music.model.Year;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.Optional;

public interface YearRepository extends Neo4jRepository<Year,String> {

    Optional<Year>  findByYear(Integer year);
}
