package com.questionary.questionary.services;

import com.questionary.questionary.dto.UserDto;
import com.questionary.questionary.models.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    UserDto create (UserDto userDto);
    UserDto update (UserDto userDto);
    Boolean delete (Long id);
    UserDto getUserById (String id);
    UserDto getUserByEmail (String email);
    UserDto convertToUserDto (User user);
}
