package com.tranquyet.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "topic")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(of="name")
public class TopicEntity extends BasedEntity{
	
	
	@Column(name = "name")
	private String name;
	
	@OneToMany(mappedBy = "topic")
	private List<NewsEntity> news = new ArrayList<>();
}
