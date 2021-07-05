package org.denisferreira.cleanarchitecture.escola.academico.application.indicacao;

import org.denisferreira.cleanarchitecture.escola.academico.domain.aluno.Aluno;

public interface EnviarEmailIndicacao {
    void enviarPara(Aluno indicado);
}
