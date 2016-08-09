package br.com.senai.pi.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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

	public void removeById(Long id) {

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

		String sql = "UPDATE pessoa SET nome = ?, telefone = ?, email = ?"
				+ " WHERE id = ?";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			// Cria uma conexão com o banco
			conn = ConnectionFactory.createConnectionToMySQL();

			// Cria um PreparedStatment, classe usada para executar a query
			pstm = conn.prepareStatement(sql);

			// Adiciona o valor do primeiro parâmetro da sql
			pstm.setString(1, pessoa.getNome());
			// Adicionar o valor do segundo parâmetro da sql
			pstm.setString(2, pessoa.getTelefone());
			// Adiciona o valor do terceiro parâmetro da sql
			pstm.setString(3, pessoa.getEmail());

			pstm.setLong(4, pessoa.getId());

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
				pessoa.setId(rset.getLong("id"));

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
	public Pessoa getPessoaByID(Long id) {

		String sql = "SELECT * FROM pessoa WHERE id = ?";

		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		Pessoa pessoa = new Pessoa();
		// Classe que vai recuperar os dados do banco de dados

		try {
			
			conn = ConnectionFactory.createConnectionToMySQL();

			pstm = conn.prepareStatement(sql);
			pstm.setLong(1, id);
			rset = pstm.executeQuery();
			
			
			// Enquanto existir dados no banco de dados, faça
			while (rset.next()) {

				// Recupera o id do banco e atribui ele ao objeto
				//pessoa.setId(rset.getLong("id"));

				// Recupera o nome do banco e atribui ele ao objeto
				pessoa.setNome(rset.getString("nome"));

				pessoa.setTelefone(rset.getString("telefone"));
				// Recupera a idade do banco e atribui ele ao objeto
				pessoa.setEmail(rset.getString("email"));

			}
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
