package com.tmj.bookshop.model;

import java.util.Date;

public class FileUploadRecord {
    private String fileId;

    private String filePath;

    private String mime;

    private String fileName;

    private Date uploadDatetime;

    public FileUploadRecord(String fileId, String filePath, String mime, String fileName, Date uploadDatetime) {
        this.fileId = fileId;
        this.filePath = filePath;
        this.mime = mime;
        this.fileName = fileName;
        this.uploadDatetime = uploadDatetime;
    }

    public FileUploadRecord() {
        super();
    }

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getMime() {
        return mime;
    }

    public void setMime(String mime) {
        this.mime = mime;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Date getUploadDatetime() {
        return uploadDatetime;
    }

    public void setUploadDatetime(Date uploadDatetime) {
        this.uploadDatetime = uploadDatetime;
    }
}