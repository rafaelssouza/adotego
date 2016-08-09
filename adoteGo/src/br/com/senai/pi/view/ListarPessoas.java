package br.com.senai.pi.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.com.senai.pi.controller.PessoaController;
import br.com.senai.pi.model.Pessoa;

public class ListarPessoas extends JFrame {

	/**
	 * Create the frame.
	 */
	private JPanel painelFundo;
	private JPanel painelBotoes;
	private JTable tabela;
	private JScrollPane barraRolagem;
	private JButton btInserir;
	private JButton btExcluir;
	private JButton btEditar;
	private DefaultTableModel modelo = new DefaultTableModel();

	public ListarPessoas() {
		super("Pessoas");
		criaJTable();
		criaJanela();
	}

	public void criaJanela() {
		btInserir = new JButton("Inserir");
		btExcluir = new JButton("Excluir");
		btEditar = new JButton("Editar");
		painelBotoes = new JPanel();
		barraRolagem = new JScrollPane(tabela);
		painelFundo = new JPanel();
		painelFundo.setLayout(new BorderLayout());
		painelFundo.setLocale(null);
		painelFundo.add(BorderLayout.CENTER, barraRolagem);
		painelBotoes.add(btInserir);
		painelBotoes.add(btEditar);
		painelBotoes.add(btExcluir);
		painelFundo.add(BorderLayout.SOUTH, painelBotoes);

		getContentPane().add(painelFundo);
		setSize(700, 450);
		setVisible(true);
		btInserir.addActionListener(new BtInserirListener());
		btEditar.addActionListener(new BtEditarListener());
	//	btExcluir.addActionListener(new BtExcluirListener());
	}

	private void criaJTable() {
		tabela = new JTable(modelo);
		modelo.addColumn("Id");
		modelo.addColumn("Nome");
		modelo.addColumn("Telefone");
		modelo.addColumn("Email");
		tabela.getColumnModel().getColumn(0).setPreferredWidth(10);
		tabela.getColumnModel().getColumn(1).setPreferredWidth(120);
		tabela.getColumnModel().getColumn(2).setPreferredWidth(80);
		tabela.getColumnModel().getColumn(3).setPreferredWidth(120);
		pesquisar(modelo);
	}

	private class BtInserirListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			Principal princ = new Principal(modelo);
			princ.setVisible(true);
		}
	}

	public static void pesquisar(DefaultTableModel modelo) {
		modelo.setNumRows(0);
		PessoaController pessoa = new PessoaController();

		for (Pessoa p : pessoa.listarPessoas()) {
			modelo.addRow(new Object[] { p.getId(), p.getNome(),
					p.getTelefone(), p.getEmail() });
		}
	}
	

	private class BtEditarListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			int linhaSelecionada = -1;
			linhaSelecionada = tabela.getSelectedRow();
			if (linhaSelecionada >= 0) {
				Long idContato = (Long) tabela.getValueAt(linhaSelecionada, 0);
				PessoaController pController = new PessoaController();
				
				Principal.getInstance().atualizarPrincipal(pController.getPessoaPorId(idContato));
				
				//AtualizarContato ic = new AtualizarContato(modelo, idContato, linhaSelecionada);
				//ic.setVisible(true);
				dispose();
			} else {
				JOptionPane.showMessageDialog(null, "É necesário selecionar uma linha.");
			}
		}
	}

}
