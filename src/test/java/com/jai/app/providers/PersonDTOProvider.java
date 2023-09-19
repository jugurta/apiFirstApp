package com.jai.app.providers;

import com.jai.app.application.rest.dto.PersonDTO;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.time.LocalDate;
import java.util.stream.Stream;

public class PersonDTOProvider implements ArgumentsProvider {

    PersonDTO personDTO = new PersonDTO(1, "John", "Smith", LocalDate.of(2000, 10, 20));

    public PersonDTO getPersonDTO() {
        return personDTO;
    }

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
        return Stream.of(Arguments.of(personDTO));
    }
}
