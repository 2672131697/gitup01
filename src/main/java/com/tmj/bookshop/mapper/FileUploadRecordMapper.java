package com.tmj.bookshop.mapper;

import com.tmj.bookshop.model.FileUploadRecord;
import org.springframework.stereotype.Repository;

@Repository
public interface FileUploadRecordMapper {
    int deleteByPrimaryKey(String fileId);

    int insert(FileUploadRecord record);

    int insertSelective(FileUploadRecord record);

    FileUploadRecord selectByPrimaryKey(String fileId);

    int updateByPrimaryKeySelective(FileUploadRecord record);

    int updateByPrimaryKey(FileUploadRecord record);
}