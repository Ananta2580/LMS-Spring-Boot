package com.anu.lms.mapper;

import org.springframework.stereotype.Component;

import com.anu.lms.entities.Genre;
import com.anu.lms.payload.dto.GenreDTO;

@Component
public class GenreMapper {
    
    public GenreDTO mapToGenreDTO(Genre genre){
        return GenreDTO.builder()
        .Id(genre.getId())
        .genreCode(genre.getGenreCode())
        .genreName(genre.getGenreName())
        .genreDescription(genre.getGenreDescription())
        .displayOrder(genre.getDisplayOrder())
        .active(genre.getActive())
        .createdAt(genre.getCreatedAt())
        .updatedAt(genre.getUpdatedAt())
        .build();
    }

    public Genre mapToGenre(GenreDTO genreDTO){
        return Genre.builder()
        .Id(genreDTO.getId())
        .genreCode(genreDTO.getGenreCode())
        .genreName(genreDTO.getGenreName())
        .genreDescription(genreDTO.getGenreDescription())
        .displayOrder(genreDTO.getDisplayOrder())
        .active(genreDTO.getActive())
        .build();
    }

}
