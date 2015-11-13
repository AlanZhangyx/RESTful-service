package com.iwhere.mybatis.dao;

import com.iwhere.mybatis.model.IaCategories;
import com.iwhere.mybatis.model.IaCategoriesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface IaCategoriesMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ia_categories
     *
     * @mbggenerated
     */
    int countByExample(IaCategoriesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ia_categories
     *
     * @mbggenerated
     */
    int deleteByExample(IaCategoriesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ia_categories
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Long categoryid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ia_categories
     *
     * @mbggenerated
     */
    int insert(IaCategories record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ia_categories
     *
     * @mbggenerated
     */
    int insertSelective(IaCategories record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ia_categories
     *
     * @mbggenerated
     */
    List<IaCategories> selectByExample(IaCategoriesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ia_categories
     *
     * @mbggenerated
     */
    IaCategories selectByPrimaryKey(Long categoryid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ia_categories
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") IaCategories record, @Param("example") IaCategoriesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ia_categories
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") IaCategories record, @Param("example") IaCategoriesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ia_categories
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(IaCategories record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ia_categories
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(IaCategories record);
}