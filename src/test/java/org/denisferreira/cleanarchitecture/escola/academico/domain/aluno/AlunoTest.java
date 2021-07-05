package org.denisferreira.cleanarchitecture.escola.academico.domain.aluno;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AlunoTest {


    @Test
    void naoDeveAceitarInserirMaisdeDoisTelefones() {
        Aluno aluno = new AlunoFactory()
                .comNomeCPFEmail("teste", "123.456.789-00", "email@email.com")
                .comTelefone("111", "1234-5678")
                .comTelefone("111", "1234-5678")
                .build();
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            aluno.adicionarTelefone("111", "1234-5678");
        });
    }

    @Test
    void naoDevePermitirManipulacaoDaListaDeTelefonesDeForaDaCLasseAluno() {
        Aluno aluno = new AlunoFactory()
                .comNomeCPFEmail("teste", "123.456.789-00", "email@email.com")
                .comTelefone("111", "1234-5678")
                .comTelefone("111", "1234-5678")
                .build();
        aluno.getTelefones().add(new Telefone("111", "1234-5678"));
        Assertions.assertEquals(2, aluno.getTelefones().size());
    }
}