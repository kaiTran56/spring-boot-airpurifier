package com.tranquyet.repository;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import com.tranquyet.entity.NewsEntity;
import com.tranquyet.entity.TopicEntity;

public interface NewsRepository extends JpaRepository<NewsEntity, Long> {

	List<NewsEntity> findByTitle(String title, PageRequest page);

	NewsEntity findOneById(Long id);

	List<NewsEntity> findByTopic(TopicEntity entity);

}
