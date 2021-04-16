package com.tranquyet.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(of = { "name" })
@Entity
@Table(name = "manufacture")
public class ManufactureEntity extends BasedEntity {
	@Column(name = "name")
	private String name;

	@OneToMany(mappedBy = "manufacture")
	private List<ProductEntity> product = new ArrayList<ProductEntity>();

}
