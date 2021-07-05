package org.denisferreira.cleanarchitecture.escola.gameficacao.application;

import org.denisferreira.cleanarchitecture.escola.gameficacao.domain.selo.Selo;
import org.denisferreira.cleanarchitecture.escola.gameficacao.domain.selo.SeloRepository;
import org.denisferreira.cleanarchitecture.escola.shared.domain.CPF;
import org.denisferreira.cleanarchitecture.escola.shared.domain.Evento;
import org.denisferreira.cleanarchitecture.escola.shared.domain.Ouvinte;
import org.denisferreira.cleanarchitecture.escola.shared.domain.TipoDeEvento;

public class GeraSeloAlunoNovato extends Ouvinte {
    private final SeloRepository repository;

    public GeraSeloAlunoNovato(SeloRepository repository) {
        this.repository = repository;
    }

    @Override
    protected void reageAo(Evento evento) {
        CPF cpfDoAluno = (CPF) evento.informacoes().get("cpf");
        if (cpfDoAluno == null) {
            throw new RuntimeException("Falha ao gerar selo do Aluno, CPF não encontrado!");
        }
        String nomeSeloAluno = "Novato";
        Selo selo = new Selo(nomeSeloAluno, cpfDoAluno);
        this.repository.adicionarSelo(selo);
        System.out.println(String.format("Aluno com CPF %s ganhou o selo %s",
                cpfDoAluno.getNumero(),
                nomeSeloAluno));
    }

    @Override
    protected boolean deveProcessar(Evento evento) {
        return evento.tipo() == TipoDeEvento.ALUNO_MATRICULADO;
    }
}
