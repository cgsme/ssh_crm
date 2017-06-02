package cn.tutu.service.impl;

import cn.tutu.dao.BaseDictDao;
import cn.tutu.domain.BaseDict;
import cn.tutu.service.BaseDictService;

import java.util.List;

/**
 * Created by 曹贵生 on 2017/6/2.
 * Email: 1595143088@qq.com
 */
public class BaseDictServiceImpl implements BaseDictService {

    private BaseDictDao baseDictDao;

    @Override
    public List<BaseDict> findDictByTypeCode(String typeCode) {
        return baseDictDao.findDictByTypeCode(typeCode);
    }

    public void setBaseDictDao(BaseDictDao baseDictDao) {
        this.baseDictDao = baseDictDao;
    }
}
