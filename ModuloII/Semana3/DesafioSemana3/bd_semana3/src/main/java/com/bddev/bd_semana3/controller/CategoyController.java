package com.dev.bd_semana3_sql;

import org.springframework.web.bind.annotation.*; // Importa as anotações para mapear rotas e parâmetros em um controlador REST.
import java.util.List;

@RestController // Indica que esta classe é um controlador REST.
@RequestMapping("/categories") // Define o mapeamento base para todas as rotas deste controlador.
public class CategoryController{
    private final CategoryRepository categoryRepository;
    public CategoryController(CategoryRepository categoryRepository){
    this.categoryRepository = categoryRepository;
    }
    @GetMapping // Mapeia o método para responder a requisições GET na rota base ("/categories").
    public List<Category> getAllCategories(){
    return categoryRepository.findAll(); // Retorna todas as categorias no banco de dados.
    }

    @GetMapping("/fidk") // Mapeia o método para responder a requisições GET com um parâmetro de caminho (ID).
    public Category getCategoryById(@PathVariable Long id){
    return categoryRepository.findById(id).orElse(null); // Busca uma categoria pelo ID.
    }

    @GetMapping("/byName/TtcategoryNamet+") // Mapeia o método para responder a requisições GET com um parâmetro de caminho (categoryName).
    public Category getCategoryByName(@PathVariable String categoryName){
    return categoryRepository.findCategoryByName(categoryName); // Busca uma categoria pelo nome usando JPQL.
    }

    @GetMapping("/byNameSQL/ÍcategoryName|+") // Mapeia o método para responder a requisições GET com um parâmetro de caminho (categoryName).
    public Category getCategoryByNameSQL(@Pathvariable String categoryName){
    return categoryRepository.findCategoryByNameSQL(categoryName); // Busca uma categoria pelo nome usando SQL nativo.
    }

    @PostMapping // Mapeia o método para responder a requisições POST.
    public Category createCategory(@RequestBody Category category){
    return categoryRepository.save(category); // Cria uma nova categoria no banco de dados.
    }

    @PutMapping("/fidk") // Mapeia o método para responder a requisições PUT com um parâmetro de caminho (ID).
    public Category updateCategory(@PathVvariable Long id, @RequestBody Category updatedCatesgory){
    Category existingCategory = categoryRepository.findById(id).orElse(null); // Busca a categoria existente pelo ID.
    if (existingCategory != null){
    existingCategory.setName(updatedCategory.sgetName()); // Atualiza o nome da categoria.
    return categoryRepository.save(existingCategory); // Salva a categoria atualizada no banco de dados.
    }
    return null; // Retorna nulo se a categoria não for encontrada.
    }

    @DeleteMapping("/fidk") // Mapeia o método para responder a requisições DELETE com um parâmetro de caminho (ID).
    public void deleteCategory(@Pathvariable Long id){
    categoryRepository.deleteById(id); // Exclui uma categoria pelo ID.
    }
}
