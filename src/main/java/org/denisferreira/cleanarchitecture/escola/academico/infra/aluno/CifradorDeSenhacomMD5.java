package org.denisferreira.cleanarchitecture.escola.academico.infra.aluno;

import org.denisferreira.cleanarchitecture.escola.academico.domain.aluno.CifradorDeSenha;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class CifradorDeSenhacomMD5 implements CifradorDeSenha {
    @Override
    public String cifrarSenha(String senha) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(senha.getBytes());
            byte[] digest = md.digest();
            return DatatypeConverter
                    .printHexBinary(digest);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("erro na cifragem de senha com MD5");
        }
    }

    @Override
    public boolean validarSenhaCifrada(String senhaCifrada, String senha) {
        return senhaCifrada.equals(cifrarSenha(senha));
    }
}
