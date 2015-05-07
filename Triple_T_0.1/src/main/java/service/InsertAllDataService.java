package service;

import Dao.dao.SchoolInformationMapper;
import Dao.model.SchoolInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;

/**
 * Created by Administrator on 2015/4/8.
 */
@Service
public class InsertAllDataService {
    @Autowired(required = false)
    SchoolInformationMapper schoolInformationMapper;
    public  void readFile(String filePath){
        File sourceFile=new File(filePath);
        File file[]=sourceFile.listFiles();
        for(File filetemp:file){
            System.out.println(filetemp.getName());
//        File filetemp=file[0];
            String schoolName="";
            String address="";
            String phoneNumber="";
            String tuition="";
            int ranking=0;
            String website="";
            String schoolLogo="";
            String description="";
            String emailAddress="";
            String condition="";
            String hotclass="";
            String setTime="";
            BufferedReader sourceReader;
            StringBuilder fileData = new StringBuilder(1000);
            char[] buf = new char[10];
            int numRead=0;
            System.out.println(fileData.toString());
        try{
            sourceReader=new BufferedReader(new InputStreamReader(new FileInputStream(filetemp),"utf-8"));
            while ((numRead = sourceReader.read(buf)) != -1) {
                String readData = String.valueOf(buf, 0, numRead);
                fileData.append(readData);
                buf = new char[1024];
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
        String dataString=fileData.toString();
        String dataList[]=dataString.split("\t");
        for(String result:dataList){
            if (result.contains("学校名称：")) {
                int indexStart = result.indexOf("学校名称：");
                try {
                    schoolName = result.substring(indexStart + 5);
                }catch (Exception e){
                    e.printStackTrace();
                }
                //System.out.println(schoolName);
            }
            else if (result.contains("学校地址：")) {
                int indexStart = result.indexOf("学校地址：");
                try {
                    address = result.substring(indexStart + 5);
                }
                catch (Exception e){
                    e.printStackTrace();
                }
                //System.out.println(address);
            }
            else if (result.contains("建校时间：")) {
                int indexStart = result.indexOf("建校时间：");
                try {
                    setTime = result.substring(indexStart + 5);
                }
                catch (Exception e){
                    e.printStackTrace();
                }
                //System.out.println(address);
            }
            else if (result.contains("学校电话：")) {
                int indexStart = result.indexOf("学校电话：");
                try {
                    phoneNumber = result.substring(indexStart + 5);
                }catch (Exception e){
                    e.printStackTrace();
                }
                //System.out.println(phoneNumber);
           }
            else if (result.contains("官方网址：")) {
                int indexStart = result.indexOf("官方网址：");
                try{
                website = result.substring(indexStart + 5);}
                catch (Exception e){
                    e.printStackTrace();
                }
                //System.out.println(website);
            }
            else if (result.contains("排名：")) {
                int end=result.indexOf("</");
                int indexStart = result.indexOf("排名：");
                try {
                    ranking = Integer.parseInt(result.substring(indexStart + 3, end));

                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            else if (result.contains("参考费用")) {
                int indexStart = result.indexOf("参考费用");
                try{
                    tuition = result.substring(indexStart + 5);
                }
                catch(Exception e){
                    e.printStackTrace();
                }

                //System.out.println(tuition);
            }
            else if (result.contains("申请条件")) {
                int indexStart = result.indexOf("申请条件");
                try{
                    condition = result.substring(indexStart + 5);
                }
                catch(Exception e){
                    e.printStackTrace();
                }
            }
            else if (result.contains("优势专业")) {
                int indexStart = result.indexOf("优势专业");
                try{
                    hotclass = result.substring(indexStart + 5);
                }
                catch(Exception e){
                    e.printStackTrace();
                }
            }
            else if (result.contains("学校logo:")) {
                int indexStart = result.indexOf("学校logo:");
                try{
                    schoolLogo = result.substring(indexStart + 7);
                }
                catch(Exception e){
                    e.printStackTrace();
                }
            }
//            else if (result.contains("课程设置")) {
//                int indexStart = result.indexOf("课程设置");
//                try{
//                    classSet = result.substring(indexStart + 5);
//                }
//                catch(Exception e){
//                    e.printStackTrace();
//                }
//            }
            else {
                description=description+result;
            }
        }
            SchoolInformation SchoolInformation =new SchoolInformation();
            SchoolInformation.setAddress(address);
            SchoolInformation.setDescription(description);
            SchoolInformation.setEmailaddress(emailAddress);
            SchoolInformation.setPhonenumber(phoneNumber);
            SchoolInformation.setSchoolname(schoolName);
            SchoolInformation.setRanking(ranking);
            SchoolInformation.setWebsite(website);
            SchoolInformation.setSchoollogo(schoolLogo);
            SchoolInformation.setTuition(tuition);
            SchoolInformation.setHotclass(hotclass);
            SchoolInformation.setOffercondition(condition);
            SchoolInformation.setSettime(setTime);
            SchoolInformation.setSchoollogo(schoolLogo);
            SchoolInformation.setContinent(5);
            schoolInformationMapper.insertSelective(SchoolInformation);
        
        }
    }

}
