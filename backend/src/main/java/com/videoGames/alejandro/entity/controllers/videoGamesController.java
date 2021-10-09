package com.videoGames.alejandro.entity.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.videoGames.alejandro.entity.models.videoGames;
import com.videoGames.alejandro.entity.services.videoGamesService;

@CrossOrigin(origins = "http://localhost:8100")
@RestController
public class videoGamesController {
	
	
	@Autowired
	videoGamesService videoGamesService;
	
	@GetMapping("/videogames")
	public List<videoGames> getAllvideoGames(){
		return videoGamesService.getAll();
	}
	
	@GetMapping("/videogames/{id}")
	public videoGames getOne(@PathVariable(value = "id") long id) {
		return videoGamesService.get(id);
	}
	
	@PostMapping("/videogames")
	public void post(videoGames videoGames) {
		videoGamesService.post(videoGames);
	}
	@PutMapping("/videogames/{id}")
	public void put(videoGames videoGames, @PathVariable(value = "id") long id) {
		videoGamesService.put(videoGames, id);
	}
	
	@DeleteMapping("/videogames/{id}")
	public void delete(@PathVariable(value = "id") long id) {
		videoGamesService.delete(id);
	}

}
