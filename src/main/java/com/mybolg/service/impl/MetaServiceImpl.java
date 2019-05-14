package com.mybolg.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mybolg.dao.MetaVoMapper;
import com.mybolg.modal.vo.MetaVo;
import com.mybolg.modal.vo.MetaVoExample;
import com.mybolg.service.MetaService;

@Service
public class MetaServiceImpl implements MetaService {

    @Autowired
    MetaVoMapper metaVoMapper;

    @Override
    public void addMeta(MetaVo metaVo) {
        metaVoMapper.insert(metaVo);
    }

    @Override
    public void delMeta(Integer mid) {
        metaVoMapper.deleteByPrimaryKey(mid);

    }

    @Override
    public List<MetaVo> getMetas(String type) {
        MetaVoExample metaVoExample = new MetaVoExample();
        if (StringUtils.isNotEmpty(type)) {
            metaVoExample.createCriteria().andTypeEqualTo(type);
        }
        metaVoExample.setOrderByClause("sort DESC");
        return metaVoMapper.selectByExample(metaVoExample);
    }

    @Override
    public void modifyMetas(MetaVo metaVo) {
        metaVoMapper.updateByPrimaryKey(metaVo);
    }

    @Override
    public MetaVo getMetaForMetaName(String metaName) {
        MetaVoExample metaVoExample = new MetaVoExample();
        if (StringUtils.isNotEmpty(metaName)) {
            metaVoExample.createCriteria().andNameEqualTo(metaName);
        }

        List<MetaVo> list = metaVoMapper.selectByExample(metaVoExample);
        if (list != null && !list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    @Override
    public MetaVo getMetaForMid(Integer mid) {
        MetaVoExample metaVoExample = new MetaVoExample();
        if (mid != null && mid != 0) {
            metaVoExample.createCriteria().andMidEqualTo(mid);
        }

        List<MetaVo> list = metaVoMapper.selectByExample(metaVoExample);
        if (list != null && !list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

}
