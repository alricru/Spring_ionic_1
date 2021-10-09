package com.videoGames.alejandro.entity.services;

import java.util.List;

import com.videoGames.alejandro.entity.models.videoGames;

public interface videoGamesService {
	public videoGames get(long id);
	public List<videoGames> getAll();
	public void post(videoGames videogame);
	public void put(videoGames videogame, long id);
	public void delete(long id);
	
}
