package com.tranquyet.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(of = { "name" })
public class ManufactureDTO extends BasedDTO<ManufactureDTO> {

	private String name;

	private ProductDTO product;

}
