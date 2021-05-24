package com.player.service;

import com.player.model.Player;

public interface PlayerCrudService {
	public Player addPlayer(Player player);
	public Player updatePlayer(Player player);
	public Player getPlayerById(int id);
	public void deletePlayer(int id);
}
