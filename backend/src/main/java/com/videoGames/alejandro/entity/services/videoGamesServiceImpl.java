package com.videoGames.alejandro.entity.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.videoGames.alejandro.entity.dao.videoGamesDao;
import com.videoGames.alejandro.entity.models.videoGames;

@Service
public class videoGamesServiceImpl implements videoGamesService {
	
	@Autowired
	private videoGamesDao videogameDao;
	
	@Override
	public videoGames get(long id) {
		return videogameDao.findById(id).get();
	}
	
	@Override
	public List<videoGames> getAll() {
		return (List<videoGames>) videogameDao.findAll();
	}
	
	@Override
	public void post(videoGames videogame) {
		videogameDao.save(videogame);
	}
	
	public void put(videoGames videogame, long id) {
		videogameDao.findById(id).ifPresent((x)->{
			videogame.setId(id);
			videogameDao.save(videogame);
		});
	}
	
	public void delete(long id) {
		videogameDao.deleteById(id);
	}

}
