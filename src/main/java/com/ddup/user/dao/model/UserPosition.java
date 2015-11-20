package com.ddup.user.dao.model;

import java.util.Date;

public class UserPosition {
    private Long positionId;

    private Long userId;

    private Date locateTime;

    private Double lng;

    private Double lat;

    private Long geoNum;

    private String iwcode;

    private Integer geoLevel;

    private Integer locateMode;

    public UserPosition(Long positionId, Long userId, Date locateTime, Double lng, Double lat, Long geoNum, String iwcode, Integer geoLevel, Integer locateMode) {
        this.positionId = positionId;
        this.userId = userId;
        this.locateTime = locateTime;
        this.lng = lng;
        this.lat = lat;
        this.geoNum = geoNum;
        this.iwcode = iwcode;
        this.geoLevel = geoLevel;
        this.locateMode = locateMode;
    }

    public UserPosition() {
        super();
    }

    public Long getPositionId() {
        return positionId;
    }

    public void setPositionId(Long positionId) {
        this.positionId = positionId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Date getLocateTime() {
        return locateTime;
    }

    public void setLocateTime(Date locateTime) {
        this.locateTime = locateTime;
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

    public Integer getGeoLevel() {
        return geoLevel;
    }

    public void setGeoLevel(Integer geoLevel) {
        this.geoLevel = geoLevel;
    }

    public Integer getLocateMode() {
        return locateMode;
    }

    public void setLocateMode(Integer locateMode) {
        this.locateMode = locateMode;
    }
}