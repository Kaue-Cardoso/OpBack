package app.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.Entity.Personagens;
import app.Entity.Tripulacao;
import app.Repository.PersonagensRepository;
import app.Repository.TripulacaoRepository;
import app.exceptions.TripNotFoundException;

@Service
public class TripulacaoService {

	@Autowired
	private PersonagensRepository personagensRepository;
	
	@Autowired
	private TripulacaoRepository tripRepository;
	
	
	
	public String save (Tripulacao trip) {
		this.tripRepository.save(trip);
		return "Tripulacao Cadastrada";
	}
	
	public Tripulacao findById (Long tripId) {
				
		Tripulacao trip = tripRepository.findById(tripId)
			    .orElseThrow(() -> new TripNotFoundException("Herói com ID " + tripId + " não encontrado."));
		
		return trip;
	}
	
	//Double em vez de double (primitivo) porque Double permite que o valor retornado seja null
	public Double recompensaTrip(Long tripId) { //tripID (Variavel Para todas as chamadas)
        // 1. Buscar todos os personagens que pertencem à tripulação com o ID fornecido
		List<Personagens> personagens = personagensRepository.findByTripId(tripId);
		
        // 2. Calcular a soma das recompensas de cada herói
		Double totalRecompensa = personagens.stream()
				.map(personagem -> personagem.getRecompensa())
				.reduce(0.0, Double::sum);
		
		return totalRecompensa;
	
	}

		
}
