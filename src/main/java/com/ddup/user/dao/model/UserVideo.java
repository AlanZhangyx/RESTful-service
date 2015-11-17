package com.ddup.user.dao.model;

import java.util.Date;

public class UserVideo {
    private Long videoId;

    private Long userId;

    private String coverPic;

    private Date uploadTime;

    private Float videoLength;

    private String videoFormat;

    private String videoUrl;

    private Integer publishFlag;

    private Double lng;

    private Double lat;

    private Long geoNum;

    private String iwcode;

    private Integer geoLevel;

    public UserVideo(Long videoId, Long userId, String coverPic, Date uploadTime, Float videoLength, String videoFormat, String videoUrl, Integer publishFlag, Double lng, Double lat, Long geoNum, String iwcode, Integer geoLevel) {
        this.videoId = videoId;
        this.userId = userId;
        this.coverPic = coverPic;
        this.uploadTime = uploadTime;
        this.videoLength = videoLength;
        this.videoFormat = videoFormat;
        this.videoUrl = videoUrl;
        this.publishFlag = publishFlag;
        this.lng = lng;
        this.lat = lat;
        this.geoNum = geoNum;
        this.iwcode = iwcode;
        this.geoLevel = geoLevel;
    }

    public UserVideo() {
        super();
    }

    public Long getVideoId() {
        return videoId;
    }

    public void setVideoId(Long videoId) {
        this.videoId = videoId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getCoverPic() {
        return coverPic;
    }

    public void setCoverPic(String coverPic) {
        this.coverPic = coverPic == null ? null : coverPic.trim();
    }

    public Date getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(Date uploadTime) {
        this.uploadTime = uploadTime;
    }

    public Float getVideoLength() {
        return videoLength;
    }

    public void setVideoLength(Float videoLength) {
        this.videoLength = videoLength;
    }

    public String getVideoFormat() {
        return videoFormat;
    }

    public void setVideoFormat(String videoFormat) {
        this.videoFormat = videoFormat == null ? null : videoFormat.trim();
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl == null ? null : videoUrl.trim();
    }

    public Integer getPublishFlag() {
        return publishFlag;
    }

    public void setPublishFlag(Integer publishFlag) {
        this.publishFlag = publishFlag;
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
}