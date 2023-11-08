@Entity
public class Book{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Chave primária do book.

    @Column(nullable = false)
    private String title; // Nome do livro

    @Column(nullable = false)
    private String piblicateYear; // Ano de publicação do livro.

    @ManyToOne
    @JoinColumn(name = "Autor_id")
    private Autor idAutor; // Categoria à qual o produto pertence.

    public Long getId() {
        return id;
    }

        public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPiblicateYear() {
        return piblicateYear;
    }

    public void setPiblicateYear(String piblicateYear) {
        this.piblicateYear = piblicateYear;
    }


    
}

