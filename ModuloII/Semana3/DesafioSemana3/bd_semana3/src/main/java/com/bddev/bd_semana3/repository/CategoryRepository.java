package com.bddev.bd_semana3.repository;

import com.bddev.bd_semana3.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CategoryRepository extends JpaRepository<Category, Long>{

 // Consulta personalizada usando JPQL (JPA Query Language) para encontrar categorias com um nome específico.

 // Nesta consulta, o ORM (JPA) fará a consulta automaticamente com base na sintaxe JPQL.

 Category findCategoryByName(String catesgoryName);

 // Consulta personalizada usando SQL nativo para encontrar categorias com um nome específico.

 // Esta consulta usa diretamente a sintaxe do MySQL.

 @Query(value = "SELECT x FROM category c WHERE c.name = :categoryName", nativeQuery = true)

  Category findCategoryByNameSQL(@Param("categoryName") String categoryName);

}
