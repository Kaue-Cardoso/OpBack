package app.Entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
@Entity
public class Org {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank //Para Strings
	private String nome;
	
	@NotEmpty //Para Objetos
	@OneToMany(mappedBy = "organizacoes")
	private List<Personagens> personagens = new ArrayList<>(); //Chamando um objeto Personagem
}
