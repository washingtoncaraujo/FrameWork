package com.framworkii.apibd.repository;


import java.util.List; // Importa a classe List para trabalhar com coleções de classes.
import org.springframework.data.jpa.repository.JpaRepository; // Importa a interface JpaRepository do Spring Data JPA.
import com.framworkii.apibd.model.Class; // Importa a classe de modelo Class para especificar a entidade relacionada.

public interface ClassRepository extends JpaRepository<Class, Long> {
    // Declaração da interface ClassRepository que estende JpaRepository para operações CRUD em Class.

    List<Class> findByTaught(boolean taught);
    // Método de busca personalizado que retorna uma lista de Class com base no status "taught" (lecionada).

    List<Class> findByTitleContaining(String title);
    // Método de busca personalizado que retorna uma lista de Class com base no título que contém uma sequência específica.
}