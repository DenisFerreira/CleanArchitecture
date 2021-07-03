package org.denisferreira.cleanarchitecture.escola.domain.aluno;

public interface CifradorDeSenha {
    String cifrarSenha(String senha);

    boolean validarSenhaCifrada(String senhaCifrada, String senha);
}
