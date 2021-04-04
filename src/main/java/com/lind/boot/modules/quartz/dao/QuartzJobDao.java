package com.lind.boot.modules.quartz.dao;

import com.lind.boot.base.XbootBaseDao;
import com.lind.boot.modules.quartz.entity.QuartzJob;

import java.util.List;

/**
 * 定时任务数据处理层
 * @author Exrick
 */
public interface QuartzJobDao extends XbootBaseDao<QuartzJob,String> {

    /**
     * 通过类名获取
     * @param jobClassName
     * @return
     */
    List<QuartzJob> findByJobClassName(String jobClassName);
}