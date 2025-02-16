package com.anirban.ai.data;

import java.util.ArrayList;
import java.util.List;

public class ClientPosition {
	
	private List<Position> positions;
	
	public ClientPosition() {
		this.positions = new ArrayList<Position>();
	}
	
	public List<Position> getAllPositions(){
		return this.positions;
	}
	
	public List<Position> getAllPositionOfType(Type type){
		return positions.stream().filter(p -> p.getType().equals(type)).toList();
	}
	
	public List<Position> getAllPositionEffectiveAsOf(EffectiveAsOf effective){
		return positions.stream().filter(p -> p.getEffective().equals(effective)).toList();
	}
	
	public List<Position> getAllPositionForCurrency(String currency){
		return positions.stream().filter(p -> p.getCurrency().equals(currency)).toList();
	}

	public void addPosition(Position p) {
		this.positions.add(p);
	}
	
}
