package com.utfpr.app8.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.utfpr.app8.bean.Funcionario;
import com.utfpr.app8.repositorio.FuncionarioRepositorio;

@Service
public class FuncionarioService {
	
	@Autowired
	FuncionarioRepositorio repo;

	
	public Funcionario salvarFuncionario(Funcionario funcionario) {
		repo.save(funcionario);
		
		return funcionario;
	}
	
	public Collection<Funcionario> buscarTodos(){
		return repo.findAll();
	}
	
	
	public void excluir(Funcionario funcionario){
		repo.delete(funcionario);
	}
	
	public Funcionario buscarPorID(Long id){
		return repo.findOne(id);
	}
	
	
	public Funcionario alterar(Funcionario funcionario){
		 return repo.save(funcionario);
}
	
}
