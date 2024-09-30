package app.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.Entity.Tripulacao;
import app.Service.TripulacaoService;
import jakarta.validation.Valid;


@RestController
@RequestMapping("/OnePieceBack/Tripulacao")
public class TripulacaoController {
	@Autowired
	private TripulacaoService tripulacaoService;
	
	@PostMapping("/save")
	public ResponseEntity<String> save(@Valid @RequestBody Tripulacao trip){
		try {
			String mensagem = this.tripulacaoService.save(trip);
					return new ResponseEntity<>(mensagem, HttpStatus.OK);
		}
		catch (Exception e){
			return new ResponseEntity<>("Deu Erro"+e.getMessage(), HttpStatus.BAD_REQUEST );
		}
	}
	@GetMapping("/findById/{id}")
	public ResponseEntity<Tripulacao> findById(@PathVariable Long tripId){
		try {
			Tripulacao tripulacao = this.tripulacaoService.findById(tripId);
			return new ResponseEntity<>(tripulacao, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST );
		}
	}
	
}
