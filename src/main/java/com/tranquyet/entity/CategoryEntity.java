package com.tranquyet.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@NoArgsConstructor
@ToString(of = { "name" })
@Table(name = "category")
public class CategoryEntity extends BasedEntity {
	@Column(name = "name")
	private String name;
	
	@OneToMany(mappedBy="category")
	private List<ProductEntity> product = new ArrayList<ProductEntity>();

}
