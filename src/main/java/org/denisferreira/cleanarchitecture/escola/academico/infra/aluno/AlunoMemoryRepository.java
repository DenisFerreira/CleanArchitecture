package org.denisferreira.cleanarchitecture.escola.academico.infra.aluno;

import org.denisferreira.cleanarchitecture.escola.academico.domain.aluno.Aluno;
import org.denisferreira.cleanarchitecture.escola.academico.domain.aluno.AlunoNaoEncontrado;
import org.denisferreira.cleanarchitecture.escola.academico.domain.aluno.AlunoRepository;
import org.denisferreira.cleanarchitecture.escola.shared.domain.CPF;

import java.util.ArrayList;
import java.util.List;

public class AlunoMemoryRepository implements AlunoRepository {

    private final List<Aluno> matriculados = new ArrayList<>();

    @Override
    public void matricular(Aluno aluno) {
        this.matriculados.add(aluno);
    }

    @Override
    public Aluno buscarPorCPF(CPF cpf) throws AlunoNaoEncontrado {
        return this.matriculados.stream()
                .filter(a -> a.getCpf().equals(cpf.getNumero()))
                .findFirst()
                .orElseThrow(() -> new AlunoNaoEncontrado(cpf));
    }

    @Override
    public List<Aluno> listarTodosAlunosMatriculados() {
        return this.matriculados;
    }
}
