package com.lind.boot.modules.base.dao;

import com.lind.boot.base.XbootBaseDao;
import com.lind.boot.modules.base.entity.RolePermission;

import java.util.List;

/**
 * 角色权限数据处理层
 * @author Exrick
 */
public interface RolePermissionDao extends XbootBaseDao<RolePermission,String> {

    /**
     * 通过permissionId获取
     * @param permissionId
     * @return
     */
    List<RolePermission> findByPermissionId(String permissionId);

    /**
     * 通过roleId获取
     * @param roleId
     */
    List<RolePermission> findByRoleId(String roleId);

    /**
     * 通过roleId删除
     * @param roleId
     */
    void deleteByRoleId(String roleId);
}