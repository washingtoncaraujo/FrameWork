package com.bddev.bd_semana3.repository;

import com.bddev.bd_semana3.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long>{  // Consulta personalizada usando JPQL (JPA Query Language) para encontrar categorias com um nome específico.

 Category findCategoryByName(String catesgoryName);  // Consulta personalizada usando SQL nativo para encontrar categorias com um nome específico.


 // Esta consulta usa diretamente a sintaxe do MySQL.

 @Query(value = "SELECT * FROM category c WHERE c.name = :categoryName", nativeQuery = true)
  Category findCategoryByNameSQL(@Param("categoryName") String categoryName);

 @Query(value = "SELECT * FROM category ORDER BY name", nativeQuery = true)
 List<Category> findCategoryByOrderName();


 @Query(value = "")
 List<Category> findCategoriesByMinProductCount(@RequestParam("minProductCount") int minProductCount);

 @Query(value = "SELECT * FROM category WHERE name LIKE %:desc%" , nativeQuery = true)
 List<Category> findCategoriesByDescName(@Param("desc") String desc);

}

