package com.ideas2it.productmanagement.converter;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ideas2it.productmanagement.dto.DealerDto;
import com.ideas2it.productmanagement.model.Dealer;

@Component
public class DealerConvertor {

	public DealerDto entityToDto(Dealer dealer) {

		DealerDto s = new DealerDto();
		s.getCompany();
		s.getLocation();
		return s;
	}
	
	public List<DealerDto> entityToDto1 (Dealer dealer) {
		return dealer.stream().map(d ->entityToDto(d).collect(Collectors.toList) );
	}
	
	public Dealer dtoToEntity(DealerDto s) {
		Dealer d = new Dealer();
		d.setCompany(s.getCompany());
		d.setLocation(s.getLocation());
		return d;
	}
}
