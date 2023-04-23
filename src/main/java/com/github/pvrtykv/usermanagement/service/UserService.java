package com.github.pvrtykv.usermanagement.service;

import com.github.pvrtykv.usermanagement.model.User;
import com.github.pvrtykv.usermanagement.entity.UserEntity;
import com.github.pvrtykv.usermanagement.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public UserEntity create(User user) {
        var userToCreate = UserEntity.builder()
                .username(user.username())
                .email(user.email())
                .passwordHash(user.passwordHash())
                .build();
        return userRepository.save(userToCreate);
    }

    public UserEntity findByUuid(String uuid) {
        return userRepository.findById(uuid).orElseThrow(EntityNotFoundException::new);
    }

    public List<UserEntity> findAll() {
        return userRepository.findAll();
    }

    public void deleteByUuid(String uuid) {
        userRepository.deleteById(uuid);
    }

    public void deleteAll() {
        userRepository.deleteAll();
    }

}
