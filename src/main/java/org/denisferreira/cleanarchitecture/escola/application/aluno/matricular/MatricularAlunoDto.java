package org.denisferreira.cleanarchitecture.escola.application.aluno.matricular;

public class MatricularAlunoDto {
    private final String nome;
    private final String cpf;
    private final String email;

    public MatricularAlunoDto(String nome, String cpf, String email) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }
}
