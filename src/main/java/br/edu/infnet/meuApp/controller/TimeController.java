package br.edu.infnet.meuApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.meuApp.model.Time;
import br.edu.infnet.meuApp.repository.TimeRepository;

@RestController
public class TimeController {

	@Autowired
	private TimeRepository  timeRepository;
	
	@RequestMapping(value = "/time/all", method = RequestMethod.GET)
	public List<Time> findAll(){
		return timeRepository.findAll();
	}
	
	@RequestMapping(value = "/time/save", method = RequestMethod.GET)
	public Time save(@RequestParam("nome")String nome) {
		Time time = timeRepository.save(nome);
		return time;
	}
	
	@RequestMapping(value = "/time/update", method = RequestMethod.GET)
	public Time update(@RequestParam("id")Integer id,  @RequestParam("nome")String nome) {
		Time time = timeRepository.upDate(id, nome);
		return time;
	}
	
	@RequestMapping(value = "/time/delete", method = RequestMethod.GET)
	public String deletar(@RequestParam("id")Integer id) {
		timeRepository.delete(id);
		return "O time " + id + " foi deletado com sucesso!!!!";
	}
}
