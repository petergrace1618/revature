package com.player.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.player.model.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer>{

	public List<Player> findByName(String name);
	public List<Player> findByAge(int age);
	public List<Player> findByTeamName(String teamName);
	public List<Player> findByCity(String city);
	
//	@Query("select * from player where age=(select max(age) from player)")
//	public List<Player> getPlayerWithMaxAge();
}
