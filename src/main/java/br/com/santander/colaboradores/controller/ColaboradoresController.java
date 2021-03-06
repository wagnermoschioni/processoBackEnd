package br.com.santander.colaboradores.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.santander.colaboradores.controller.dto.ColaboradorDto;
import br.com.santander.colaboradores.modelo.Colaborador;
import br.com.santander.colaboradores.repositiry.ColaboradorRepository;


@RestController
@RequestMapping("/colaboradores")
public class ColaboradoresController {

	@Autowired
	private ColaboradorRepository colaboradorRepository;

	/*
	 * metodo para listar os colaboradores gravados em banco
	 */
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<ColaboradorDto> listarColaboradores() {

		List<Colaborador> colaboradores = colaboradorRepository.findAll();
		return ColaboradorDto.converter(colaboradores);
   
	}
	
	/*
	 * metodo para listar colaborador pelo campo nome
	 */	
	@GetMapping("/{nome}")
	@ResponseStatus(HttpStatus.OK)
	public List<ColaboradorDto> listarColaboradorPorNome(String nomeColaborador) {
		List<Colaborador> colaboradores = colaboradorRepository.findByNome(nomeColaborador);
		return ColaboradorDto.converter(colaboradores);

	}
	
	/*
	 * metodo para gravar um novo colaborador no banco de dados
	 */
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Colaborador salvarColaborador(@RequestBody Colaborador colaboradorRequest) {
		Colaborador colaboradorSalvo = colaboradorRepository.save(colaboradorRequest);
		return colaboradorSalvo;
	}
	
	/*
	 * metodo para atualizar o cadastro do colaborador no banco de dados
	 */	
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Colaborador atualizarDadosColaborador(@RequestBody Colaborador colaboradorRequest) {
		Colaborador colaboradorAtualizado = colaboradorRepository.save(colaboradorRequest);
		return colaboradorAtualizado;
	}
	
	
}
