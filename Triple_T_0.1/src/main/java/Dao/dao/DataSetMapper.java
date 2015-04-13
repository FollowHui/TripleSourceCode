package Dao.dao;

import Dao.model.DataSet;

import java.util.List;

public interface DataSetMapper {
    int deleteByPrimaryKey(Integer dataid);

    int insert(DataSet record);

    int insertSelective(DataSet record);

    DataSet selectByPrimaryKey(Integer dataid);

    int updateByPrimaryKeySelective(DataSet record);

    int updateByPrimaryKey(DataSet record);
    List<DataSet> getAllData();
}