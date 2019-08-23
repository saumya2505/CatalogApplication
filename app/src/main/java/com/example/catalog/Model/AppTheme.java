package com.example.catalog.Model;

public class AppTheme {

    private String appThemeID;
    private String about;
    private String ColorPrimaryDark;
    private String ColorPrimary;
    private String ColorEmphasis;
    private String FontColorDark;
    private String FontColorLight;
    private String logoURL;
    private String addedBy;
    private boolean isActive;
    private String appName;

    public void setThemeName(String themeName) {
        this.themeName = themeName;
    }

    public String getThemeName() {
        return themeName;
    }

    private String themeName;

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getAppThemeID() {
        return appThemeID;
    }

    public String getAbout() {
        return about;
    }

    public String getColorPrimaryDark() {
        return ColorPrimaryDark;
    }

    public String getColorPrimary() {
        return ColorPrimary;
    }

    public String getColorEmphasis() {
        return ColorEmphasis;
    }

    public String getFontColorDark() {
        return FontColorDark;
    }

    public String getFontColorLight() {
        return FontColorLight;
    }

    public String getLogoURL() {
        return logoURL;
    }

    public String getAddedBy() {
        return addedBy;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setAppThemeID(String appThemeID) {
        this.appThemeID = appThemeID;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public void setColorPrimaryDark(String colorPrimaryDark) {
        ColorPrimaryDark = colorPrimaryDark;
    }

    public void setColorPrimary(String colorPrimary) {
        ColorPrimary = colorPrimary;
    }

    public void setColorEmphasis(String colorEmphasis) {
        ColorEmphasis = colorEmphasis;
    }

    public void setFontColorDark(String fontColorDark) {
        FontColorDark = fontColorDark;
    }

    public void setFontColorLight(String fontColorLight) {
        FontColorLight = fontColorLight;
    }

    public void setLogoURL(String logoURL) {
        this.logoURL = logoURL;
    }

    public void setAddedBy(String addedBy) {
        this.addedBy = addedBy;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
