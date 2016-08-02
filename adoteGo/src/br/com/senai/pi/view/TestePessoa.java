package br.com.senai.pi.view;

import br.com.senai.pi.controller.PessoaController;
import br.com.senai.pi.model.Pessoa;

public class TestePessoa {

	public static void main(String[] args) {
		PessoaController pessoa = new PessoaController();
		/*
		pessoa.setNome("Segundo Nome Modificação Controller");
		pessoa.setTelefone("84547894");
		pessoa.setEmail("segundo@teste.com");
		//pessoa.setId(1L);
		pessoa.salvar(pessoa);
		*/
		for(Pessoa pes: pessoa.listarPessoas()){
			System.out.println("ID: "+pes.getId());
			System.out.println("NOME: "+pes.getNome());
			System.out.println("TELEFONE "+pes.getTelefone());
			System.out.println("EMAIL: "+pes.getEmail()+"\n");
			
		}
		pessoa.removerPorId(1L);
	}

}
