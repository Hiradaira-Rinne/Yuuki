package com.yuuki.repository.account;

import com.yuuki.entity.account.DO.UserDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Yuuki
 * @date 2022/6/2 11:34
 */
@Repository
public interface UserRepository extends JpaRepository<UserDO, Long> {
    UserDO findByUsername(String username);

    @Query(value = "SELECT\n" +
            "\tm.permission_name \n" +
            "FROM\n" +
            "\tt_user_role ur\n" +
            "\tLEFT JOIN t_role r ON ur.role_id = r.id\n" +
            "\tLEFT JOIN t_role_permission rm ON ur.role_id = rm.role_id\n" +
            "\tLEFT JOIN t_permission m ON m.id = rm.permission_id \n" +
            "WHERE\n" +
            "\tuser_id = ?1 \n" +
            "\tAND r.STATUS = 0 ", nativeQuery = true)
    List<String> findPermsByUserId(Long userId);
}
