package service;

import Dao.dao.FavouritesMapper;
import Dao.dao.NoteMapper;
import Dao.dao.SchoolChineseMapper;
import Dao.dao.UserMapper;
import Dao.model.Favourites;
import Dao.model.Note;
import Dao.model.SchoolChinese;
import Dao.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by badguy on 2015/4/5.
 */
@Service
public class SelfInfoService {
    @Autowired(required = false)
    private UserMapper userMapper;
    @Autowired(required = false)
    private User user;
    @Autowired(required = false)
    NoteMapper noteMapper;
    @Autowired(required = false)
    FavouritesMapper favouritesMapper;
    @Autowired(required = false)
    SchoolChineseMapper schoolChineseMapper;
    public String changeSelfInformation(Integer userId,String email,Float score,Float GPA,Float GRE,String gsch,String gsub){
        user=new User();
        user.setUserid(userId);
        user.setEmailaddress(email);
        user.setScore(score);
        user.setGpa(GPA);
        user.setGrescore(GRE);
        user.setGsub(gsub);
        SchoolChinese schoolChinese;
        schoolChinese=schoolChineseMapper.selectBySchoolName(gsch);
        if(schoolChinese==null){
            System.out.println("no such school");
        }else {
            Integer schoolId = schoolChinese.getSchoolid();
            user.setSchoolId(schoolId);
        }
        try {
            userMapper.updateByPrimaryKeySelective(user);
        }
        catch (Exception e){
            e.printStackTrace();
            return "update failed";
        }
        return "success";
    }
    public List<Favourites> getUserFavourNote(Integer userId){
        List<Favourites> favouritesList;
        favouritesList=favouritesMapper.selectNoteByUserId(userId);
        return  favouritesList;
    }
    public User getSelfInfomation(Integer userId){
        try {
            user=userMapper.selectByPrimaryKey(userId);
            Integer schoolId=user.getSchoolId();
            if(schoolId==null){

            }else{
                SchoolChinese schoolChinese=schoolChineseMapper.selectByPrimaryKey(schoolId);
                String schoolName=schoolChinese.getSchoolname();
                user.setSchoolName(schoolName);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return user;
    }
    public List<Favourites> getUserFavourSchool(Integer userId){
        List<Favourites> favouritesList;
        favouritesList=favouritesMapper.selectSchoolByUserId(userId);
        return  favouritesList;
    }
    public List<Note> getUserNotes(Integer userId){
        List<Note> noteList;
        noteList=noteMapper.getNotesByUserId(userId);
        return noteList;
    }
    public void changeImage(Integer userId,String headImage ){
        User user=userMapper.selectByPrimaryKey(userId);
        user.setHeadimage(headImage);
        userMapper.updateByPrimaryKeySelective(user);
    }
}
