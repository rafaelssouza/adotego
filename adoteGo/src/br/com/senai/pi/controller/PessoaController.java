package br.com.senai.pi.controller;

import java.util.ArrayList;
import java.util.List;

import br.com.senai.pi.dao.PessoaDao;
import br.com.senai.pi.model.Pessoa;

public class PessoaController extends Pessoa {
	PessoaDao dao = new PessoaDao();

	public void salvar(Pessoa p) {
		dao.save(p);
		System.out.println("Pessoa Salva com sucesso");
	}

	public void update(Pessoa p) {
		dao.update(p);
		System.out.println("Pessoa Atualizada com Sucesso");
	}

	public List<Pessoa> listarPessoas() {
		List<Pessoa> pessoas = new ArrayList<Pessoa>();

		for (Pessoa pessoa : dao.getPessoas()) {
			pessoas.add(pessoa);
		}

		return pessoas;
	}
	
	public void removerPorId(Long id){
		dao.removeById(id);
		System.out.println("Pessoa removida com sucesso");
	}
	
	public Pessoa getPessoaPorId(Long id){
		Pessoa p = new Pessoa();
		p = dao.getPessoaByID(id);
		return p;	
	}
}
