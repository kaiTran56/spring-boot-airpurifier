package com.tranquyet.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "product")
@Getter
@Setter
@ToString(of = { "code", "name" })
@NoArgsConstructor
public class ProductEntity extends BasedEntity {

	@Column(name = "code")
	private String code;
	@Column(name = "name")
	private String name;

	@Column(name = "shortDescription", columnDefinition = "TEXT")
	private String shortDescription;

	@Column(name = "fullDescription", columnDefinition = "LONGTEXT")
	private String fullDescription;

	@Column(name = "price")
	private double price;

	@Column(name = "sale")
	private double sale;

	@Column(name = "quantity")
	private int quantity;

	@Column(name = "status")
	private String status;

	@Column(name = "image_1", columnDefinition = "TEXT")
	private String image_1;
	@Column(name = "image_2", columnDefinition = "TEXT")
	private String image_2;
	@Column(name = "image_3", columnDefinition = "TEXT")
	private String image_3;
	@Column(name = "image_4", columnDefinition = "TEXT")
	private String image_4;
	@Column(name = "shoppeeUrl", columnDefinition = "TEXT")
	private String shoppeeUrl;
	@Column(name = "youtubeUrl", columnDefinition = "TEXT")
	private String youtubeUrl;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_category")
	private CategoryEntity category;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_manufacture")
	private ManufactureEntity manufacture;

}
