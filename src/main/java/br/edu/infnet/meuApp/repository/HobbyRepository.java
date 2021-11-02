package br.edu.infnet.meuApp.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import br.edu.infnet.meuApp.model.Hobby;

@Component
public class HobbyRepository {

	private static List<Hobby> hobbyList = new ArrayList<>();
	
	public Hobby save(String nome) {
		Integer id = hobbyList.size();
		Hobby hobby = new Hobby();
		hobby.setId(id);
		hobby.setNome(nome);
		
		hobbyList.add(hobby);
		return hobby;
	}
	
	public Hobby findById(Integer id) {
		if(id == null) {
			return null;
		}
		for(Hobby h : hobbyList) {
			if(h.getId().equals(id)) {
				return h;
			}
		}
		return null;
	}
	
	public Hobby upDate(Integer id, String nome) {
		Hobby hobby = findById(id);
		if(hobby != null) {
			hobby.setNome(nome);
		}
		return hobby;
	}
	
	public List<Hobby> findAll(){
		return hobbyList;
	}
	
	public void  delete(Integer id) {
		Hobby hobby = findById(id);
		if(hobby != null) {
			hobbyList.remove(hobby);
		}
	}
}
