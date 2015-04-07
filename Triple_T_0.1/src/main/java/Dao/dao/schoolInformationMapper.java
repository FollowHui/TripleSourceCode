package Dao.dao;

import Dao.model.SchoolInformation;

public interface SchoolInformationMapper {
    int deleteByPrimaryKey(Integer schoolid);

    int insert(SchoolInformation record);

    int insertSelective(SchoolInformation record);

    SchoolInformation selectByPrimaryKey(Integer schoolid);

    int updateByPrimaryKeySelective(SchoolInformation record);

    int updateByPrimaryKey(SchoolInformation record);
}