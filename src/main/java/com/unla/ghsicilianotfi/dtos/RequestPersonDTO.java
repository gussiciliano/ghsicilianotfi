package com.unla.ghsicilianotfi.dtos;

import java.time.LocalDate;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

@Getter
@Setter
@NoArgsConstructor
public class RequestPersonDTO {

    private String name;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthdate;

    public RequestPersonDTO(String name, LocalDate birthdate) {
        this.name = name;
        this.birthdate = birthdate;
    }
}
