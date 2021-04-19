package com.tranquyet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.tranquyet.entity.TopicEntity;

@Service
public interface TopicRepository extends JpaRepository<TopicEntity, Long> {
	TopicEntity findOneByName(String name);

	TopicEntity findOneById(long id);
}
