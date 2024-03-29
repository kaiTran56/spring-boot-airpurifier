package com.tranquyet.dto;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public abstract class BasedDTO<T> {

	private Long id;
	private Timestamp createdDate;
	private Timestamp modifiedDate;
	private String createdBy;
	private String modifiedBy;
	private Long[] ids;
	private List<T> listResult = new ArrayList<T>();
	private Integer page;
	private Integer limit;
	private Integer totalPage;
	private Integer totalItem;
	private String sortName;
	private String sortBy;
	private String alert;
	private String message;
	private String type;
	private Integer currentPage;

}
