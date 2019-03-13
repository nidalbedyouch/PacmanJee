package fr.univangers.pacman.beans;

import java.sql.Timestamp;

public class Partie{
	private Long id;
	private int score;
	private Timestamp date;
	private String player;
	private boolean victory;
	
	public Partie(Long id, int score, Timestamp date, String player, boolean winned) {
		super();
		this.id = id;
		this.score = score;
		this.date = date;
		this.setPlayer(player);
		this.victory = winned;
	}

	public Partie() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	

	public boolean isWinned() {
		return victory;
	}

	public void setWinned(boolean winned) {
		this.victory = winned;
	}

	public String getPlayer() {
		return player;
	}

	public void setPlayer(String player) {
		this.player = player;
	}
	
}
