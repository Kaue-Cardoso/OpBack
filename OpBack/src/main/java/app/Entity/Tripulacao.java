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
public class Tripulacao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank //Para Strings
	private String nome;
	
	@NotBlank
	private String navio;
	
	@NotEmpty //Para Objetos
	@OneToMany(mappedBy = "tripulacao")
	private List<Personagens> personagens = new ArrayList<>(); //Chamando um objeto Personagem
}
