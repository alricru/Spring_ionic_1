package com.videoGames.alejandro.entity.dao;

import org.springframework.data.repository.CrudRepository;

import com.videoGames.alejandro.entity.models.videoGames;

public interface videoGamesDao extends CrudRepository<videoGames, Long>{
}
