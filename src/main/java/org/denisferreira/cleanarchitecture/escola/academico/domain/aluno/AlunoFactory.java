package org.denisferreira.cleanarchitecture.escola.academico.domain.aluno;

import org.denisferreira.cleanarchitecture.escola.shared.domain.CPF;

public class AlunoFactory {
    private Aluno aluno;

    public AlunoFactory comNomeCPFEmail(String nome, String cpf, String email) {
        this.aluno = new Aluno(new CPF(cpf), nome, new Email(email));
        return this;
    }

    public AlunoFactory comTelefone(String ddd, String numero) {
        this.aluno.adicionarTelefone(ddd, numero);
        return this;
    }

    public Aluno build() {
        return this.aluno;
    }
}
