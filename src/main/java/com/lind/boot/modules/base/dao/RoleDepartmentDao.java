package com.lind.boot.modules.base.dao;

import com.lind.boot.base.XbootBaseDao;
import com.lind.boot.modules.base.entity.RoleDepartment;

import java.util.List;

/**
 * 角色部门数据处理层
 * @author Exrick
 */
public interface RoleDepartmentDao extends XbootBaseDao<RoleDepartment,String> {

    /**
     * 通过roleId获取
     * @param roleId
     * @return
     */
    List<RoleDepartment> findByRoleId(String roleId);

    /**
     * 通过角色id删除
     * @param roleId
     */
    void deleteByRoleId(String roleId);

    /**
     * 通过角色id删除
     * @param departmentId
     */
    void deleteByDepartmentId(String departmentId);
}