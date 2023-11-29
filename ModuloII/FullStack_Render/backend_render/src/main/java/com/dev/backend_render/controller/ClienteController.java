package com.dev.backend_render.controller;
import com.dev.backend_render.repository.ClienteRepository;
import com.dev.backend_render.model.Cliente;
import org.springframework.http.StreamingHttpOutputMessage;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController // Indica que esta classe é um controlador REST.
@RequestMapping("/Viagens") // Define o mapeamento base para todas as rotas deste controlador.
public class ClienteController{
    private final ClienteRepository clienteRepository;

    public ClienteController(ClienteRepository clienteRepository){
        this.clienteRepository = clienteRepository;

    }

    @GetMapping // Mapeia o método para responder a requisições GET na rota base ("/products").
    public List<Cliente> getAllClientes(){
        return clienteRepository.findAll(); // Retorna todos os produtos no banco de dados.
    }

    @GetMapping("/{id}") // Mapeia o método para responder a requisições GET com um parâmetro de caminho (ID).
    public Cliente getClienteById(@PathVariable Long id){
        return clienteRepository.findById(id).orElse(null); // Busca um produto pelo ID.
    }

    @DeleteMapping("/{id}") // Mapeia o método para responder a requisições DELETE com um parâmetro de caminho (ID).
    public void deleteCliente(@PathVariable Long id){
        clienteRepository.deleteById(id); // Exclui uma categoria pelo ID.
    }

    @PostMapping // Mapeia o método para responder a requisições POST.
    public Cliente createCliente(@RequestBody Cliente cliente){
        return clienteRepository.save(cliente); // Cria um cliente no banco de dados.
    }

    @PutMapping("/{id}") // Mapeia o método para responder a requisições PUT com um parâmetro de caminho (ID).
    public Cliente updateCliente(@PathVariable Long id, @RequestBody Cliente updatedClinete){
        Cliente existingCliente = clienteRepository.findById(id).orElse(null); // Busca a categoria existente pelo ID.
        if (existingCliente != null){
            existingCliente.setUsuario(updatedClinete.getUsuario()); // Atualiza o nome da categoria.
            return clienteRepository.save(existingCliente); // Salva a categoria atualizada no banco de dados.
        }
        return null; // Retorna nulo se a categoria não for encontrada.
    }

}
