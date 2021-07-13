package com.openwt.suisse.service;

import java.util.List;
import java.util.stream.Collectors;

import com.openwt.suisse.mapper.UserMapper;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.openwt.suisse.dao.model.User;
import com.openwt.suisse.dao.repository.UserRepository;
import com.openwt.suisse.dto.UserCreateDTO;
import com.openwt.suisse.dto.UserUpdateDTO;
import com.openwt.suisse.dto.UserViewDTO;
import com.openwt.suisse.exception.NotFoundException;

import lombok.RequiredArgsConstructor;

/**
 * @author ABDELWADOUD BOUDEFFAR
 * @since 1.0
 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public UserViewDTO getUserById(Long id) {
        final User user = userRepository.findById(id).orElseThrow(() -> new NotFoundException("Not Found Exception"));
        return UserMapper.INSTANCE.userToUserViewDto(user);
    }

    @Override
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public List<UserViewDTO> getUsers() {
        return userRepository.findAll().stream().map(user -> UserMapper.INSTANCE.userToUserViewDto(user)).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public UserViewDTO createUser(UserCreateDTO userCreateDTO) {
        final User user = userRepository
                .save(new User(userCreateDTO.getUserName(), userCreateDTO.getFirstName(), userCreateDTO.getLastName()));
        return UserMapper.INSTANCE.userToUserViewDto(user);
    }

    @Override
    @Transactional
    public UserViewDTO updateUser(Long id, UserUpdateDTO userUpdateDTO) {
        final User user = userRepository.findById(id).orElseThrow(() -> new NotFoundException("Not Found Exception"));

        user.setFirstName(userUpdateDTO.getFirstName());
        user.setLastName(userUpdateDTO.getLastName());

        final User updatedUser = userRepository.save(user);

        return UserMapper.INSTANCE.userToUserViewDto(updatedUser);
    }

    @Override
    @Transactional
    public void deleteUser(Long id) {
        final User user = userRepository.findById(id).orElseThrow(() -> new NotFoundException("Not Found Exception"));
        userRepository.deleteById(user.getId());
    }

    @Override
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public List<UserViewDTO> slice(Pageable pageable) {
        return userRepository.findAll(pageable).stream().map(user -> UserMapper.INSTANCE.userToUserViewDto(user)).collect(Collectors.toList());
    }

}
