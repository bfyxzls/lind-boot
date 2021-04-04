package com.lind.boot.modules.base.service;


import com.lind.boot.base.XbootBaseService;
import com.lind.boot.modules.base.entity.Role;

import java.util.List;

/**
 * 角色接口
 * @author Exrickx
 */
public interface RoleService extends XbootBaseService<Role,String> {

    /**
     * 获取默认角色
     * @param defaultRole
     * @return
     */
    List<Role> findByDefaultRole(Boolean defaultRole);
}
