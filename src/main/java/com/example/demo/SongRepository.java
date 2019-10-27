package com.example.demo;

import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface SongRepository extends CrudRepository<Song, Long> {
    Set<Song> findByAlbum(Album album);
}
