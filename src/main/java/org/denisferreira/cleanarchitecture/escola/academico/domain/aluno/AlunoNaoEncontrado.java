package org.denisferreira.cleanarchitecture.escola.academico.domain.aluno;

import org.denisferreira.cleanarchitecture.escola.shared.domain.CPF;

import java.sql.SQLException;

public class AlunoNaoEncontrado extends SQLException {
    public AlunoNaoEncontrado(CPF cpf) {
    }
}
