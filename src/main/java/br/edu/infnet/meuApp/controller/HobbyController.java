package br.edu.infnet.meuApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.meuApp.model.Hobby;
import br.edu.infnet.meuApp.repository.HobbyRepository;

@RestController
public class HobbyController {

	@Autowired
	private HobbyRepository hobbyRepository;
	
	@RequestMapping(value = "/hobby/all", method = RequestMethod.GET)
	public List<Hobby> findAll(){
		return hobbyRepository.findAll();
	}
	
	@RequestMapping(value = "/hobby/save", method = RequestMethod.GET)
	public Hobby save(@RequestParam("nome")String nome){
		Hobby hobby = hobbyRepository.save(nome);
		return hobby;
	}
	
	@RequestMapping(value = "/hobby/update", method = RequestMethod.GET)
	public Hobby update(@RequestParam("id") Integer id, @RequestParam("nome")String nome) {
		Hobby hobby = hobbyRepository.upDate(id, nome);
		return hobby;
	}
	
	@RequestMapping(value = "/hobby/delete", method = RequestMethod.GET)
	public String deletar(@RequestParam("id")Integer id) {
		hobbyRepository.delete(id);
		return "O hobby " + id + " foi deletado com sucesso!";
	}
	
}
