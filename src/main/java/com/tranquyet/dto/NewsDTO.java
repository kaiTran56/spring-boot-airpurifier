package com.tranquyet.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NewsDTO extends BasedDTO<NewsDTO> {

	private String title;

	private String shortDescription;

	private String content;

	private String image_1;

	private String image_2;

	private String image_3;

	private String image_4;

	private String youtubeUrl;

	private String shoppeeUrl;

	private String author;

	private String topicCode;

}
