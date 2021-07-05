package org.denisferreira.cleanarchitecture.escola.academico.application.aluno.matricular;

import org.denisferreira.cleanarchitecture.escola.academico.domain.aluno.Aluno;
import org.denisferreira.cleanarchitecture.escola.academico.domain.aluno.AlunoFactory;
import org.denisferreira.cleanarchitecture.escola.academico.domain.aluno.AlunoMatriculado;
import org.denisferreira.cleanarchitecture.escola.academico.domain.aluno.AlunoRepository;
import org.denisferreira.cleanarchitecture.escola.shared.domain.CPF;
import org.denisferreira.cleanarchitecture.escola.shared.domain.PublicadorDeEventos;

public class MatricularAluno {
    private final AlunoRepository repository;
    private final PublicadorDeEventos publicadorDeEventos;

    public MatricularAluno(AlunoRepository repository, PublicadorDeEventos publicadorDeEventos) {
        this.repository = repository;
        this.publicadorDeEventos = publicadorDeEventos;
    }

    public void execute(MatricularAlunoDto dados) {
        Aluno aluno = new AlunoFactory()
                .comNomeCPFEmail(dados.getNome(), dados.getCpf(), dados.getEmail())
                .build();
        repository.matricular(aluno);
        publicadorDeEventos.publicar(new AlunoMatriculado(new CPF(dados.getCpf())));
    }
}
