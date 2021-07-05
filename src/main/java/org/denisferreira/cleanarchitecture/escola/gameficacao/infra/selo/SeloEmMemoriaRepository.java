package org.denisferreira.cleanarchitecture.escola.gameficacao.infra.selo;

import org.denisferreira.cleanarchitecture.escola.gameficacao.domain.selo.Selo;
import org.denisferreira.cleanarchitecture.escola.gameficacao.domain.selo.SeloRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SeloEmMemoriaRepository implements SeloRepository {
    private final List<Selo> selos = new ArrayList<>();

    @Override
    public List<Selo> getListSelo(String cpf) {
        return this.selos
                .stream()
                .filter(s -> s.getCpfDoAluno().getNumero().equals(cpf))
                .collect(Collectors.toList());
    }

    @Override
    public void adicionarSelo(Selo selo) {
        this.selos.add(selo);
    }
}
