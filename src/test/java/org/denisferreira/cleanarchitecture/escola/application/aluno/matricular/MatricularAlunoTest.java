package org.denisferreira.cleanarchitecture.escola.application.aluno.matricular;

import org.denisferreira.cleanarchitecture.escola.domain.aluno.Aluno;
import org.denisferreira.cleanarchitecture.escola.domain.aluno.AlunoNaoEncontrado;
import org.denisferreira.cleanarchitecture.escola.domain.aluno.AlunoRepository;
import org.denisferreira.cleanarchitecture.escola.domain.aluno.CPF;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MatricularAlunoTest {

    @Test
    void alunoDeveserPersistido() throws AlunoNaoEncontrado {
        AlunoRepository repository = new AlunoRepositoryFake();
        MatricularAluno useCase = new MatricularAluno(repository);
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