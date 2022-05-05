package com.yuuki.repository.account;

import com.yuuki.entity.account.DO.AccountDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

/**
 * @author Yuuki
 * @date 2022/4/28 12:18
 */
@Repository
public interface AccountRepository extends JpaRepository<AccountDO, Long> {

    AccountDO findByUsername(String username);
}
