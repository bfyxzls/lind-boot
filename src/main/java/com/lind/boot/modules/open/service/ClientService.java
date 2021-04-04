package com.lind.boot.modules.open.service;

import com.lind.boot.base.XbootBaseService;
import com.lind.boot.modules.open.entity.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.lind.boot.common.vo.SearchVo;

/**
 * 客户端接口
 * @author Exrick
 */
public interface ClientService extends XbootBaseService<Client,String> {

    /**
    * 多条件分页获取
    * @param client
    * @param searchVo
    * @param pageable
    * @return
    */
    Page<Client> findByCondition(Client client, SearchVo searchVo, Pageable pageable);

}