package com.example.demo;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import jakarta.validation.ConstraintViolationException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@MicronautTest
class WrongValidationTypeTest {

    @Introspected
    static class IntrospectedEvent { }

    static class NonIntrospectedEvent { }

    @Inject
    ValidatedService validatedService;


    @Test
    void validateEvent() {
        assertDoesNotThrow(() -> validatedService.send(new IntrospectedEvent()));

        ConstraintViolationException ex = assertThrows(ConstraintViolationException.class, () -> validatedService.send(new NonIntrospectedEvent()));

        assertTrue(ex.getMessage().contains("NonIntrospectedEvent"));
    }

}
