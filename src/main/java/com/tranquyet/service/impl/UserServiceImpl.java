package com.tranquyet.service.impl;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.tranquyet.dto.UserDTO;
import com.tranquyet.entity.RoleEntity;
import com.tranquyet.entity.UserEntity;
import com.tranquyet.repository.UserRepository;
import com.tranquyet.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	public UserEntity findByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	public UserEntity save(UserDTO registration) {
		UserEntity userEntity = new UserEntity();
		userEntity.setFirstName(registration.getFirstName());
		userEntity.setLastName(registration.getLastName());
		userEntity.setEmail(registration.getEmail());
		userEntity.setPassword(passwordEncoder.encode(registration.getPassword()));
		userEntity.setRoleEntities(Arrays.asList(new RoleEntity("ROLE_ADMIN")));
		return userRepository.save(userEntity);
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		UserEntity userEntity = userRepository.findByEmail(email);
		if (userEntity == null) {
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new org.springframework.security.core.userdetails.User(userEntity.getEmail(), userEntity.getPassword(),
				mapRolesToAuthorities(userEntity.getRoleEntities()));
	}

	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<RoleEntity> roleEntities) {
		return roleEntities.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
	}
}
