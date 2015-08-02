package com.jochen.test.events;

/**
 * Created by jochen on 01Aug15.
 */
public class FileEvent {

    String fileName;
    String absolutePath;
    long lastModifiedTimestamp;
    String fileContent;

    public FileEvent(String fileName, String absolutePath, long lastModifiedTimestamp, String fileContent) {
        this.fileName = fileName;
        this.absolutePath = absolutePath;
        this.lastModifiedTimestamp = lastModifiedTimestamp;
        this.fileContent = fileContent;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getAbsolutePath() {
        return absolutePath;
    }

    public void setAbsolutePath(String absolutePath) {
        this.absolutePath = absolutePath;
    }

    public long getLastModifiedTimestamp() {
        return lastModifiedTimestamp;
    }

    public void setLastModifiedTimestamp(long lastModifiedTimestamp) {
        this.lastModifiedTimestamp = lastModifiedTimestamp;
    }

    public String getFileContent() {
        return fileContent;
    }

    public void setFileContent(String fileContent) {
        this.fileContent = fileContent;
    }

    @Override
    public String toString() {
        return "FileEvent{" +
                "fileName='" + fileName + '\'' +
                ", absolutePath='" + absolutePath + '\'' +
                ", lastModifiedTimestamp=" + lastModifiedTimestamp +
                ", fileContent='" + fileContent + '\'' +
                '}';
    }
}
