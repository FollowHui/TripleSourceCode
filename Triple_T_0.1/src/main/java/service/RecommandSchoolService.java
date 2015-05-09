package service;

import Dao.dao.DataSetMapper;
import Dao.dao.SchoolChineseMapper;
import Dao.dao.SchoolInformationMapper;
import Dao.dao.UserMapper;
import Dao.model.DataSet;
import Dao.model.SchoolChinese;
import Dao.model.SchoolInformation;
import Dao.model.User;
import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.DataCollection.AbstractUserInfo;

import java.util.*;

/**
 * Created by Administrator on 2015/5/9.
 */
@Service
public class RecommandSchoolService {
    @Autowired(required = false)
    DataSetMapper dataSetMapper;
    @Autowired(required = false)
    UserMapper userMapper;
    @Autowired(required = false)
    SchoolChineseMapper schoolChineseMapper;
    @Autowired(required = false)
    SchoolInformationMapper schoolInformationMapper;
    @Autowired(required = false)
    GetStudentInfoService getStudentInfo;
    public List<SchoolInformation>
    getRecommandSchool(Integer userId){
        List<SchoolInformation> schoolInformations=new ArrayList<SchoolInformation>();
        User user=userMapper.selectByPrimaryKey(userId);
        List<DataSet> dataSets=dataSetMapper.getAllStudentInfo();
        //System.out.println(dataSets.get(0).getAppschool());
        SchoolChinese schoolChinese=schoolChineseMapper.selectByPrimaryKey(user.getSchoolId());
        Integer schooltype = schoolChinese.getSchooltype();
        AbstractUserInfo newUser = new AbstractUserInfo(user.getUserid(), schooltype,user.getGsub(),2015, user.getGpa(), user.getScore().intValue(), user.getGrescore().intValue(), 0, 0,-1);
        UserCFService newcf = new UserCFService(newUser);
        ArrayList<AbstractUserInfo> userlist = new ArrayList<AbstractUserInfo>();
        for(DataSet dataSet:dataSets){
           // System.out.println(dataSet.getDataid());
            userlist.add(new AbstractUserInfo(1000, dataSet.getGraschool(), dataSet.getGrapro(), dataSet.getApptime(), dataSet.getGpa(), dataSet.getTofelreal().intValue(), dataSet.getGrereal().intValue(), dataSet.getIscom(), dataSet.getIspaper(), dataSet.getAppschool()));
        }
        newcf.input(userlist);
        newcf.calcu();
        newcf.clean();
        double [] schoolEvel=newcf.getSchoolEval();
        List<Double> schoolList=new ArrayList<Double>();
        List<Double> schoolListCopy=new ArrayList<Double>();
        for(int i=0;i<schoolEvel.length;i++){
            schoolList.add(schoolEvel[i]);
            schoolListCopy.add(schoolEvel[i]);
        }
        Collections.sort(schoolList);
        HashSet<Integer> schoolIdSet=new HashSet<Integer>();
        for(int i=schoolList.size()-1;i>=0;i--){
            Double eval=schoolList.get(i);
            if(eval.intValue()>0){
                Integer count=1;
                for(Double evalCopy:schoolListCopy){
                    if(eval.equals(evalCopy)){
                        Integer schoolId=count;
                        if(schoolIdSet.contains(schoolId)){

                        }else {
                            schoolIdSet.add(schoolId);
                            SchoolInformation schoolInformation;
                            schoolInformation = schoolInformationMapper.selectByPrimaryKey(schoolId);
                            System.out.println(schoolId);
                            schoolInformations.add(schoolInformation);
                        }
                    }
                    count++;
                }
           }
        }
        for(SchoolInformation schoolInformation: schoolInformations){
            List<DataSet> studentDataSets=getStudentInfo.getStudentInfo(schoolInformation.getSchoolid());
            schoolInformation.setDataSets(studentDataSets);
        }
        return schoolInformations;
    }
}
