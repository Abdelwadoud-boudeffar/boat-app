package com.openwt.suisse.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.openwt.suisse.dto.UserCreateDTO;
import com.openwt.suisse.dto.UserUpdateDTO;
import com.openwt.suisse.dto.UserViewDTO;

/**
 * 
 * @author ABDELWADOUD BOUDEFFAR
 * @since 1.0
 */
public interface UserService {

	UserViewDTO getUserById(Long id);

	List<UserViewDTO> getUsers();

	UserViewDTO createUser(UserCreateDTO userCreateDTO);

	UserViewDTO updateUser(Long id, UserUpdateDTO userUpdateDTO);

	void deleteUser(Long id);

	List<UserViewDTO> slice(Pageable pageable);

}
