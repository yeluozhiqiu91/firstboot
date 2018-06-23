package com.wang.task;

public class TaskParam {
    /**
     * taskName 将作为 数据库逻辑联合主键之一存储在mysql中
     */
    public String taskName = "default";
    /**
     * 列表页 get  分页请求头，
     */
    public String pagedListURL = "";

    /**
     * 详情页 get请求头，
     */
    public String baseurl = "";

    public TaskParam(String taskName, String pagedListURL, String baseurl) {
        this.taskName = taskName;
        this.pagedListURL = pagedListURL;
        this.baseurl = baseurl;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getPagedListURL() {
        return pagedListURL;
    }

    public void setPagedListURL(String pagedListURL) {
        this.pagedListURL = pagedListURL;
    }

    public String getBaseurl() {
        return baseurl;
    }

    public void setBaseurl(String baseurl) {
        this.baseurl = baseurl;
    }
}
