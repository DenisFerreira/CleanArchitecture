package org.denisferreira.cleanarchitecture.escola.domain.aluno;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Telefone {
    private static final Pattern VALID_TELEFONE_NUMBER_REGEX =
            Pattern.compile("^\\d{4,5}-\\d{4}", Pattern.CASE_INSENSITIVE);
    private static final Pattern VALID_TELEFONE_DDD_REGEX =
            Pattern.compile("^\\d{2,3}", Pattern.CASE_INSENSITIVE);
    private String ddd;
    private String numero;

    public Telefone(String ddd, String numero) {
        setNumero(numero, ddd);
    }

    public void setNumero(String numero, String ddd) {
        if (numero == null || !validarNumero(numero) ||
                ddd == null || !validarDDD(ddd))
            throw new IllegalArgumentException("telefone inválido");
        this.numero = numero;
        this.ddd = ddd;
    }

    private boolean validarNumero(String cpfStr) {
        Matcher matcher = VALID_TELEFONE_NUMBER_REGEX.matcher(cpfStr);
        return matcher.find();
    }

    private boolean validarDDD(String cpfStr) {
        Matcher matcher = VALID_TELEFONE_DDD_REGEX.matcher(cpfStr);
        return matcher.find();
    }

    public String getNumero() {
        return numero;
    }

    public String getDdd() {
        return ddd;
    }
}
