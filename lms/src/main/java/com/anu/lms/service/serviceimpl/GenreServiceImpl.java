package com.anu.lms.service.serviceimpl;

import org.springframework.stereotype.Service;

import com.anu.lms.entities.Genre;
import com.anu.lms.mapper.GenreMapper;
import com.anu.lms.payload.dto.GenreDTO;
import com.anu.lms.repository.GenreRepository;
import com.anu.lms.service.GenreService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GenreServiceImpl implements GenreService {

    private final GenreRepository genreRepository;
    private final GenreMapper genreMapper;

    @Override
    public GenreDTO createGenre(GenreDTO genreDTO) {

        Genre cretedGenre = genreMapper.mapToGenre(genreDTO);
        if (genreDTO.getParentGenreId() != null) {

            Genre parentGenre = genreRepository.findById(genreDTO.getParentGenreId())
                    .orElseThrow(() -> new RuntimeException(
                            "Parent Genre not found with ID: " + genreDTO.getParentGenreId()));

            cretedGenre.setParentGenre(parentGenre);
        }

        Genre savedGenre = genreRepository.save(cretedGenre);

        GenreDTO dto = genreMapper.mapToGenreDTO(savedGenre);
        if(savedGenre.getParentGenre() != null){
            dto.setParentGenreId(savedGenre.getParentGenre().getId());
            dto.setParentGenreName(savedGenre.getParentGenre().getGenreName());
        }

        return dto;

    }

}
