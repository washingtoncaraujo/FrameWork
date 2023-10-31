package com.dev.bd_spring_mysql.database;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.bd_spring_mysql.entidade.Contato;

public interface RepositorioContato extends JpaRepository<Contato,Long> {
    
}
