package com.tranquyet.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "news")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor	
@ToString(of = {"title", "author"})
public class NewsEntity extends BasedEntity {

	@Column(name ="title", nullable = false)
	private String title;

	@Column(name = "shortDescription", columnDefinition = "TEXT")
	private String shortDescription;

	@Column(name = "content", columnDefinition="LONGTEXT")
	private String content;

	@Column(name = "image_1", columnDefinition = "TEXT")
	private String image_1;

	@Column(name="image_2", columnDefinition = "TEXT")
	private String image_2;
	@Column(name = "image_3", columnDefinition = "TEXT" )
	private String image_3;

	@Column(name = "image_4", columnDefinition = "TEXT")
	private String image_4;

	@Column(name = "youtubeUrl", columnDefinition = "TEXT")
	private String youtubeUrl;

	@Column(name = "shoppeeUrl", columnDefinition = "TEXT")
	private String shoppeeUrl;

	@Column(name = "author", nullable = false)
	private String author;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name ="id_topic")
	private TopicEntity topic;
}
