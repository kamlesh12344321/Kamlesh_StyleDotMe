package com.styledotme.kamlesh_task.data;

public class EmployeeBean {
    private String band;
    private String name;
    private String userIconUrl;
    private String profile;
    private int taskCount;
    private String taskPercentage;

    public String getBand() {
        return band;
    }

    public void setBand(String band) {
        this.band = band;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserIconUrl() {
        return userIconUrl;
    }

    public void setUserIconUrl(String userIconUrl) {
        this.userIconUrl = userIconUrl;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public int getTaskCount() {
        return taskCount;
    }

    public void setTaskCount(int taskCount) {
        this.taskCount = taskCount;
    }

    public String getTaskPercentage() {
        return taskPercentage;
    }

    public void setTaskPercentage(String taskPercentage) {
        this.taskPercentage = taskPercentage;
    }
}