package com.jai.app.domain.model;

import lombok.*;

import java.time.LocalDate;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
public class Person {
    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
}
