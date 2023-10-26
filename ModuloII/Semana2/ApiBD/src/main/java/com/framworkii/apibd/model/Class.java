package com.framworkii.apibd.model;

import jakarta.persistence.*;

@Entity // Anotação que indica que a classe é uma entidade JPA, ou seja, será mapeada para uma tabela no banco de dados.
@Table(name = "classes") // Especifica o nome da tabela no banco de dados para a entidade "com.framworkii.apibd.model.Class".

public class Class {

    @Id // Marca o campo "id" como a chave primária da tabela.
    @GeneratedValue(strategy = GenerationType.AUTO) // Define a estratégia de geração da chave primária como "Auto Increment" (geração automática).

    private long id; // Campo que representa o ID da classe na tabela do banco de dados.

    @Column(name = "title") // Especifica que o campo "title" está mapeado para a coluna "title" na tabela do banco de dados.
    private String title; // Campo que representa o título da classe.

    @Column(name = "description") // Especifica que o campo "description" está mapeado para a coluna "description" na tabela do banco de dados.
    private String description; // Campo que representa a descrição da classe.

    @Column(name = "taught") // Especifica que o campo "taught" está mapeado para a coluna "taught" na tabela do banco de dados.
    private boolean taught; // Campo que representa se a classe foi lecionada ou não.

    public Class() {
        // Construtor padrão vazio, necessário para o JPA.
    }

    public Class(String title, String description, boolean taught) {
        this.title = title;
        this.description = description;
        this.taught = taught;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isTaught() {
        return taught;
    }

    public void setTaught(boolean wasTaught) {
        this.taught = wasTaught;
    }

    @Override
    public String toString() {
        return "com.framworkii.apibd.model.Class [id=" + id + ", title=" + title + ", description=" + description + ", taught=" + taught + "]";
    }
}