package org.denisferreira.cleanarchitecture.escola.application.aluno.matricular;

import org.denisferreira.cleanarchitecture.escola.domain.aluno.Aluno;
import org.denisferreira.cleanarchitecture.escola.domain.aluno.AlunoFactory;
import org.denisferreira.cleanarchitecture.escola.domain.aluno.AlunoRepository;

public class MatricularAluno {
    private final AlunoRepository repository;

    public MatricularAluno(AlunoRepository repository) {
        this.repository = repository;
    }

    public void execute(MatricularAlunoDto dados) {
        Aluno aluno = new AlunoFactory()
                .comNomeCPFEmail(dados.getNome(), dados.getCpf(), dados.getEmail())
                .build();
        repository.matricular(aluno);
    }
}
