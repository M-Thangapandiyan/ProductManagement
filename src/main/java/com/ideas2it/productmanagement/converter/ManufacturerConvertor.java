package com.ideas2it.productmanagement.converter;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.ideas2it.productmanagement.dto.ManufacturerDto;
import com.ideas2it.productmanagement.model.Manufacturer;

@Component
public class ManufacturerConvertor {

	public ManufacturerDto entityToDto(Manufacturer manufacturer) {
		ModelMapper mapper = new ModelMapper();
		ManufacturerDto manufacturerDto = mapper.map(manufacturer, ManufacturerDto.class);
		return manufacturerDto;
	}

	public List<ManufacturerDto> entityToDto1(List<Manufacturer> manufacturer) {
		List<ManufacturerDto> s = new ArrayList<ManufacturerDto>();
		for (Manufacturer d : manufacturer) {
			s.add(entityToDto(d));
		}
		return s;
	}

	public Manufacturer dtoToEntity(ManufacturerDto manufacturerDto) {
		ModelMapper mapper = new ModelMapper();
		Manufacturer manufacturer = mapper.map(manufacturerDto, Manufacturer.class);
		return manufacturer;

	}
}
