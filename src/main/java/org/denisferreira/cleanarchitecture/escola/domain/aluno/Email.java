package org.denisferreira.cleanarchitecture.escola.domain.aluno;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Email {
    private static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
    private String endereco;

    public Email(String endereco) {
        setEndereco(endereco);
    }

    public String getEndereco() {
        return endereco;
    }

    private void setEndereco(String endereco) {
        if (endereco == null || !validarEnderecoEmail(endereco))
            throw new IllegalArgumentException("E-mail inválido");
        this.endereco = endereco;
    }

    private boolean validarEnderecoEmail(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
        return matcher.find();
    }


}
