package com.yuuki.repository.account;

import com.yuuki.entity.account.UserDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Yuuki
 * @date 2022/6/2 11:34
 */
@Repository
public interface UserRepository extends JpaRepository<UserDO, Long> {
    UserDO findByUsername(String username);
}
