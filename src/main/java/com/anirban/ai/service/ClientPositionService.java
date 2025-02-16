package com.anirban.ai.service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import org.springframework.stereotype.Service;
import com.anirban.ai.data.ClientPositionData;
import com.anirban.ai.data.EffectiveAsOf;
import com.anirban.ai.data.Position;
import com.anirban.ai.data.Type;
import com.anirban.ai.model.ClientPositionRequest;
import com.anirban.ai.model.ClientPositionRequestQueryParam;
import com.anirban.ai.model.ParamType;

@Service
public class ClientPositionService implements Function<ClientPositionRequest, List<Position>> {
	
	private ClientPositionData clientPositionData = ClientPositionData.getInstance();

	@Override
	public List<Position> apply(ClientPositionRequest queryParam) {
		List<Position> resultSet = new ArrayList<Position>();
		List<Position> resultSetForCurrentParam = new ArrayList<Position>();
		for(ClientPositionRequestQueryParam eachParam:queryParam.getQueryParams()) {
			ParamType paramType = eachParam.getParamType();
			String value = eachParam.getValue();
			switch(paramType) {
			case ALL:
				clientPositionData.getPositionData().values().stream().map(p -> p.getAllPositions()).forEach(resultSet::addAll);
				break;
			case CURRENCY:
				clientPositionData.getPositionData().values().stream().map(p -> p.getAllPositionForCurrency(value)).forEach(resultSetForCurrentParam::addAll);
				break;
			case LONG_SHORT:
				Type type = Type.valueOf(value);
				if(resultSetForCurrentParam.size() > 0) {
					resultSetForCurrentParam = resultSetForCurrentParam.stream().filter(p -> p.getType() == type).toList();
				}else {
					clientPositionData.getPositionData().values().stream().map(p -> p.getAllPositionOfType(type)).forEach(resultSetForCurrentParam::addAll);
				}
				break;
			case TD_SD:
				EffectiveAsOf effective = EffectiveAsOf.valueOf(value);
				if(resultSetForCurrentParam.size() > 0) {
					resultSetForCurrentParam = resultSetForCurrentParam.stream().filter(p -> p.getEffective() == effective).toList();
				}else {
					clientPositionData.getPositionData().values().stream().map(p -> p.getAllPositionEffectiveAsOf(effective)).forEach(resultSetForCurrentParam::addAll);
				}
				break;
			default:
				break;
				
			}
		}
		if(resultSet.size() == 0) {
			resultSet.addAll(resultSetForCurrentParam);
		}
		
		return resultSet;
	}

}
