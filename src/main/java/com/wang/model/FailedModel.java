package com.wang.model;

/**
 * 数据库 持久化对象
 * 获取师表
 */
public class FailedModel {
    /**
     * 任务名称 ：如“国产器械”，“进口器械”等。
     */
    public String taskName;
    /**
     * 详情页 页面id。
     */
    public long pageId;

    @Override
    public String toString() {
        return "FailedModel{" +
                "taskName='" + taskName + '\'' +
                ", pageId=" + pageId +
                '}';
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public long getPageId() {
        return pageId;
    }

    public void setPageId(long pageId) {
        this.pageId = pageId;
    }
}
