package org.denisferreira.cleanarchitecture.escola.gameficacao.domain.selo;

import java.util.List;

public interface SeloRepository {
    List<Selo> getListSelo(String cpf);

    void adicionarSelo(Selo selo);
}
