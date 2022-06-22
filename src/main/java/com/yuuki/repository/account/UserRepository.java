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

    @Query(value = "SELECT p.permissionName FROM UserJoinRoleDO ur LEFT JOIN RoleDO r ON ur.roleId = r.id " +
            "LEFT JOIN RoleJoinPermissionDO rp ON ur.roleId = rp.roleId LEFT JOIN PermissionDO p ON p.id = rp.permissionId " +
            "WHERE ur.userId = ?1 AND r.status = '0'")
    List<String> findPermsByUserId(Long userId);
}
