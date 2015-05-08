package Dao.dao;

import Dao.model.SchoolChinese;

public interface SchoolChineseMapper {
    int deleteByPrimaryKey(Integer schoolid);

    int insert(SchoolChinese record);

    int insertSelective(SchoolChinese record);

    SchoolChinese selectByPrimaryKey(Integer schoolid);

    int updateByPrimaryKeySelective(SchoolChinese record);

    int updateByPrimaryKey(SchoolChinese record);
    public SchoolChinese selectBySchoolName(String schoolName);
}