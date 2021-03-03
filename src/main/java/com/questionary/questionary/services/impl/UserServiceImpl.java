package com.questionary.questionary.services.impl;

import com.questionary.questionary.dto.UserDto;
import com.questionary.questionary.models.User;
import com.questionary.questionary.repositories.UserRepository;
import com.questionary.questionary.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDto getUserById(String id) {
        return convertToUserDto(userRepository.getUserById(id));
    }

    @Override
    public UserDto getUserByEmail(String email) {
        return convertToUserDto(userRepository.getUserByEmail(email));
    }

    @Override
    public UserDto create(UserDto userDto) {
        User newUser = new User(
                userDto.getEmail(),
                userDto.getPassword(),
                userDto.getFirstName(),
                userDto.getLastName()
        );
        return convertToUserDto(userRepository.save(newUser));
    }

    @Override
    public UserDto update(UserDto userDto) {
        User userFromDatabase = userRepository.getUserById(userDto.getId().toString());
        userFromDatabase.setEmail(userDto.getEmail());
        userFromDatabase.setPassword(userDto.getPassword());
        userFromDatabase.setFirstName(userDto.getFirstName());
        userFromDatabase.setLastName(userDto.getLastName());
        return convertToUserDto(userRepository.save(userFromDatabase));
    }

    @Override
    public Boolean delete(Long id) {
        userRepository.deleteById(id);
        User user = userRepository.getUserById(id.toString());
        return user == null;
    }

    @Override
    public UserDto convertToUserDto(User user) {
        return new UserDto(
                user.getId(),
                user.getEmail(),
                user.getPassword(),
                user.getFirstName(),
                user.getLastName()
        );
    }
}
