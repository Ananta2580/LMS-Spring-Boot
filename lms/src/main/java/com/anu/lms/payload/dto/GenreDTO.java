package com.anu.lms.payload.dto;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GenreDTO {

    private Long Id;

    @NotBlank(message = "Genre code is mandatory")
    private String genreCode;

    @NotBlank(message = "Genre name is mandatory")
    private String genreName;

    @Size(max = 500, message = "Description must not exceed more than 500 characters.")
    private String genreDescription;

    @Min(value = 0, message = "Display Order cannot be in negative.")
    private Integer displayOrder = 0;

    private Boolean active;

    private Long parentGenreId;

    private String parentGenreName;

    private List<GenreDTO> subGenre;

    private Long bookCount;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
