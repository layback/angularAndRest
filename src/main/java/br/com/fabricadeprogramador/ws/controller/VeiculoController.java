package br.com.fabricadeprogramador.ws.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.fabricadeprogramador.ws.model.Veiculo;
import br.com.fabricadeprogramador.ws.service.VeiculoService;

@RestController
public class VeiculoController {
	
	@Autowired
	private VeiculoService veiculoService;
	
	@RequestMapping(method=RequestMethod.POST, value="/veiculos", consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Veiculo> cadastrarVeiculo(@RequestBody Veiculo veiculo) {
		Veiculo veiculoCadastrado = veiculoService.cadastrar(veiculo);
		return new ResponseEntity<Veiculo>(veiculoCadastrado, HttpStatus.CREATED);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/veiculos", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<Veiculo>> buscarTodosVeiculos() {
		Collection<Veiculo> veiculosRetornados = veiculoService.buscarTodos();
		return new ResponseEntity<>(veiculosRetornados, HttpStatus.OK);
	}
}
