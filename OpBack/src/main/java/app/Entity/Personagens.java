package app.Entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
public class Personagens {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	private String nome;
	
	private String vulgo;
	
	private Double recompensa;
	
	@NotBlank
	private String posicao;
	
	@NotNull //Para Numeros
	private int primeiraAparicao;
	
	//@NotEmpty
	@ManyToMany
	@JoinTable(
			name = "personagens_habilidade",
			joinColumns = @JoinColumn(name = "personagens_id"),
			inverseJoinColumns = @JoinColumn(name = "habilidade_id")
			)
	private List<Habilidade> habilidades;
	
	@ManyToOne
    @JoinColumn(name = "tripulacao_id")
	private Tripulacao tripulacao;
	
	@ManyToOne
    @JoinColumn(name = "organizacoes_id")
	private Org organizacoes;
	
	//Criar Metodo que exiga ou org ou tripulacao
}
