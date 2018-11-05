package com.utfpr.app8.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.utfpr.app8.bean.Funcionario;
import com.utfpr.app8.service.FuncionarioService;

@RestController
public class FuncionarioController {

	@Autowired
	FuncionarioService service;
	
	
	@RequestMapping(value="/cadastrarFuncionario" , 
			method = RequestMethod.POST, 
			produces=org.springframework.http.MediaType.APPLICATION_JSON_VALUE,
			consumes=org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Funcionario> cadastrarFuncionario(@RequestBody Funcionario funcionario){
		Funcionario funcionarioSalvo = service.salvarFuncionario(funcionario);
	  
	  return new ResponseEntity<>(funcionarioSalvo , HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/buscaFuncionario", 
			method=RequestMethod.GET , 
			produces=org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<Funcionario>> buscaTodos(){
		
		Collection<Funcionario> funcionarioBuscadas = service.buscarTodos();
		
		return new ResponseEntity<>(funcionarioBuscadas, HttpStatus.OK);
	}
	

	@RequestMapping(value="/removerFuncionario/{id}", 
			method=RequestMethod.DELETE)
	public ResponseEntity<Collection<Funcionario>> removerFuncionario(@PathVariable Long id){
		
		Funcionario funcionarioEncontrada =  service.buscarPorID(id);
		if(funcionarioEncontrada == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}		
		service.excluir(funcionarioEncontrada);
		return new ResponseEntity<>( HttpStatus.OK);
	}
	
	
	
	@RequestMapping(value="/alterarFuncionario", 
			method=RequestMethod.PUT,
			consumes=org.springframework.http.MediaType.APPLICATION_JSON_VALUE,
			produces=org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Funcionario> alterarFuncionario(@RequestBody Funcionario funcionario){
		
		Funcionario funcionarioAlterada = service.alterar(funcionario);
		
		return new ResponseEntity<>(funcionarioAlterada, HttpStatus.OK);
}
	
	
}
