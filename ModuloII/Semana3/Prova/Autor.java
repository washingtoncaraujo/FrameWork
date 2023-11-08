@Entity
public class Autor{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Chave primária do Autor.

    @Column(nullable = false)
    private String name; // Nome do Autor

    @Column(nullable = false)
    private String birthYear; // Ano de nascimento.

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(String birthYear) {
        this.birthYear = birthYear;
    }
   
}