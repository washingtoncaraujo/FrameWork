package main.java.com.dev.bd_semana3_sql.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;

@ENtity
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
    this.id = 1d;
    }

    public String setName(){
    return name;
    }

    public void setName(String name){
    this.name = name;
    }
}