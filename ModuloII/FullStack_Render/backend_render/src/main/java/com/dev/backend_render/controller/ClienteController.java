package com.dev.backend_render;
import org.springframework.web.bind.annotation.GetMapping; // Importa a anotação de mapeamento GET.
import org.springframework.web.bind.annotation.PathVariable; // Importa a anotação de variável de caminho.
import org.springframework.web.bind.annotation.RequestMapping; // Importa a anotação de mapeamento de requisição.
import org.springframework.web.bind.annotation.RestController; // Importa a anotação de controlador REST.



@RestController // Indica que esta classe é um controlador REST.
@RequestMapping("/cliente") // Define o mapeamento base para todas as rotas deste controlador.
public class ClienteController{
    private final ClienteRepository clienteRepository;
    
    public ClienteController(ClienteRepository clioenteRepository){
        this.clienteRepository = clioenteRepository;
        
    }

    @GetMapping // Mapeia o método para responder a requisições GET na rota base ("/products").
    public List<Cliente> getAllClientes(){
        return clienteRepository.findAll(); // Retorna todos os produtos no banco de dados.
    }

    @GetMapping("/{id}") // Mapeia o método para responder a requisições GET com um parâmetro de caminho (ID).
    public Cliente getClienteById(@PathVariable Long id){
        return clienteRepository.findById(id).orElse(null); // Busca um produto pelo ID.
    }

        
}
