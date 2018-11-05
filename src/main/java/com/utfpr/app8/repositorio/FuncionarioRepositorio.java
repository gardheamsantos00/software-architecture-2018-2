package com.utfpr.app8.repositorio;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.utfpr.app8.bean.Funcionario;

@Repository
@Transactional
public interface FuncionarioRepositorio extends JpaRepository<Funcionario, Long>{

}
