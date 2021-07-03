package org.denisferreira.cleanarchitecture.escola.domain.aluno;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CPFTest {
    @Test
    void naoDeveriaCriarCPFsInvalidos() {
        assertThrows(IllegalArgumentException.class, () -> new CPF(null));

        assertThrows(IllegalArgumentException.class, () -> new CPF(""));

        assertThrows(IllegalArgumentException.class, () -> new CPF("123"));
    }

    @Test
    void deveCriarCPFValido() {
        assertDoesNotThrow(() -> new CPF("111.222.333-44"));

    }
}