package main.java.com.dev.bd_semana3_sql.repository;


import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository; // Importa a interface de repositório do Spring Data JPA.
import org.springframework.data.jpa.repository.Query; // Importa a anotação de consulta personalizada do Spring Data JPA.
import org.springframework.data.repository.query.Param; // Importa a anotação de parâmetro da consulta personalizada.
import com.example.mysql.model .Category; // Importa a classe de modelo Category.

public interface CategoryRepository extends JpaRepository<Category, Long>{

// Consulta personalizada usando JPQL (JPA Query Language) para encontrar categorias com um nome específico.

// Nesta consulta, o ORM (JPA) fará a consulta automaticamente com base na sintaxe JPQL.

Category findCatesgoryByName(String catesgoryName);

// Consulta personalizada usando SQL nativo para encontrar categorias com um nome específico.

// Esta consulta usa diretamente a sintaxe do MySQL.

@Query(value = "SELECT x FROM category c WHERE c.name = :categoryName", nativeQuery = true)

 Category findCatesgoryByNameSQL(@Param("categoryName") String categoryName);

}

