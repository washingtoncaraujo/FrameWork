package com.bddev.bd_semana3.repository;

import com.bddev.bd_semana3.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long>{  // Consulta personalizada usando JPQL (JPA Query Language) para encontrar categorias com um nome específico.

 // Nesta consulta, o ORM (JPA) fará a consulta automaticamente com base na sintaxe JPQL.

 Category findCategoryByName(String catesgoryName);  // Consulta personalizada usando SQL nativo para encontrar categorias com um nome específico.

 // Esta consulta usa diretamente a sintaxe do MySQL.

 @Query(value = "SELECT * FROM category c WHERE c.name = :categoryName", nativeQuery = true)
  Category findCategoryByNameSQL(@Param("categoryName") String categoryName);

 @Query(value = "SELECT * FROM category ORDER BY name", nativeQuery = true)
 List<Category> findCategoryByOrderName();


 @Query(value = "SELECT name FROM  category WHERE  2 <= (SELECT  * FROM  product JOIN category ON product.category_id = category.id)" , nativeQuery = true)
    List<Category> findCategoriesByMinProductCount(int minProductCount);
}

