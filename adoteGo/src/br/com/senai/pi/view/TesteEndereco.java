package br.com.senai.pi.view;

import javax.swing.JOptionPane;

import br.com.senai.pi.controller.EnderecoController;

public class TesteEndereco {

	public static void main(String[] args) {
		EnderecoController endControle = new EnderecoController();

		String uf = JOptionPane.showInputDialog("Nome:");
		String cidade = JOptionPane.showInputDialog("Cidade:");
		String bairro = JOptionPane.showInputDialog("Bairro:");

		endControle.setUf(uf);
		endControle.setCidade(cidade);
		endControle.setBairro(bairro);

		System.out.println("UF: " + endControle.getUf() + "\nCidade"
				+ endControle.getCidade() + "\nBairro:"
				+ endControle.getBairro());
	}

}
