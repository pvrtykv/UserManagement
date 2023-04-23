package com.github.pvrtykv.usermanagement.repository;

import com.github.pvrtykv.usermanagement.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {
}
