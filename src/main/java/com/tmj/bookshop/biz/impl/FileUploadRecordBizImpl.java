package com.tmj.bookshop.biz.impl;

import com.tmj.bookshop.biz.IFileUploadRecordBiz;
import com.tmj.bookshop.mapper.FileUploadRecordMapper;
import com.tmj.bookshop.model.FileUploadRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FileUploadRecordBizImpl implements IFileUploadRecordBiz {
    @Autowired
    private FileUploadRecordMapper fileUploadRecordMapper;

    @Override
    public int add(FileUploadRecord fileUploadRecord) {
        return fileUploadRecordMapper.insertSelective(fileUploadRecord);
    }

    @Override
    public FileUploadRecord load(String fileId) {
        return fileUploadRecordMapper.selectByPrimaryKey(fileId);
    }
}
