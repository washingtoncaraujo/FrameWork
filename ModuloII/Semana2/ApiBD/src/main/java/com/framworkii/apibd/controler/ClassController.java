package com.framworkii.apibd.controler;

import java.util.List; // Importa a classe List para trabalhar com coleções de classes.
import java.util.Optional; // Importa a classe Optional para tratar valores possivelmente nulos.
import org.springframework.beans.factory.annotation.Autowired; // Importa a anotação para injetar dependências.
import org.springframework.http.HttpStatus; // Importa a classe HttpStatus para definir códigos de status HTTP.
import org.springframework.http.ResponseEntity; // Importa a classe ResponseEntity para encapsular respostas HTTP.
import org.springframework.web.bind.annotation.*; // Importa as anotações para mapear endpoints HTTP.
import com.framworkii.apibd.model.Class; // Importa a classe de modelo Class.
import com.framworkii.apibd.repository.ClassRepository; // Importa o repositório de classes.

@CrossOrigin(origins = "http://localhost:8081") // Permite solicitações de origens diferentes.
@RestController // Indica que esta classe é um controlador REST.
@RequestMapping("/api") // Mapeia todas as URLs para "/api".

public class ClassController {

    @Autowired // Injeta o repositório de classes.
    ClassRepository classRepository;

    @GetMapping("/classes")
    public ResponseEntity<List<Class>> getAllClasses(@RequestParam(required = false) String title) {
        try {
            List<Class> classes = classRepository.findAll(); // Obtém todas as classes do repositório.

            if (title != null) {
                classes = classRepository.findByTitleContaining(title); // Filtra classes com base no título.
            }

            if (classes.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT); // Retorna "Sem Conteúdo" se não houver classes.
            }

            return new ResponseEntity<>(classes, HttpStatus.OK); // Retorna as classes encontradas com status OK.
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR); // Retorna erro interno do servidor em caso de exceção.
        }
    }

    @GetMapping("/classes/{id}")
    public ResponseEntity<Class> getClassById(@PathVariable("id") long id) {
        Optional<Class> classData = classRepository.findById(id); // Obtém uma classe pelo ID.

        if (classData.isPresent()) {
            return new ResponseEntity<>(classData.get(), HttpStatus.OK); // Retorna a classe encontrada com status OK.
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Retorna "Não Encontrado" se a classe não existe.
        }
    }

    @PostMapping("/classes")
    public ResponseEntity<Class> createClass(@RequestBody Class classEntity) {
        try {
            Class newClass = classRepository.save(new Class(classEntity.getTitle(), classEntity.getDescription(), classEntity.isTaught()));
            return new ResponseEntity<>(newClass, HttpStatus.CREATED); // Cria e retorna uma nova classe com status "Criado".
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR); // Retorna erro interno do servidor em caso de exceção.
        }
    }

    @PutMapping("/classes/{id}")
    public ResponseEntity<Class> updateClass(@PathVariable("id") long id, @RequestBody Class classEntity) {
        Optional<Class> classData = classRepository.findById(id); // Obtém uma classe pelo ID.

        if (classData.isPresent()) {
            Class existingClass = classData.get();
            existingClass.setTitle(classEntity.getTitle());
            existingClass.setDescription(classEntity.getDescription());
            existingClass.setTaught(classEntity.isTaught());
            return new ResponseEntity<>(classRepository.save(existingClass), HttpStatus.OK); // Atualiza e retorna a classe com status OK.
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Retorna "Não Encontrado" se a classe não existe.
        }
    }

    @DeleteMapping("/classes/{id}")
    public ResponseEntity<HttpStatus> deleteClass(@PathVariable("id") long id) {
        try {
            classRepository.deleteById(id); // Exclui uma classe pelo ID.
            return new ResponseEntity<>(HttpStatus.NO_CONTENT); // Retorna "Sem Conteúdo" após a exclusão bem-sucedida.
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); // Retorna erro interno do servidor em caso de exceção.
        }
    }

    @DeleteMapping("/classes")
    public ResponseEntity<HttpStatus> deleteAllClasses() {
        try {
            classRepository.deleteAll(); // Exclui todas as classes.
            return new ResponseEntity<>(HttpStatus.NO_CONTENT); // Retorna "Sem Conteúdo" após a exclusão bem-sucedida.
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); // Retorna erro interno do servidor em caso de exceção.
        }
    }

    @GetMapping("/classes/taught")
    public ResponseEntity<List<Class>> findByTaught() {
        try {
            List<Class> taughtClasses = classRepository.findByTaught(true); // Obtém as classes lecionadas.

            if (taughtClasses.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT); // Retorna "Sem Conteúdo" se nenhuma classe lecionada for encontrada.
            }
            return new ResponseEntity<>(taughtClasses, HttpStatus.OK); // Retorna as classes lecionadas com status OK.
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); // Retorna erro interno do servidor em caso de exceção.
        }
    }
}
