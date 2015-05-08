package Dao.dao;

import Dao.model.schoolNews;

import java.util.List;

public interface SchoolNewsMapper {
    int deleteByPrimaryKey(Integer schoolnewsid);

    int insert(schoolNews record);

    int insertSelective(schoolNews record);

    schoolNews selectByPrimaryKey(Integer schoolnewsid);

    int updateByPrimaryKeySelective(schoolNews record);

    int updateByPrimaryKey(schoolNews record);
    List<schoolNews> selectSchoolNewsBySchoolId(Integer schoolId);
}