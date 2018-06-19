package com.wang.model;

public class BaseModel {
    public String url;

    public long getPageId() {
        return pageId;
    }

    public void setPageId(long pageId) {
        this.pageId = pageId;
    }

    public long pageId;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "BaseModel{" +
                "url='" + url + '\'' +
                ", pageId=" + pageId +
                '}';
    }
}
