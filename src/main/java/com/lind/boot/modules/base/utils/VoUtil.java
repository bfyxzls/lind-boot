package com.lind.boot.modules.base.utils;

import com.lind.boot.modules.base.entity.Permission;
import com.lind.boot.modules.base.vo.MenuVo;
import cn.hutool.core.bean.BeanUtil;

/**
 * @author Exrick
 */
public class VoUtil {

    public static MenuVo permissionToMenuVo(Permission p){

        MenuVo menuVo = new MenuVo();
        BeanUtil.copyProperties(p, menuVo);
        return menuVo;
    }
}
