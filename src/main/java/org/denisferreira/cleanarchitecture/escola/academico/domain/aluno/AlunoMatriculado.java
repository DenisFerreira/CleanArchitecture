package org.denisferreira.cleanarchitecture.escola.academico.domain.aluno;

import org.denisferreira.cleanarchitecture.escola.shared.domain.CPF;
import org.denisferreira.cleanarchitecture.escola.shared.domain.Evento;
import org.denisferreira.cleanarchitecture.escola.shared.domain.TipoDeEvento;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

public class AlunoMatriculado implements Evento {

    private final LocalDateTime momento;
    private final CPF cpf;

    public AlunoMatriculado(CPF cpfDoAluno) {
        momento = LocalDateTime.now();
        this.cpf = cpfDoAluno;
    }

    @Override
    public LocalDateTime momento() {
        return this.momento;
    }

    @Override
    public TipoDeEvento tipo() {
        return TipoDeEvento.ALUNO_MATRICULADO;
    }

    @Override
    public Map<String, Object> informacoes() {
        return Map.of("cpf", cpf);
    }

    public String getCPF() {
        return this.cpf.getNumero();
    }

    public String getMomento() {
        return DateTimeFormatter.ofPattern("dd/MM/yyy HH:mm").format(this.momento);
    }
}
