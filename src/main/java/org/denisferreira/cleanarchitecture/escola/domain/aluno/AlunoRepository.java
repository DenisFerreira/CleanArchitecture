package org.denisferreira.cleanarchitecture.escola.domain.aluno;

import java.util.List;

public interface AlunoRepository {

    void matricular(Aluno aluno);

    Aluno buscarPorCPF(CPF cpf) throws AlunoNaoEncontrado;

    List<Aluno> listarTodosAlunosMatriculados();
}
