package org.denisferreira.cleanarchitecture.escola.gameficacao.domain.selo;

import org.denisferreira.cleanarchitecture.escola.shared.domain.CPF;

public class Selo {
    private String nome;
    private CPF cpfDoAluno;

    public Selo(String nome, CPF cpfDoAluno) {
        this.nome = nome;
        this.cpfDoAluno = cpfDoAluno;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public CPF getCpfDoAluno() {
        return cpfDoAluno;
    }

    public void setCpfDoAluno(CPF cpfDoAluno) {
        this.cpfDoAluno = cpfDoAluno;
    }
}
