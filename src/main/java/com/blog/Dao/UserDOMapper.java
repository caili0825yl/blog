package com.blog.Dao;

import com.blog.POJO.DO.UserDO;
import org.apache.ibatis.annotations.Param;

public interface UserDOMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_info
     *
     * @mbg.generated Fri Mar 29 17:18:50 CST 2019
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_info
     *
     * @mbg.generated Fri Mar 29 17:18:50 CST 2019
     */
    int insert(UserDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_info
     *
     * @mbg.generated Fri Mar 29 17:18:50 CST 2019
     */
    int insertSelective(UserDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_info
     *
     * @mbg.generated Fri Mar 29 17:18:50 CST 2019
     */
    UserDO selectByPrimaryKey(Long id);
    UserDO selectByUsernameAndPassword(@Param(value="username")String username,@Param(value="password")String password);
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_info
     *
     * @mbg.generated Fri Mar 29 17:18:50 CST 2019
     */
    int updateByPrimaryKeySelective(UserDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_info
     *
     * @mbg.generated Fri Mar 29 17:18:50 CST 2019
     */
    int updateByPrimaryKey(UserDO record);
}