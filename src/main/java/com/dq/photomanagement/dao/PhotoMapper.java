package com.dq.photomanagement.dao;

import com.dq.photomanagement.bean.Photo;
import com.dq.photomanagement.bean.PhotoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.validation.annotation.Validated;

public interface PhotoMapper {
    long countByExample(PhotoExample example);

    int deleteByExample(PhotoExample example);

    int deleteByPrimaryKey(String photoid);

    int insert(@Validated Photo record);

    int insertSelective(@Validated Photo record);

    List<Photo> selectByExample(PhotoExample example);

    Photo selectByPrimaryKey(String photoid);

    int updateByExampleSelective(@Param("record") Photo record, @Param("example") PhotoExample example);

    int updateByExample(@Param("record") Photo record, @Param("example") PhotoExample example);

    int updateByPrimaryKeySelective(Photo record);

    int updateByPrimaryKey(Photo record);
}