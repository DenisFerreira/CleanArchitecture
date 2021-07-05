package org.denisferreira.cleanarchitecture.escola.academico.application.aluno.matricular;

import org.denisferreira.cleanarchitecture.escola.academico.domain.aluno.AlunoMatriculado;
import org.denisferreira.cleanarchitecture.escola.shared.domain.Evento;
import org.denisferreira.cleanarchitecture.escola.shared.domain.Ouvinte;

public class LogDeAlunoMatriculado extends Ouvinte {

    @Override
    protected void reageAo(Evento evento) {
        System.out.println(String.format("Aluno com CPF %s matriculado em %s",
                ((AlunoMatriculado) evento).getCPF(),
                ((AlunoMatriculado) evento).getMomento()));
    }

    @Override
    protected boolean deveProcessar(Evento evento) {
        return evento instanceof AlunoMatriculado;
    }
}
