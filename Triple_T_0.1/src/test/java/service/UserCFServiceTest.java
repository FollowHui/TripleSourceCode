package service;

import Dao.dao.DataSetMapper;
import Dao.model.DataSet;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import service.DataCollection.AbstractUserInfo;
import service.DataCollection.SchoolInfo;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/mvc-dispatcher-servlet.xml","file:src/main/webapp/WEB-INF/spring-mybatis.xml"})


public class UserCFServiceTest extends TestCase {
    @Autowired(required = false)
    DataSetMapper dataSetMapper;
    @Test
    public void testUserCF(){
        List<DataSet> dataSets=dataSetMapper.getAllData();
        System.out.println(dataSets.get(0).getCountry());
        for(DataSet dataSet:dataSets){
            AbstractUserInfo userTemp=new AbstractUserInfo();
            userTemp.GPA=dataSet.getGpa();
            String is211=dataSet.getUndergraduate();
            if(is211.equals(211)){
                userTemp.gradsch=true;
            }else {
                userTemp.gradsch=false;
            }
            userTemp.GRE=dataSet.getGre().intValue();
            if(dataSet.getPaper()==null) {
                userTemp.paper = 0;
            }else{
                userTemp.paper = dataSet.getPaper();
            }
            if(dataSet.getTofel()==null){
             userTemp.Toefl=0;
            }else {
                userTemp.Toefl = dataSet.getTofel().intValue();
            }
            if(dataSet.getPromotion()==null){
                userTemp.recomand=0;
            }else {
                userTemp.recomand = dataSet.getPromotion();
            }
            if(dataSet.getTime()==null){
                userTemp.time=0;
            }else {
                userTemp.time = dataSet.getTime();
            }
            userTemp.userid=dataSet.getDataid();
            userTemp.school=dataSet.getSchool();
            UserInfoCollectionService.UserNum++;
            UserInfoCollectionService.userlist.add(userTemp);
            if(!SchoolInfo.schoolList.contains(dataSet.getSchool())){
                SchoolInfo.schoolList.add(dataSet.getSchool());
                SchoolInfo.schoolNum++;
            }

        }
        AbstractUserInfo newUser = new AbstractUserInfo(1000, true, 3.96, 104, 326, 0, 0, 2015, " " );
		UserCFService newcf = new UserCFService(newUser);
		newcf.calcuFriend();
		newcf.calcuSch();
//        for(String school:SchoolInfo.schoolList){
//            System.out.println(school);
//        }
    }
}