package com.tranquyet.service;

import java.util.List;

import com.tranquyet.dto.ManufactureDTO;

public interface ManufactureService {
	List<ManufactureDTO> findAll();

	int getTotalItem();

	ManufactureDTO findById(long id);

	ManufactureDTO save(ManufactureDTO dto);

	void delete(long[] ids);
}
