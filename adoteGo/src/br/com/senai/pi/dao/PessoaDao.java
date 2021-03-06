package br.com.senai.pi.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.senai.pi.controller.EnderecoController;
import br.com.senai.pi.controller.PessoaController;
import br.com.senai.pi.model.Endereco;
import br.com.senai.pi.model.Pessoa;

public class PessoaDao {

	public void save(Pessoa pessoa) {

		/*
		 * Isso é uma sql comum, os ? são os parâmetros que nós vamos adicionar
		 * na base de dados
		 */

		String sql = "INSERT INTO pessoa(nome,telefone,email,cep, uf, rua, cidade, bairro)"
				+ " VALUES(?,?,?,?,?,?,?,?)";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			// Cria uma conexão com o banco
			conn = ConnectionFactory.createConnectionToMySQL();

			// Cria um PreparedStatment, classe usada para executar a query
			pstm = conn.prepareStatement(sql);

			// Adiciona o valor do primeiro parâmetro da sql
			pstm.setString(1, pessoa.getNome());

			pstm.setString(2, pessoa.getTelefone());

			pstm.setString(3, pessoa.getEmail());

			pstm.setString(4, pessoa.getEndereco().getCep());

			pstm.setString(5, pessoa.getEndereco().getUf());

			pstm.setString(6, pessoa.getEndereco().getRua());

			pstm.setString(7, pessoa.getEndereco().getCidade());

			pstm.setString(8, pessoa.getEndereco().getBairro());

			// Executa a sql para inserção dos dados
			pstm.execute();

		} catch (Exception e) {

			e.printStackTrace();
		} finally {

			// Fecha as conexões

			try {
				if (pstm != null) {

					pstm.close();
				}

				if (conn != null) {
					conn.close();
				}

			} catch (Exception e) {

				e.printStackTrace();
			}
		}
	}

	public void removeById(int id) {

		String sql = "DELETE FROM pessoa WHERE id = ?";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = ConnectionFactory.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			pstm.setLong(1, id);

			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				if (pstm != null) {

					pstm.close();
				}

				if (conn != null) {
					conn.close();
				}

			} catch (Exception e) {

				e.printStackTrace();
			}
		}
	}

	public void update(Pessoa pessoa) {

		String sql = "UPDATE pessoa SET nome = ?, telefone = ?, email = ?, rua = ?, cidade = ?,"
				+ " uf = ?, bairro = ?, cep = ? WHERE id = ?";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			// Cria uma conexão com o banco
			conn = ConnectionFactory.createConnectionToMySQL();

			// Cria um PreparedStatment, classe usada para executar a query
			pstm = conn.prepareStatement(sql);

			pstm.setString(1, pessoa.getNome());

			pstm.setString(2, pessoa.getTelefone());

			pstm.setString(3, pessoa.getEmail());

			pstm.setString(4, pessoa.getEndereco().getRua());

			pstm.setString(5, pessoa.getEndereco().getCidade());

			pstm.setString(6, pessoa.getEndereco().getUf());

			pstm.setString(7, pessoa.getEndereco().getBairro());

			pstm.setString(8, pessoa.getEndereco().getCep());

			pstm.setInt(9, pessoa.getId());
			// Executa a sql para inserção dos dados
			pstm.execute();

		} catch (Exception e) {

			e.printStackTrace();
		} finally {

			// Fecha as conexões

			try {
				if (pstm != null) {

					pstm.close();
				}

				if (conn != null) {
					conn.close();
				}

			} catch (Exception e) {

				e.printStackTrace();
			}
		}
	}

	public List<Pessoa> getPessoas() {

		String sql = "SELECT * FROM pessoa";

		List<Pessoa> pessoas = new ArrayList<Pessoa>();

		Connection conn = null;
		PreparedStatement pstm = null;
		// Classe que vai recuperar os dados do banco de dados
		ResultSet rset = null;

		try {
			conn = ConnectionFactory.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			// Enquanto existir dados no banco de dados, faça
			while (rset.next()) {

				Pessoa pessoa = new Pessoa();

				// Recupera o id do banco e atribui ele ao objeto
				pessoa.setId(rset.getInt("id"));

				// Recupera o nome do banco e atribui ele ao objeto
				pessoa.setNome(rset.getString("nome"));

				pessoa.setTelefone(rset.getString("telefone"));
				// Recupera a idade do banco e atribui ele ao objeto
				pessoa.setEmail(rset.getString("email"));

				// Adiciono o contato recuperado, a lista de contatos
				pessoas.add(pessoa);
			}
		} catch (Exception e) {

			e.printStackTrace();
		} finally {

			try {

				if (rset != null) {

					rset.close();
				}

				if (pstm != null) {

					pstm.close();
				}

				if (conn != null) {
					conn.close();
				}

			} catch (Exception e) {

				e.printStackTrace();
			}
		}

		return pessoas;
	}

	// Pesquisa por id
	public Pessoa getPessoaByID(Integer id) {

		String sql = "SELECT * FROM pessoa WHERE id = ?";

		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		PessoaController pessoa = new PessoaController();
		EnderecoController endereco = new EnderecoController();
		// Classe que vai recuperar os dados do banco de dados

		try {

			conn = ConnectionFactory.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);
			pstm.setLong(1, id);
			rset = pstm.executeQuery();

			// Enquanto existir dados no banco de dados, faça
			rset.next();

			pessoa.setId(rset.getInt("id"));

			pessoa.setNome(rset.getString("nome"));
			pessoa.setTelefone(rset.getString("telefone"));
			pessoa.setEmail(rset.getString("email"));
			// Endereço

			endereco.setRua(rset.getString("rua"));
			endereco.setBairro(rset.getString("bairro"));
			endereco.setCidade(rset.getString("cidade"));
			endereco.setCep(rset.getString("cep"));
			endereco.setUf(rset.getString("uf"));

			pessoa.setEndereco(endereco);

		} catch (Exception e) {

			e.printStackTrace();
		} finally {

			try {

				if (pstm != null) {

					pstm.close();
				}

				if (conn != null) {
					conn.close();
				}

			} catch (Exception e) {

				e.printStackTrace();
			}
		}

		return pessoa;
	}

}
