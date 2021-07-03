package org.denisferreira.cleanarchitecture.escola.application.indicacao;

import org.denisferreira.cleanarchitecture.escola.domain.aluno.Aluno;

public interface EnviarEmailIndicacao {
    void enviarPara(Aluno indicado);
}
