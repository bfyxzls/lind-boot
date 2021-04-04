package com.lind.boot.modules.base.utils;

import com.lind.boot.base.XbootBaseEntity;
import com.lind.boot.common.utils.SecurityUtil;
import com.lind.boot.modules.base.entity.User;
import cn.hutool.core.date.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EntityUtil {
    @Autowired
    SecurityUtil securityUtil;

    public void initEntity(XbootBaseEntity xbootBaseEntity) {
        User user = securityUtil.getCurrUser();
        xbootBaseEntity.setCreateBy(user.getId());
        xbootBaseEntity.setCreateTime(DateTime.now());
        xbootBaseEntity.setDelFlag(0);
        xbootBaseEntity.setUpdateBy(user.getId());
        xbootBaseEntity.setUpdateTime(DateTime.now());
    }
}
