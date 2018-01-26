package com.tmj.bookshop.biz.impl;

import com.tmj.bookshop.biz.IFileUploadRecordBiz;
import com.tmj.bookshop.model.FileUploadRecord;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class FileUploadRecordBizImplTest extends BaseTestCase {

    @Autowired
    private IFileUploadRecordBiz fileUploadRecordBiz;

    private FileUploadRecord fileUploadRecord;
    @Override
    public void setUp() throws Exception {
        super.setUp();
        fileUploadRecord = new FileUploadRecord();
    }

    @Test
    public void add() throws Exception {

        fileUploadRecord.setFileId("sfasfsd");
        fileUploadRecord.setFileName("adfs");
        fileUploadRecord.setFilePath("154564");
        fileUploadRecord.setMime("er3535");

        fileUploadRecordBiz.add(fileUploadRecord);
       /* System.out.println(fileUploadRecord.getFileId());*/
    }
    @Test
    public void load() throws Exception {
        FileUploadRecord load = fileUploadRecordBiz.load("sfasfsd");
        System.out.println(load);
    }

}