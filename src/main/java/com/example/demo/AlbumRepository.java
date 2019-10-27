package com.example.demo;

import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface AlbumRepository extends CrudRepository<Album, Long> {
    Set<Album> findById(long id);
}

