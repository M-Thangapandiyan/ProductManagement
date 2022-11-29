package com.ideas2it.productmanagement.converter;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.ideas2it.productmanagement.dto.DealerDto;
import com.ideas2it.productmanagement.model.Dealer;

@Component
public class DealerConvertor {
	
	/*
	 * public DealerDto entityToDto(Dealer dealer) { DealerDto dealerDto = new
	 * DealerDto(); dealerDto.setId(dealer.getId());
	 * dealerDto.setCompany(dealer.getCompany());
	 * dealerDto.setLocation(dealer.getLocation()); return dealerDto; }
	 * 
	 * public DealerDto entityToDto2 (Dealer dealer, int id) { DealerDto dealerDto =
	 * new DealerDto(); dealerDto.setId(dealer.getId());
	 * dealerDto.setCompany(dealer.getCompany());
	 * dealerDto.setLocation(dealer.getLocation()); return dealerDto; }
	 * 
	 * public List<DealerDto> entityToDto1(List<Dealer> dealer) {
	 * 
	 * List<DealerDto> dealerDto = new ArrayList<DealerDto>(); for (Dealer value :
	 * dealer) { dealerDto.add(entityToDto(value)); } return dealerDto; }
	 * 
	 * public Dealer dtoToEntity(DealerDto dealerDto) { Dealer dealer = new
	 * Dealer(); dealer.setCompany(dealerDto.getCompany());
	 * dealer.setLocation(dealerDto.getLocation()); return dealer;
	 * 
	 * }
	 */
	 
	public DealerDto entityToDto(Dealer dealer) {
		ModelMapper mapper = new ModelMapper();
		DealerDto dealerDto = mapper.map(dealer, DealerDto.class);
		return dealerDto;
	}

	public List<DealerDto> entityToDto1(List<Dealer> dealers) {
		List<DealerDto> s = new ArrayList<DealerDto>();
		for (Dealer d : dealers) {
			s.add(entityToDto(d));
		}
		return s;
	}

	public Dealer dtoToEntity(DealerDto dealerDto) {
		ModelMapper mapper = new ModelMapper();
		Dealer dealer = mapper.map(dealerDto, Dealer.class);
		return dealer;
	}
}
