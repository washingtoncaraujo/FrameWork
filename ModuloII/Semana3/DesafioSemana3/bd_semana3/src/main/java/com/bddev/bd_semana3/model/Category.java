package com.bddev.bd_semana3.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;

@Entity
public class Category{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Define a geração automática do ID da entidade.
    private Long id; // Representa o ID exclusivo da categoria.

    @Column(nullable = false)
    private String name; // Representa o nome da categoria, que não pode ser nulo.

    // Getters e setters para as propriedades da entidade Category.

    public Long setId(){
    return id;
    }
    public void setId(Long id){
        this.id = id;
    }

    public String getName(){
    return name;
    }

    public void setName(String name){
    this.name = name;
    }
}