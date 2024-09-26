package com.example.demo;

import io.micronaut.validation.Validated;
import jakarta.inject.Singleton;
import jakarta.validation.Valid;

@Singleton
@Validated
public class DefaultValidatedService implements ValidatedService {

    @Override
    public <E> void send(@Valid E event) {
        // do nothing
    }

}
