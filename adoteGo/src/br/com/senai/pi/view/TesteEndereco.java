package br.com.senai.pi.view;

import br.com.senai.pi.controller.EnderecoController;

public class TesteEndereco {

	public static void main(String[] args) {
		EnderecoController endControle = new EnderecoController();
		
		endControle.setUf("UfTeste");
		endControle.setCidade("Cidade");
		endControle.setBairro("Bairro");
		endControle.setEndereco(endControle);
		
		System.out.println(endControle.getBairro());
	}

}
