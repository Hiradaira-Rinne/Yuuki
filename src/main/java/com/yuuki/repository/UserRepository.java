package com.yuuki.repository;

import com.yuuki.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Yuuki
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
