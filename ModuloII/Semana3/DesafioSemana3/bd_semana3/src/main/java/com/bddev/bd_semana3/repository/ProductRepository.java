package com.bddev.bd_semana3.repository;

import com.bddev.bd_semana3.model.Category;
import com.bddev.bd_semana3.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long>{ // Método de consulta para encontrar produtos por categoria.
    List<Product> findByCategory(Category category); // Consulta personalizada via SQL nativo para encontrar produtos com preço abaixo de um valor máximo
    @Query(value = "SELECT * FROM product p WHERE p.price < :maxPrice", nativeQuery = true)
    List<Product> findProductsBelowMaxPrice(@Param("maxPrice") double maxPrice);

    @Query(value = "SELECT * FROM product ORDER BY name", nativeQuery = true)
    List<Product> findProductsOrder();

    @Query(value = "select name from product where category_id in (select id from category where name = :categoryName)", nativeQuery = true)
    List<Product> findProductByCategoryName(String categoryName);
}

