package org.denisferreira.cleanarchitecture.escola;

import org.denisferreira.cleanarchitecture.escola.academico.application.aluno.matricular.LogDeAlunoMatriculado;
import org.denisferreira.cleanarchitecture.escola.academico.application.aluno.matricular.MatricularAluno;
import org.denisferreira.cleanarchitecture.escola.academico.application.aluno.matricular.MatricularAlunoDto;
import org.denisferreira.cleanarchitecture.escola.academico.infra.aluno.AlunoMemoryRepository;
import org.denisferreira.cleanarchitecture.escola.gameficacao.application.GeraSeloAlunoNovato;
import org.denisferreira.cleanarchitecture.escola.gameficacao.infra.selo.SeloEmMemoriaRepository;
import org.denisferreira.cleanarchitecture.escola.shared.domain.PublicadorDeEventos;

public class CLI {

    public static void main(String[] args) {
        PublicadorDeEventos publicadorDeEventos = new PublicadorDeEventos();
        publicadorDeEventos.adicionar(new LogDeAlunoMatriculado());
        publicadorDeEventos.adicionar(new GeraSeloAlunoNovato(new SeloEmMemoriaRepository()));

        String nome = "Fulano";
        String cpf = "123.456.789-00";
        String email = "fulano@mail.com";

        MatricularAluno servico = new MatricularAluno(new AlunoMemoryRepository(), publicadorDeEventos);
        servico.execute(new MatricularAlunoDto(nome, cpf, email));
    }
}
