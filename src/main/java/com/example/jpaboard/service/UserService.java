package com.example.jpaboard.service;

import com.example.jpaboard.dto.UserResponseDto;
import com.example.jpaboard.dto.SignUpResponseDto;
import com.example.jpaboard.entity.User;
import com.example.jpaboard.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public SignUpResponseDto signUp(String username, String password) {

        User user = new User(username, password);

        User savedUser = userRepository.save(user);

        return new SignUpResponseDto(savedUser.getId(), savedUser.getUsername());
    }

    public UserResponseDto findById(Long id) {

        Optional<User> optionalMember = userRepository.findById(id);

        // 예외처리
        if (optionalMember.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "해당 " + id + "는 존재하지 않습니다");
        }

        User findUser = optionalMember.get();

        return new UserResponseDto(findUser.getUsername());
    }



}
