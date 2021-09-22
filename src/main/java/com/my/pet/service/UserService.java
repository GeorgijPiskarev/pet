package com.my.pet.service;

import com.my.pet.model.entity.User;
import com.my.pet.model.dto.UserDto;
import com.my.pet.model.mapstruct.UserMapper;
import com.my.pet.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder encoder;
    private final UserMapper userMapper;

    public UserDto register(User user) {
        String password = encoder.encode(user.getPassword());
        user.setPassword(password);

        return userMapper.toUserDto(userRepository.save(user));
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    public UserDto findByEmail(String email) {
        User user = userRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("User does not exist"));

        return userMapper.toUserDto(user);
    }
}
