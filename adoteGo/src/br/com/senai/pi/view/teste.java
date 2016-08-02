package br.com.senai.pi.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import br.com.senai.pi.controller.PessoaController;
import java.awt.FlowLayout;
import javax.swing.JLayeredPane;
import javax.swing.border.TitledBorder;
import javax.swing.JMenu;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class teste extends JFrame {
	PessoaController pessoa = new PessoaController();

	private JTextField txtNome;
	private JTextField txtTelefone;
	private JTextField txtEmail;

	private JPanel contentPane;
	private JLayeredPane layeredPane;
	private JMenu mnMenu;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					teste frame = new teste();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public teste() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 510, 380);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		layeredPane = new JLayeredPane();
		layeredPane.setBorder(new TitledBorder(null, "AdoteGo",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		layeredPane.setBounds(12, 0, 484, 342);
		contentPane.add(layeredPane);

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(130, 215, 78, 25);
		layeredPane.add(btnSalvar);

		txtEmail = new JTextField();
		txtEmail.setBounds(114, 159, 114, 19);
		layeredPane.add(txtEmail);
		txtEmail.setColumns(10);

		txtTelefone = new JTextField();
		txtTelefone.setBounds(114, 128, 114, 19);
		layeredPane.add(txtTelefone);
		txtTelefone.setColumns(10);

		txtNome = new JTextField();
		txtNome.setBounds(114, 97, 114, 19);
		layeredPane.add(txtNome);
		txtNome.setColumns(10);

		JLabel labelEmail = new JLabel("Email:");
		labelEmail.setBounds(12, 161, 42, 15);
		layeredPane.add(labelEmail);

		JLabel labelTelefone = new JLabel("Telefone:");
		labelTelefone.setBounds(12, 130, 67, 15);
		layeredPane.add(labelTelefone);

		JLabel labelNome = new JLabel("Nome:");
		labelNome.setBounds(12, 99, 45, 15);
		layeredPane.add(labelNome);
		
		mnMenu = new JMenu("Menu");
		mnMenu.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
			}
		});
		mnMenu.setBounds(12, 24, 95, 19);
		layeredPane.add(mnMenu);
		
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pessoa.setNome(txtNome.getText());
				pessoa.setTelefone(txtTelefone.getText());
				pessoa.setEmail(txtEmail.getText());
				pessoa.salvar(pessoa);
			}
		});

	}
}
