package org.denisferreira.cleanarchitecture.escola;

import org.denisferreira.cleanarchitecture.escola.application.aluno.matricular.MatricularAluno;
import org.denisferreira.cleanarchitecture.escola.application.aluno.matricular.MatricularAlunoDto;
import org.denisferreira.cleanarchitecture.escola.infra.aluno.AlunoMemoryRepository;

public class CLI {

    public static void main(String[] args) {
        String nome = "Fulano";
        String cpf = "123.456.789-00";
        String email = "fulano@mail.com";

        MatricularAluno servico = new MatricularAluno(new AlunoMemoryRepository());
        servico.execute(new MatricularAlunoDto(nome, cpf, email));
    }
}
