package com.lind.boot.modules.base.serviceimpl;

import com.lind.boot.common.constant.CommonConstant;
import com.lind.boot.modules.base.dao.DictDao;
import com.lind.boot.modules.base.dao.DictDataDao;
import com.lind.boot.modules.base.entity.Dict;
import com.lind.boot.modules.base.entity.DictData;
import com.lind.boot.modules.base.service.DictDataService;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 字典数据接口实现
 *
 * @author Exrick
 */
@Slf4j
@Service
@Transactional
public class DictDataServiceImpl implements DictDataService {

    @Autowired
    DictDao dictDao;
    @Autowired
    private DictDataDao dictDataDao;

    @Override
    public DictDataDao getRepository() {
        return dictDataDao;
    }

    @Override
    public Page<DictData> findByCondition(DictData dictData, Pageable pageable) {

        return dictDataDao.findAll(new Specification<DictData>() {
            @Nullable
            @Override
            public Predicate toPredicate(Root<DictData> root, CriteriaQuery<?> cq, CriteriaBuilder cb) {

                Path<String> titleField = root.get("title");
                Path<Integer> statusField = root.get("status");
                Path<String> dictIdField = root.get("dictId");

                List<Predicate> list = new ArrayList<Predicate>();

                //模糊搜素
                if (StrUtil.isNotBlank(dictData.getTitle())) {
                    list.add(cb.like(titleField, '%' + dictData.getTitle() + '%'));
                }

                //状态
                if (dictData.getStatus() != null) {
                    list.add(cb.equal(statusField, dictData.getStatus()));
                }

                //所属字典
                if (StrUtil.isNotBlank(dictData.getDictId())) {
                    list.add(cb.equal(dictIdField, dictData.getDictId()));
                }

                Predicate[] arr = new Predicate[list.size()];
                cq.where(list.toArray(arr));
                return null;
            }
        }, pageable);
    }

    @Override
    public List<DictData> findByDictId(String dictId) {

        return dictDataDao.findByDictIdAndStatusOrderBySortOrder(dictId, CommonConstant.STATUS_NORMAL);
    }

    @Override
    public void deleteByDictId(String dictId) {

        dictDataDao.deleteByDictId(dictId);
    }

    @Override
    public DictData findByTypeAndValue(String type, String value) {
        Dict dic = dictDao.findByType(type);
        if (dic != null) {
            List<DictData> dictDatas = dictDataDao.findByDictIdAndStatusOrderBySortOrder(dic.getId(), CommonConstant.STATUS_NORMAL);
            if (CollectionUtils.isNotEmpty(dictDatas)) {
                return dictDatas.stream().filter(o -> o.getValue().equals(value)).findFirst().orElse(null);
            }
        }
        return null;
    }
}