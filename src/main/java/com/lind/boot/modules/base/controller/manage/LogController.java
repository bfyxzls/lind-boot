package com.lind.boot.modules.base.controller.manage;

import com.lind.boot.common.utils.PageUtil;
import com.lind.boot.common.utils.ResultUtil;
import com.lind.boot.common.vo.PageVo;
import com.lind.boot.common.vo.Result;
import com.lind.boot.common.vo.SearchVo;
import com.lind.boot.modules.base.entity.Log;
import com.lind.boot.modules.base.service.LogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;


/**
 * @author Exrickx
 */
@Slf4j
@RestController
@Api(description = "日志管理接口")
@RequestMapping("/xboot/log")
@Transactional
public class LogController {

    @Autowired
    private LogService logService;

    @RequestMapping(value = "/getAllByPage", method = RequestMethod.GET)
    @ApiOperation(value = "分页获取全部")
    public Result<Object> getAllByPage(@RequestParam(required = false) Integer type,
                                       @RequestParam String key,
                                       SearchVo searchVo,
                                       PageVo pageVo) {
        Page<Log> log = logService.findByConfition(type, key, searchVo, PageUtil.initPage(pageVo));
        return ResultUtil.data(log);

    }

    @RequestMapping(value = "/delByIds", method = RequestMethod.POST)
    @ApiOperation(value = "批量删除")
    public Result<Object> delByIds(@RequestParam String[] ids) {

        for (String id : ids) {
            logService.delete(id);
        }
        return ResultUtil.success("删除成功");
    }

    @RequestMapping(value = "/delAll", method = RequestMethod.POST)
    @ApiOperation(value = "全部删除")
    public Result<Object> delAll() {
        logService.deleteAll();
        return ResultUtil.success("删除成功");
    }
}
