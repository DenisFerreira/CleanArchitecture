package org.denisferreira.cleanarchitecture.escola.shared.domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

// VALUE OBJECT
public class CPF {
    private static final Pattern VALID_CPF_NUMBER_REGEX =
            Pattern.compile("^\\d{3}\\x2E\\d{3}\\x2E\\d{3}\\x2D\\d{2}$", Pattern.CASE_INSENSITIVE);
    private String numero;

    public CPF(String numero) {
        setNumero(numero);
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        if (numero == null || !validarCPF(numero))
            throw new IllegalArgumentException("CPF inválido");
        this.numero = numero;
    }

    private boolean validarCPF(String cpfStr) {
        Matcher matcher = VALID_CPF_NUMBER_REGEX.matcher(cpfStr);
        return matcher.find();
    }
}
