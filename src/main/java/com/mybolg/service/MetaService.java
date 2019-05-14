package com.mybolg.service;

import java.util.List;

import com.mybolg.modal.vo.MetaVo;
import com.mybolg.modal.vo.MetaVoExample;

/**
 * 分类与标签
 * @author yfxiao
 * 
 */
public interface MetaService {

    /**
     * 添加分类或者标签
     * @param metaVo
     */
    void addMeta(MetaVo metaVo);

    /**
     * 删除分类或标签
     * @param mid
     */
    void delMeta(Integer mid);

    /**
     * 获取分类或标签
     * @param type
     * @return
     */
    List<MetaVo> getMetas(String type);

    /**
     * 修改
     * @param metaVoExample
     */
    void modifyMetas(MetaVo metaVo);

    /**
     * 根据name获取分类或者标签
     * @param metaName
     * @return
     */
    MetaVo getMetaForMetaName(String metaName);

    /**
     * 根据mid获取分类或者标签
     * @param metaName
     * @return
     */
    MetaVo getMetaForMid(Integer mid);
}
