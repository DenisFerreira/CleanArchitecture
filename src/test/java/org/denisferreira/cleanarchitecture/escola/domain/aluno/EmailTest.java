package org.denisferreira.cleanarchitecture.escola.domain.aluno;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class EmailTest {
    @Test
    void naoDeveriaCriarEmailsComEnderecosInvalidos() {
        assertThrows(IllegalArgumentException.class, () -> new Email(null));

        assertThrows(IllegalArgumentException.class, () -> new Email(""));

        assertThrows(IllegalArgumentException.class, () -> new Email("emailinvalido"));
    }

    @Test
    void deveCriarEmailscomEnderecoValido() {
        assertDoesNotThrow(() -> new Email("teste@teste.com"));

        assertDoesNotThrow(() -> new Email("teste@teste.com.br"));

        assertDoesNotThrow(() -> new Email("teste._@teste.com"));

    }
}