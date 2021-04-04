package com.lind.boot.modules.base.dao;

import com.lind.boot.base.XbootBaseDao;
import com.lind.boot.modules.base.entity.UserRole;

import java.util.List;

/**
 * 用户角色数据处理层
 * @author Exrickx
 */
public interface UserRoleDao extends XbootBaseDao<UserRole,String> {

    /**
     * 通过roleId查找
     * @param roleId
     * @return
     */
    List<UserRole> findByRoleId(String roleId);

    /**
     * 删除用户角色
     * @param userId
     */
    void deleteByUserId(String userId);
}
