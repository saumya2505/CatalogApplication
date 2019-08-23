package com.example.catalog.Model;

public class Role {

    private String roleID;
    private String roleType;
    private String addedBy;
    private boolean isAddProduct;
    private boolean isAddCatagory;
    private boolean isAppSettings;
    private boolean isAddRole;
    private boolean isUpdateRole;
    private boolean isViewOrder;
    private boolean isUpdateOrder;
    private boolean isActive;

    public String getRoleID() {
        return roleID;
    }

    public String getRoleType() {
        return roleType;
    }

    public String getAddedBy() {
        return addedBy;
    }

    public boolean isAddProduct() {
        return isAddProduct;
    }

    public boolean isAddCatagory() {
        return isAddCatagory;
    }

    public boolean isAppSettings() {
        return isAppSettings;
    }

    public boolean isAddRole() {
        return isAddRole;
    }

    public boolean isUpdateRole() {
        return isUpdateRole;
    }

    public boolean isViewOrder() {
        return isViewOrder;
    }

    public boolean isUpdateOrder() {
        return isUpdateOrder;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setRoleID(String roleID) {
        this.roleID = roleID;
    }

    public void setRoleType(String roleType) {
        this.roleType = roleType;
    }

    public void setAddedBy(String addedBy) {
        this.addedBy = addedBy;
    }

    public void setAddProduct(boolean addProduct) {
        isAddProduct = addProduct;
    }

    public void setAddCatagory(boolean addCatagory) {
        isAddCatagory = addCatagory;
    }

    public void setAppSettings(boolean appSettings) {
        isAppSettings = appSettings;
    }

    public void setAddRole(boolean addRole) {
        isAddRole = addRole;
    }

    public void setUpdateRole(boolean updateRole) {
        isUpdateRole = updateRole;
    }

    public void setViewOrder(boolean viewOrder) {
        isViewOrder = viewOrder;
    }

    public void setUpdateOrder(boolean updateOrder) {
        isUpdateOrder = updateOrder;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
