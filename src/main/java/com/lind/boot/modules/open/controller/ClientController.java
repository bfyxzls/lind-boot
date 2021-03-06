package com.lind.boot.modules.open.controller;

import com.lind.boot.base.XbootBaseController;
import com.lind.boot.common.utils.PageUtil;
import com.lind.boot.common.utils.ResultUtil;
import com.lind.boot.common.vo.PageVo;
import com.lind.boot.common.vo.Result;
import com.lind.boot.common.vo.SearchVo;
import com.lind.boot.modules.open.entity.Client;
import com.lind.boot.modules.open.service.ClientService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

/**
 * @author Exrick
 */
@Slf4j
@RestController
@Api(description = "客户端管理接口")
@RequestMapping("/xboot/client")
@Transactional
public class ClientController extends XbootBaseController<Client, String> {

    @Autowired
    private ClientService clientService;

    @Override
    public ClientService getService() {
        return clientService;
    }

    @RequestMapping(value = "/getName/{clientId}", method = RequestMethod.GET)
    @ApiOperation(value = "获取网站基本信息")
    public Result<String> getName(@PathVariable String clientId){

        Client client = clientService.get(clientId);
        return new ResultUtil<String>().setData(client.getName());
    }


    @RequestMapping(value = "/getByCondition", method = RequestMethod.GET)
    @ApiOperation(value = "多条件分页获取")
    public Result<Page<Client>> getByCondition(Client client,
                                               SearchVo searchVo,
                                               PageVo pageVo){

        Page<Client> page = clientService.findByCondition(client, searchVo, PageUtil.initPage(pageVo));
        return new ResultUtil<Page<Client>>().setData(page);
    }

    @RequestMapping(value = "/getSecretKey", method = RequestMethod.GET)
    @ApiOperation(value = "生成随机secretKey")
    public Result<String> getSecretKey(){

        String secretKey = UUID.randomUUID().toString().replaceAll("-", "");
        return new ResultUtil<String>().setData(secretKey);
    }
}
