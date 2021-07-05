package org.denisferreira.cleanarchitecture.escola.academico.application.aluno.matricular;

import org.denisferreira.cleanarchitecture.escola.academico.domain.aluno.Aluno;
import org.denisferreira.cleanarchitecture.escola.academico.domain.aluno.AlunoNaoEncontrado;
import org.denisferreira.cleanarchitecture.escola.academico.domain.aluno.AlunoRepository;
import org.denisferreira.cleanarchitecture.escola.shared.domain.CPF;
import org.denisferreira.cleanarchitecture.escola.shared.domain.PublicadorDeEventos;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MatricularAlunoTest {

    @Test
    void alunoDeveserPersistido() throws AlunoNaoEncontrado {
        AlunoRepository repository = new AlunoRepositoryFake();
        PublicadorDeEventos publicadorDeEventos = new PublicadorDeEventos();
        publicadorDeEventos.adicionar(new LogDeAlunoMatriculado());
        MatricularAluno useCase = new MatricularAluno(repository, publicadorDeEventos);
        MatricularAlunoDto dados = new MatricularAlunoDto(
                "Fulano",
                "123.456.789-00",
                "email@email.com"
        );
        useCase.execute(dados);

        Aluno encontrado = repository.buscarPorCPF(new CPF("123.456.789-00"));
        assertEquals("Fulano", encontrado.getNome());
    }
}