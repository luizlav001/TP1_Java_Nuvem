package br.edu.infnet.meuApp.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import br.edu.infnet.meuApp.model.Time;

@Component
public class TimeRepository {

	private static List<Time> timeList = new ArrayList<>();
	
	public Time save(String nome) {
		Integer id = timeList.size();
		Time time = new Time();
		time.setId(id);
		time.setNome(nome);
		
		timeList.add(time);
		return time;
	}
	
	public Time findById(Integer id) {
		if(id == null) {
			return null;
		}
		for(Time t : timeList) {
			if(t.getId().equals(id)) {
				return t;
			}
		}
		return null;
	}
	
	public Time upDate(Integer id, String nome) {
		Time time = findById(id);
		if(time != null) {
			time.setNome(nome);
		}
		return time;
	}
	
	public List<Time> findAll(){
		return timeList;
	}
	
	public void  delete(Integer id) {
		Time time = findById(id);
		if(time != null) {
			timeList.remove(time);
		}
	}
}
