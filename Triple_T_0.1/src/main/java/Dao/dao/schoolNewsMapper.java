package Dao.dao;

import Dao.model.schoolNews;

public interface schoolNewsMapper {
    int deleteByPrimaryKey(Integer schoolnewsid);

    int insert(schoolNews record);

    int insertSelective(schoolNews record);

    schoolNews selectByPrimaryKey(Integer schoolnewsid);

    int updateByPrimaryKeySelective(schoolNews record);

    int updateByPrimaryKey(schoolNews record);
}