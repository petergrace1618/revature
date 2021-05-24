package com.player.service;

import java.util.List;

import com.player.model.Player;

public interface PlayerSearchService {
	public List<Player> getAllPlayers();
	public List<Player> getPlayersByName(String name);
	public List<Player> getPlayersByAge(int age);
	public List<Player> getPlayersByCity(String city);
	public List<Player> getPlayersByTeamName(String teamName);
	
}
