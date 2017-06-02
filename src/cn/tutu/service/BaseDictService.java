package cn.tutu.service;

import cn.tutu.domain.BaseDict;

import java.util.List;

/**
 * 数据字典
 *
 * Created by 曹贵生 on 2017/6/2.
 * Email: 1595143088@qq.com
 */
public interface BaseDictService {

    // 根据类别号查询所有
    List<BaseDict> findDictByTypeCode(String typeCode);
}
