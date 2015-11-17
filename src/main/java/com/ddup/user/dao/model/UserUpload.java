package com.ddup.user.dao.model;

import java.util.Date;

public class UserUpload {
    private Long uploadId;

    private Long userId;

    private String remark;

    private Date uploadTime;

    private Integer uploadType;

    private Double lng;

    private Double lat;

    private Integer geoLevel;

    private Long geoNum;

    private String iwcode;

    private Long resourceId;

    public UserUpload(Long uploadId, Long userId, String remark, Date uploadTime, Integer uploadType, Double lng, Double lat, Integer geoLevel, Long geoNum, String iwcode, Long resourceId) {
        this.uploadId = uploadId;
        this.userId = userId;
        this.remark = remark;
        this.uploadTime = uploadTime;
        this.uploadType = uploadType;
        this.lng = lng;
        this.lat = lat;
        this.geoLevel = geoLevel;
        this.geoNum = geoNum;
        this.iwcode = iwcode;
        this.resourceId = resourceId;
    }

    public UserUpload() {
        super();
    }

    public Long getUploadId() {
        return uploadId;
    }

    public void setUploadId(Long uploadId) {
        this.uploadId = uploadId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Date getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(Date uploadTime) {
        this.uploadTime = uploadTime;
    }

    public Integer getUploadType() {
        return uploadType;
    }

    public void setUploadType(Integer uploadType) {
        this.uploadType = uploadType;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Integer getGeoLevel() {
        return geoLevel;
    }

    public void setGeoLevel(Integer geoLevel) {
        this.geoLevel = geoLevel;
    }

    public Long getGeoNum() {
        return geoNum;
    }

    public void setGeoNum(Long geoNum) {
        this.geoNum = geoNum;
    }

    public String getIwcode() {
        return iwcode;
    }

    public void setIwcode(String iwcode) {
        this.iwcode = iwcode == null ? null : iwcode.trim();
    }

    public Long getResourceId() {
        return resourceId;
    }

    public void setResourceId(Long resourceId) {
        this.resourceId = resourceId;
    }
}