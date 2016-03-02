package com.dumitruc.appium;

/**
 * Created by dima on 08/02/2014.
 */
public class Application {


    private String name;
    private String description;
    private String apkFullPath;
    private DeviceOS designatedDeviceType;
    private String appPackage;
    private String appActivity;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getApkFullPath() {
        return apkFullPath;
    }

    public void setApkFullPath(String apkFullPath) {
        this.apkFullPath = apkFullPath;
    }

    public DeviceOS getDesignatedDeviceType() {
        return designatedDeviceType;
    }

    public void setDesignatedDeviceType(DeviceOS designatedDeviceType) {
        this.designatedDeviceType = designatedDeviceType;
    }

    public String getAppPackage() {
        return appPackage;
    }

    public void setAppPackage(String appPackage) {
        this.appPackage = appPackage;
    }

    public String getAppActivity() {
        return appActivity;
    }

    public void setAppActivity(String appActivity) {
        this.appActivity = appActivity;
    }
}
