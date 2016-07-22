package br.com.senai.pi.controller;

import br.com.senai.pi.model.Endereco;

public class EnderecoController extends Endereco{
	
	Endereco endereco = new Endereco();
	
	public void setEndereco(Endereco end){
		endereco.setUf(end.getUf());
		endereco.setCidade(end.getCidade());
		endereco.setBairro(end.getBairro());
		endereco.setRua(end.getRua());
		endereco.setCep(end.getCep());
		
	}

}
