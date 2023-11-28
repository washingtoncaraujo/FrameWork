package com.dev.backend_render.model;
import jakarta.persistence.Entity; // Importa a anotação de entidade do Jakarta Persistence.
import jakarta.persistence.GeneratedValue; // Importa a anotação de geração automática.
import jakarta.persistence.GenerationType; // Importa a estratégia de geração automática.
import jakarta.persistence.Id; // Importa a anotação de chave primária.
import jakarta.persistence.Column; // Importa a anotação de coluna.
import jakarta.persistence.ManyToOne; // Importa a anotação de relacionamento Many-to-One.
import jakarta.persistence.JoinColumn; // Importa a anotação de coluna de junção.


@Entity
public class Cliente{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Chave primária do produto.

    @Column(nullable = false)
    private String usuario; // Nome do produto, não pode ser nulo.

    @Column(nullable = false)
    private String origem; // origem da viagem

    @Column(nullable = false)
    private String destino; // destino da viagem

    @Column(nullable = false)
    private String data; // data da viagem

    @Column(nullable = false)
    private String hora; // hora da vaigem

    @Column(nullable = false)
    private String aprovada; // a viagem foi aprovada?

    public Long getId() {
        return id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getAprovada() {
        return aprovada;
    }

    public void setAprovada(String aprovada) {
        this.aprovada = aprovada;
    }



}

