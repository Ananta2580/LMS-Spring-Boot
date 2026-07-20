package com.anu.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anu.lms.entities.Genre;

public interface GenreRepository extends JpaRepository<Genre, Long>{
    
}
