package com.lind.boot.modules.quartz.service;

import com.lind.boot.base.XbootBaseService;
import com.lind.boot.modules.quartz.entity.QuartzJob;

import java.util.List;

/**
 * 定时任务接口
 * @author Exrick
 */
public interface QuartzJobService extends XbootBaseService<QuartzJob,String> {

    /**
     * 通过类名获取
     * @param jobClassName
     * @return
     */
    List<QuartzJob> findByJobClassName(String jobClassName);
}