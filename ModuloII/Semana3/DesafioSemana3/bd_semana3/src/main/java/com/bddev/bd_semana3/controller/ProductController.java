package com.bddev.bd_semana3.controller;

import org.springframework.web.bind.annotation.GetMapping; // Importa a anotação de mapeamento GET.
import org.springframework.web.bind.annotation.PathVariable; // Importa a anotação de variável de caminho.
import org.springframework.web.bind.annotation.RequestMapping; // Importa a anotação de mapeamento de requisição.
import org.springframework.web.bind.annotation.RestController; // Importa a anotação de controlador REST.

import com.bddev.bd_semana3.repository.CategoryRepository;
import com.bddev.bd_semana3.repository.ProductRepository;
import com.bddev.bd_semana3.model.Product;
import com.bddev.bd_semana3.model.Category;

import java.util.List;
import java.util.ArrayList;

@RestController // Indica que esta classe é um controlador REST.
@RequestMapping("/products") // Define o mapeamento base para todas as rotas deste controlador.
public class ProductController{
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public ProductController(ProductRepository productRepository, CategoryRepository categoryRepository){
        this.productRepository = productRepository;
        this .categoryRepository = categoryRepository;
    }


    @GetMapping // Mapeia o método para responder a requisições GET na rota base ("/products").
    public List<Product> getAllProducts(){
        return productRepository.findAll(); // Retorna todos os produtos no banco de dados.
    }

    @GetMapping("/{id}") // Mapeia o método para responder a requisições GET com um parâmetro de caminho (ID).
    public Product getProductById(@PathVariable Long id){
        return productRepository.findById(id).orElse(null); // Busca um produto pelo ID.
    }

    @GetMapping("/category/{categoryId}") // Mapeia o método para responder a requisições GET com um parâmetro de caminho (categoryId).
    public List<Product> getProductsByCategory(@PathVariable Long categoryId){
        Category category = categoryRepository.findById(categoryId).orElse(null); // Busca a categoria pelo ID.
        if (category != null){
            return productRepository.findByCategory(category); // Retorna os produtos da categoria.
        }
        return new ArrayList<>(); // Retorna uma lista vazia se a categoria não for encontrada.
    }

    @GetMapping("/below-price/{maxPrice}") // Mapeia o método para responder a requisições GET com um parâmetro de caminho (maxPrice).
    public List<Product> getProductsBelowMaxPrice(@PathVariable double maxPrice){
        return productRepository.findProductsBelowMaxPrice(maxPrice); // Retorna os produtos com preço abaixo do valor máximo.
    }

    @GetMapping("/order") // Mapeia o método para responder a requisições GET com um parâmetro de caminho (maxPrice).
    public List<Product> getProductsOrder(){
        return productRepository.findProductsOrder(); // Retorna os produtos em orde alfabética
    }
}
