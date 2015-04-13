package service;

import Dao.dao.SchoolInformationMapper;
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
    SchoolInformationMapper schoolInformationMapper;
    public List<SchoolInformation> getSchoolListByContinent(Integer continent){
        List<SchoolInformation> schoolInformations=schoolInformationMapper.getSchoolByContinent(continent);
        return  schoolInformations;
    }
    public List<SchoolInformation> getSchoolListByRanking(Integer ranking){
        List<SchoolInformation> schoolInformations=schoolInformationMapper.getSchoolByRanking(ranking);
//        for(SchoolInformation schoolInformation:schoolInformations){
//            System.out.println(schoolInformation.getRanking());
//        }
        return schoolInformations;
    }
    public SchoolInformation getSchoolDetail(Integer schoolId){
        SchoolInformation schoolInformation;
        schoolInformation=schoolInformationMapper.selectByPrimaryKey(schoolId);
        return schoolInformation;
    }
}
