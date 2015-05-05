package Dao.dao;

import Dao.model.SchoolNews;

import java.util.List;

public interface SchoolNewsMapper {
    int deleteByPrimaryKey(Integer schoolnewsid);

    int insert(SchoolNews record);

    int insertSelective(SchoolNews record);

    SchoolNews selectByPrimaryKey(Integer schoolnewsid);

    int updateByPrimaryKeySelective(SchoolNews record);

    int updateByPrimaryKey(SchoolNews record);
    List<SchoolNews> selectAllSchoolNews(int sInfoCount);
}