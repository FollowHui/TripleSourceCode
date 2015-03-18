package Dao.dao;

import Dao.model.schoolInformation;

public interface schoolInformationMapper {
    int deleteByPrimaryKey(Integer schoolid);

    int insert(schoolInformation record);

    int insertSelective(schoolInformation record);

    schoolInformation selectByPrimaryKey(Integer schoolid);

    int updateByPrimaryKeySelective(schoolInformation record);

    int updateByPrimaryKey(schoolInformation record);
}