package org.denisferreira.cleanarchitecture.escola.infra.aluno;

import org.denisferreira.cleanarchitecture.escola.domain.aluno.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AlunoRepositoryJDBC implements AlunoRepository {
    private final Connection connection;

    public AlunoRepositoryJDBC(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void matricular(Aluno aluno) {
        String sql = "INSERT INTO ALUNO VALUES(?, ?, ?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, aluno.getCpf());
            ps.setString(2, aluno.getNome());
            ps.setString(3, aluno.getEmail());
            ps.execute();
            ps.close();

            sql = "INSERT INTO TELEFONE VALUES(?, ?)";
            ps = connection.prepareStatement(sql);
            for (Telefone telefone : aluno.getTelefones()) {
                ps.setString(1, telefone.getDdd());
                ps.setString(2, telefone.getNumero());
                ps.execute();
            }
            ps.close();

        } catch (SQLException throwables) {
            throw new RuntimeException(throwables);
        }
    }

    @Override
    public Aluno buscarPorCPF(CPF cpf) {
        String sql = "SELECT id, nome, email FROM ALUNO WHERE cpf = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, cpf.getNumero());

            ResultSet resultSet = ps.executeQuery();
            if (!resultSet.next())
                throw new AlunoNaoEncontrado(cpf);

            String nome = resultSet.getString("nome");
            Email email = new Email(resultSet.getString("email"));
            Aluno encontrado = new Aluno(cpf, nome, email);

            Long id = resultSet.getLong("id");
            sql = "SELECT ddd, numero FROM TELEFONE WHERE aluno_id = ?";
            ps = connection.prepareStatement(sql);
            ps.setLong(1, id);
            resultSet = ps.executeQuery();
            while (resultSet.next()) {
                String ddd = resultSet.getString("ddd");
                String numero = resultSet.getString("numero");
                encontrado.adicionarTelefone(ddd, numero);
            }
            return encontrado;
        } catch (SQLException throwables) {
            throw new RuntimeException(throwables);
        }
    }

    @Override
    public List<Aluno> listarTodosAlunosMatriculados() {
        String sql = "SELECT id, nome, email, cpf FROM ALUNO";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery();
            List<Aluno> lista = new ArrayList<>();
            while (resultSet.next()) {
                String nome = resultSet.getString("nome");
                Email email = new Email(resultSet.getString("email"));
                CPF cpf = new CPF(resultSet.getString("cpf"));
                Aluno encontrado = new Aluno(cpf, nome, email);

                Long id = resultSet.getLong("id");
                sql = "SELECT ddd, numero FROM TELEFONE WHERE aluno_id = ?";
                ps = connection.prepareStatement(sql);
                ps.setLong(1, id);
                ResultSet telefoneResultSet = ps.executeQuery();
                while (telefoneResultSet.next()) {
                    String ddd = telefoneResultSet.getString("ddd");
                    String numero = telefoneResultSet.getString("numero");
                    encontrado.adicionarTelefone(ddd, numero);
                }
                lista.add(encontrado);
                telefoneResultSet.close();
            }
            resultSet.close();
            return lista;
        } catch (SQLException throwables) {
            throw new RuntimeException(throwables);
        }
    }
}
