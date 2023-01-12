package com.driver.RequestDto;

import com.driver.models.Genre;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;

@Data
@Builder
@AllArgsConstructor
public class BookRequestDto {
    private String name;

    private Genre genre;

    private String authorId;

    @Column(columnDefinition = "TINYINT(1)")
    private boolean available;

}

