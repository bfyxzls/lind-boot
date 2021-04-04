package com.lind.boot.modules.base.dao;

import com.lind.boot.base.XbootBaseDao;
import com.lind.boot.modules.base.entity.DepartmentHeader;

import java.util.List;

/**
 * 部门负责人数据处理层
 * @author Exrick
 */
public interface DepartmentHeaderDao extends XbootBaseDao<DepartmentHeader,String> {

    /**
     * 通过部门和负责人类型获取
     * @param departmentId
     * @param type
     * @return
     */
    List<DepartmentHeader> findByDepartmentIdAndType(String departmentId, Integer type);

    /**
     * 通过部门id删除
     * @param departmentId
     */
    void deleteByDepartmentId(String departmentId);

    /**
     * 通过userId删除
     * @param userId
     */
    void deleteByUserId(String userId);
}