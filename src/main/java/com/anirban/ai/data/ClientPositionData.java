package com.anirban.ai.data;

import java.util.HashMap;
import java.util.Map;

public class ClientPositionData {
	
	private Map<String, ClientPosition> allPositions;
	private static ClientPositionData SINGLE_INSTANCE;
	
	private ClientPositionData() {
		allPositions = new HashMap<String, ClientPosition>(); 
		init();
	}

	private void init() {
		String clientName = "Anirban Securities";
		ClientPosition clientPosition = new ClientPosition();
		allPositions.put(clientName, clientPosition);
		clientPosition.addPosition(new Position(Type.LONG, EffectiveAsOf.SD,"Reliance", 185, "INR"));
		clientPosition.addPosition(new Position(Type.LONG, EffectiveAsOf.SD,"APPL", 2789, "USD"));
		clientPosition.addPosition(new Position(Type.SHORT, EffectiveAsOf.SD,"NVIDIA", 3760, "USD"));
		clientName = "Sanjukta Securities";
		clientPosition = new ClientPosition();
		allPositions.put(clientName, clientPosition);
		clientPosition.addPosition(new Position(Type.LONG, EffectiveAsOf.SD,"MSFT", 400, "USD"));
		clientPosition.addPosition(new Position(Type.LONG, EffectiveAsOf.SD,"APPL", 800, "USD"));
		clientPosition.addPosition(new Position(Type.SHORT, EffectiveAsOf.TD,"APPL", 400, "USD"));
		clientPosition.addPosition(new Position(Type.LONG, EffectiveAsOf.SD,"Hindustan Unilever", 5000, "INR"));
		clientPosition.addPosition(new Position(Type.SHORT, EffectiveAsOf.SD,"HDFC BANK", 500, "INR"));
	}

	public Map<String, ClientPosition> getPositionData() {
		return this.allPositions;
	}
	
	public static ClientPositionData getInstance() {
		if ( SINGLE_INSTANCE == null) {
			SINGLE_INSTANCE = new ClientPositionData();
		}
		return SINGLE_INSTANCE;
	}

}
