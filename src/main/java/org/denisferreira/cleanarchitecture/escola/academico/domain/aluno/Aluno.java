package org.denisferreira.cleanarchitecture.escola.academico.domain.aluno;

// Entidade são modelos que possuem características
// únicas e podem ser diferenciados

import org.denisferreira.cleanarchitecture.escola.shared.domain.CPF;

import java.util.ArrayList;
import java.util.List;

//AGGREGATE ROOT
public class Aluno {
    private final CPF cpf;
    private final String nome;
    private final Email email;
    private final List<Telefone> telefones = new ArrayList<>();
    private String senha;

    public Aluno(CPF cpf, String nome, Email email) {
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
    }

    public void adicionarTelefone(String ddd, String numero) {

        if (this.telefones.size() >= 2) {
            throw new IllegalArgumentException("Número máximo de telefones atingido");
        }
        this.telefones.add(new Telefone(ddd, numero));
    }

    public String getCpf() {
        return cpf.getNumero();
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email.getEndereco();
    }

    public List<Telefone> getTelefones() {
        return new ArrayList<>(this.telefones);
    }
}
