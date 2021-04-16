package com.tranquyet.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.tranquyet.dto.UserDTO;
import com.tranquyet.entity.UserEntity;

public interface UserService extends UserDetailsService {

    UserEntity findByEmail(String email);

    UserEntity save(UserDTO registration);
}
