package com.tmj.bookshop.biz;

import com.tmj.bookshop.model.FileUploadRecord;

public interface IFileUploadRecordBiz {


    int add(FileUploadRecord fileUploadRecord);

    FileUploadRecord load(String fileId);

}
