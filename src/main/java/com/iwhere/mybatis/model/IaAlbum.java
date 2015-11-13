package com.iwhere.mybatis.model;

import java.util.Date;

public class IaAlbum {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ia_album.album_id
     *
     * @mbggenerated
     */
    private Long albumId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ia_album.user_id
     *
     * @mbggenerated
     */
    private Long userId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ia_album.create_time
     *
     * @mbggenerated
     */
    private Date createTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ia_album
     *
     * @mbggenerated
     */
    public IaAlbum(Long albumId, Long userId, Date createTime) {
        this.albumId = albumId;
        this.userId = userId;
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ia_album
     *
     * @mbggenerated
     */
    public IaAlbum() {
        super();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ia_album.album_id
     *
     * @return the value of ia_album.album_id
     *
     * @mbggenerated
     */
    public Long getAlbumId() {
        return albumId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ia_album.album_id
     *
     * @param albumId the value for ia_album.album_id
     *
     * @mbggenerated
     */
    public void setAlbumId(Long albumId) {
        this.albumId = albumId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ia_album.user_id
     *
     * @return the value of ia_album.user_id
     *
     * @mbggenerated
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ia_album.user_id
     *
     * @param userId the value for ia_album.user_id
     *
     * @mbggenerated
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ia_album.create_time
     *
     * @return the value of ia_album.create_time
     *
     * @mbggenerated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ia_album.create_time
     *
     * @param createTime the value for ia_album.create_time
     *
     * @mbggenerated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}