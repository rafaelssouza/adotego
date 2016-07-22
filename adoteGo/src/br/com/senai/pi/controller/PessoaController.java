package br.com.senai.pi.controller;

import br.com.senai.pi.model.Pessoa;

public class PessoaController extends Pessoa {
	Pessoa pessoa = new Pessoa();

	public void setPessoa(String nome, String telefone, String email) {
		pessoa.setNome(nome);
		pessoa.setTelefone(telefone);
		pessoa.setEmail(email);
	}

	public Pessoa getPessoa() {
		return pessoa;
	}
}
