package br.com.fabricadeprogramador.ws.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fabricadeprogramador.ws.model.Veiculo;
import br.com.fabricadeprogramador.ws.repository.VeiculoRepository;

@Service
public class VeiculoService {
	
	@Autowired
	private VeiculoRepository veiculoRepository;
	
	public Veiculo cadastrar(Veiculo veiculo) {
		return veiculoRepository.save(veiculo);
	}
	
	public Collection<Veiculo> buscarTodos() {
		return veiculoRepository.findAll();
	}


}
