package Dao.dao;

import Dao.model.SchoolInformation;

import java.util.List;

public interface SchoolInformationMapper {
    int deleteByPrimaryKey(Integer schoolid);

    int insert(SchoolInformation record);

    int insertSelective(SchoolInformation record);

    SchoolInformation selectByPrimaryKey(Integer schoolid);

    int updateByPrimaryKeySelective(SchoolInformation record);

    int updateByPrimaryKey(SchoolInformation record);
    List<SchoolInformation> getSchoolByContinent(Integer continent);
    List<SchoolInformation> getSchoolByRanking(Integer ranking);
}
