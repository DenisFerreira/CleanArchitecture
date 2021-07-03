package org.denisferreira.cleanarchitecture.escola.domain.aluno;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TelefoneTest {
    @Test
    void naoDeveriaCriarTelefonesInvalidos() {
        assertThrows(IllegalArgumentException.class, () -> new Telefone(null, ""));

        assertThrows(IllegalArgumentException.class, () -> new Telefone("", null));

        assertThrows(IllegalArgumentException.class, () -> new Telefone("emailinvalido", "1234-1234"));
    }

    @Test
    void deveCriarTelefonesValido() {
        assertDoesNotThrow(() -> new Telefone("11", "12345-6789"));
        assertDoesNotThrow(() -> new Telefone("011", "12345-6789"));
        assertDoesNotThrow(() -> new Telefone("11", "1234-5678"));
        assertDoesNotThrow(() -> new Telefone("011", "1234-5678"));

    }
}