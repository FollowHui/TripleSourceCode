package service;

import Dao.dao.DataSetMapper;
import Dao.model.DataSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2015/5/7.
 */
@Service
public class GetStudentInfoService {
    @Autowired(required = false)
    DataSetMapper dataSetMapper;
    public List<DataSet> getStudentInfo(Integer schoolId){
        List<DataSet> studentInfo= dataSetMapper.getStudentInfo(schoolId);
        return studentInfo;
    }
}
