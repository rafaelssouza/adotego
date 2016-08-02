package br.com.senai.pi.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JLayeredPane;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.com.senai.pi.controller.EnderecoController;
import br.com.senai.pi.controller.PessoaController;
import br.com.senai.pi.model.Endereco;

public class Principal extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtEmail;
	private JTextField txtRua;
	private JTextField txtCep;
	private JTextField txtNumRes;
	private JTextField txtBairro;
	private JTextField txtUf;
	private JTextField txtCidade;

	PessoaController pessoa;
	EnderecoController endereco;
	private JTextField txtTelCelular;
	private JTextField txtTelResidencial;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
					frame.setTitle("Sistema Gerenciador de Adoção AdoteGO!");
					frame.setLocationRelativeTo(null);;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Principal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(12, 134, 774, 402);
		contentPane.add(tabbedPane);
		
		JPanel panel_pessoa = new JPanel();
		tabbedPane.addTab("Usuário", null, panel_pessoa, null);
		panel_pessoa.setLayout(null);
		
		JLayeredPane layeredPane_1 = new JLayeredPane();
		layeredPane_1.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		layeredPane_1.setBounds(12, 12, 353, 314);
		panel_pessoa.add(layeredPane_1);
		
		JLabel lblNome = new JLabel("Nome:*");
		lblNome.setBounds(12, 32, 70, 15);
		layeredPane_1.add(lblNome);
		
		JLabel lblTelefone = new JLabel("Tel. Fixo:");
		lblTelefone.setBounds(12, 78, 99, 15);
		layeredPane_1.add(lblTelefone);
		
		JLabel lbltxtEmail = new JLabel("Email:*");
		lbltxtEmail.setBounds(12, 165, 70, 15);
		layeredPane_1.add(lbltxtEmail);
		
		JLabel lblTelCelular = new JLabel("Tel. Celular:");
		lblTelCelular.setBounds(12, 125, 85, 15);
		layeredPane_1.add(lblTelCelular);
		
		txtNome = new JTextField();
		txtNome.setEditable(false);
		txtNome.setBounds(113, 30, 228, 19);
		layeredPane_1.add(txtNome);
		txtNome.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setEditable(false);
		txtEmail.setBounds(113, 163, 228, 19);
		layeredPane_1.add(txtEmail);
		txtEmail.setColumns(10);
		
		txtTelCelular = new JTextField();
		txtTelCelular.setEditable(false);
		txtTelCelular.setBounds(115, 123, 226, 19);
		layeredPane_1.add(txtTelCelular);
		txtTelCelular.setColumns(10);
		
		txtTelResidencial = new JTextField();
		txtTelResidencial.setEditable(false);;
		txtTelResidencial.setBounds(113, 76, 228, 19);
		layeredPane_1.add(txtTelResidencial);
		txtTelResidencial.setColumns(10);
		
		JLayeredPane layeredPane_2 = new JLayeredPane();
		layeredPane_2.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		layeredPane_2.setBounds(377, 12, 380, 314);
		panel_pessoa.add(layeredPane_2);
		
		JLabel lbltxtRua = new JLabel("Rua:*");
		lbltxtRua.setBounds(12, 33, 70, 15);
		layeredPane_2.add(lbltxtRua);
		
		JLabel lbltxtCep = new JLabel("Cep:*");
		lbltxtCep.setBounds(12, 75, 70, 15);
		layeredPane_2.add(lbltxtCep);
		
		JLabel lbltxtBairro = new JLabel("Bairro:*");
		lbltxtBairro.setBounds(12, 124, 70, 15);
		layeredPane_2.add(lbltxtBairro);
		
		JLabel lbltxtCidade = new JLabel("Cidade:*");
		lbltxtCidade.setBounds(12, 165, 70, 15);
		layeredPane_2.add(lbltxtCidade);
		
		JLabel lbltxtUf = new JLabel("Uf:*");
		lbltxtUf.setBounds(226, 165, 41, 15);
		layeredPane_2.add(lbltxtUf);
		
		JLabel lblNmero = new JLabel("Número:*");
		lblNmero.setBounds(226, 75, 70, 15);
		layeredPane_2.add(lblNmero);
		
		txtRua = new JTextField();
		txtRua.setEditable(false);
		txtRua.setBounds(73, 31, 223, 17);
		layeredPane_2.add(txtRua);
		txtRua.setColumns(10);
		
		txtCep = new JTextField();
		txtCep.setEditable(false);
		txtCep.setBounds(73, 73, 114, 19);
		layeredPane_2.add(txtCep);
		txtCep.setColumns(10);
		
		txtNumRes = new JTextField();
		txtNumRes.setEditable(false);
		txtNumRes.setBounds(298, 73, 54, 19);
		layeredPane_2.add(txtNumRes);
		txtNumRes.setColumns(10);
		
		txtBairro = new JTextField();
		txtBairro.setEditable(false);
		txtBairro.setBounds(73, 122, 223, 19);
		layeredPane_2.add(txtBairro);
		txtBairro.setColumns(10);
		
		
		txtUf = new JTextField();
		txtUf.setEditable(false);
		txtUf.setBounds(262, 163, 41, 19);
		layeredPane_2.add(txtUf);
		txtUf.setColumns(10);
		
		txtCidade = new JTextField();
		txtCidade.setEditable(false);
		txtCidade.setBounds(73, 163, 148, 19);
		layeredPane_2.add(txtCidade);
		txtCidade.setColumns(10);
		
		final JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setEnabled(false);
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtNome.getText().equalsIgnoreCase("") || txtTelResidencial.getText().equalsIgnoreCase("") || txtEmail.getText().equalsIgnoreCase("")){
					JOptionPane.showMessageDialog(null, "Campos obrigatórios não foram preenchidos");
				}else{
					pessoa = new PessoaController();
					endereco = new EnderecoController();
					endereco.setCep(txtCep.getText());
					endereco.setBairro(txtBairro.getText());
					endereco.setUf(txtUf.getText());
					endereco.setRua(txtRua.getText());
					endereco.setCidade(txtCidade.getText());
					
					pessoa.setNome(txtNome.getText());
					pessoa.setTelefone(txtTelResidencial.getText());
					pessoa.setEmail(txtEmail.getText());
					pessoa.setEndereco(endereco);
					pessoa.salvar(pessoa);
				}
			}
		});
		btnSalvar.setBounds(248, 338, 117, 25);
		panel_pessoa.add(btnSalvar);
		
		final JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setEnabled(false);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtNome.setText("");
				txtTelResidencial.setText("");
				txtEmail.setText("");
			}
		});
		btnCancelar.setBounds(387, 338, 117, 25);
		panel_pessoa.add(btnCancelar);
		
		JPanel panel_animal = new JPanel();
		tabbedPane.addTab("Animal", null, panel_animal, null);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		layeredPane.setBounds(12, 12, 774, 85);
		contentPane.add(layeredPane);
		
		JButton btnNewButton = new JButton("Pessoa");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtNome.setEditable(true);
				txtTelCelular.setEditable(true);
				txtTelResidencial.setEditable(true);
				txtEmail.setEditable(true);
				txtRua.setEditable(true);
				txtBairro.setEditable(true);
				txtUf.setEditable(true);
				txtCidade.setEditable(true);
				txtNumRes.setEditable(true);
				txtCep.setEditable(true);
				btnSalvar.setEnabled(true);
				btnCancelar.setEnabled(true);
			}
		});
		btnNewButton.setBounds(12, 12, 92, 61);
		layeredPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Animal");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(143, 12, 92, 61);
		layeredPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Sair");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton_2.setBounds(645, 12, 92, 61);
		layeredPane.add(btnNewButton_2);
		
	}
}
