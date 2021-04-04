package com.lind.boot.modules.base.controller.common;

import com.lind.boot.common.utils.ResultUtil;
import com.lind.boot.common.vo.Result;
import com.lind.boot.modules.base.utils.FileUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

/**
 * @author Exrickx
 */
@Slf4j
@RestController
@Api(description = "文件上传接口")
@RequestMapping("/xboot/upload")
@Transactional
public class UploadController {

    @Autowired
    private FileUtil fileUtil;

    @RequestMapping(value = "/file", method = RequestMethod.POST)
    @ApiOperation(value = "文件上传")
    public Result<Object> upload(@RequestParam(required = false) MultipartFile file) {

        String result = null;
        String fileName = fileUtil.renamePic(file.getOriginalFilename());
        try {
            result = fileUtil.localUpload(file, fileName);
        } catch (Exception e) {
            log.error(e.toString());
            return ResultUtil.error(e.toString());
        }
        return ResultUtil.data(result);
    }

    @RequestMapping(value = "/pic/{path}", method = RequestMethod.GET)
    @ApiOperation(value = "显示照片")
    public void pic(@PathVariable String path, HttpServletResponse response) {
        fileUtil.view(path, response);
    }

}
