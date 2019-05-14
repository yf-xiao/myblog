package com.mybolg.dao;

import com.mybolg.modal.vo.RelationshipVoExample;
import com.mybolg.modal.vo.RelationshipVoKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RelationshipVoKeyMapper {
    long countByExample(RelationshipVoExample example);

    int deleteByExample(RelationshipVoExample example);

    int deleteByPrimaryKey(RelationshipVoKey key);

    int insert(RelationshipVoKey record);

    int insertSelective(RelationshipVoKey record);

    List<RelationshipVoKey> selectByExample(RelationshipVoExample example);

    int updateByExampleSelective(@Param("record") RelationshipVoKey record, @Param("example") RelationshipVoExample example);

    int updateByExample(@Param("record") RelationshipVoKey record, @Param("example") RelationshipVoExample example);
}