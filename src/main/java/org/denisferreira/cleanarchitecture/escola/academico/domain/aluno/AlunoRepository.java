package org.denisferreira.cleanarchitecture.escola.academico.domain.aluno;

import org.denisferreira.cleanarchitecture.escola.shared.domain.CPF;

import java.util.List;

public interface AlunoRepository {

    void matricular(Aluno aluno);

    Aluno buscarPorCPF(CPF cpf) throws AlunoNaoEncontrado;

    List<Aluno> listarTodosAlunosMatriculados();
}
