package com.example.catalog.Model;

public class Store {

    private String storeID;
    private String storeName;
    private String addedBy;
    private String appThemeId;
    private boolean isActive;

    public String getAppThemeId() {
        return appThemeId;
    }

    public void setAppThemeId(String appThemeId) {
        this.appThemeId = appThemeId;
    }

    public String getStoreID() {
        return storeID;
    }

    public String getStoreName() {
        return storeName;
    }

    public String getAddedBy() {
        return addedBy;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setStoreID(String storeID) {
        this.storeID = storeID;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public void setAddedBy(String addedBy) {
        this.addedBy = addedBy;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
