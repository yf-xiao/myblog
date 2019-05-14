package com.mybolg.dao;

import com.mybolg.modal.vo.LogsVo;
import com.mybolg.modal.vo.LogsVoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LogsVoMapper {
    long countByExample(LogsVoExample example);

    int deleteByExample(LogsVoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(LogsVo record);

    int insertSelective(LogsVo record);

    List<LogsVo> selectByExample(LogsVoExample example);

    LogsVo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") LogsVo record, @Param("example") LogsVoExample example);

    int updateByExample(@Param("record") LogsVo record, @Param("example") LogsVoExample example);

    int updateByPrimaryKeySelective(LogsVo record);

    int updateByPrimaryKey(LogsVo record);
}