package cn.tutu.dao;

import cn.tutu.domain.BaseDict;

import java.util.List;

/**
 * 数据字典dao
 *
 * Created by 曹贵生 on 2017/6/2.
 * Email: 1595143088@qq.com
 */
public interface BaseDictDao {
    // 根据类型编号查询所有
    List<BaseDict> findDictByTypeCode(String typeCode);
}
