package com.example.demo;

import io.micronaut.validation.Validated;
import jakarta.validation.Valid;

@Validated
public interface ValidatedService {

    <E> void send(@Valid E event);

}
