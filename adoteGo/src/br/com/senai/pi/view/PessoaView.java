package br.com.senai.pi.view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import br.com.senai.pi.controller.PessoaController;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PessoaView extends JPanel {

	/**
	 * Create the panel.
	 */
	public PessoaView() {
		setLayout(null);

		JLabel labelNome = new JLabel("Nome:");
		labelNome.setBounds(12, 31, 70, 15);
		add(labelNome);

		JLabel labelTelefone = new JLabel("Telefone:");
		labelTelefone.setBounds(12, 78, 70, 15);
		add(labelTelefone);

		JLabel labelEmail = new JLabel("Email:");
		labelEmail.setBounds(12, 119, 70, 15);
		add(labelEmail);

	}
}
