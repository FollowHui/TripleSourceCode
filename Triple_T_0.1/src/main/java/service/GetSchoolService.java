package service;

import Dao.dao.SchoolInformationMapper;
import Dao.model.DataSet;
import Dao.model.SchoolInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2015/4/9.
 */
@Service
public class GetSchoolService {
    @Autowired(required = false)
    GetStudentInfoService getStudentInfo;
    @Autowired(required = false)
    SchoolInformationMapper schoolInformationMapper;
    public List<SchoolInformation> getSchoolListByContinent(Integer continent){
        List<SchoolInformation> schoolInformations =schoolInformationMapper.getSchoolByContinent(continent);
        for(SchoolInformation schoolInformation: schoolInformations){
            List<DataSet> dataSets=getStudentInfo.getStudentInfo(schoolInformation.getSchoolid());
            schoolInformation.setDataSets(dataSets);
        }
        return schoolInformations;
    }
    public List<SchoolInformation> getSchoolListByRanking(Integer ranking){
        List<SchoolInformation> schoolInformations =schoolInformationMapper.getSchoolByRanking(ranking);
        for(SchoolInformation schoolInformation: schoolInformations){
            List<DataSet> dataSets=getStudentInfo.getStudentInfo(schoolInformation.getSchoolid());
            schoolInformation.setDataSets(dataSets);
        }
        return schoolInformations;
    }
    public SchoolInformation getSchoolDetail(Integer schoolId){
        SchoolInformation schoolInformation;
        schoolInformation =schoolInformationMapper.selectByPrimaryKey(schoolId);
        return schoolInformation;
    }
}
