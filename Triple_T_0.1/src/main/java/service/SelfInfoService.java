package service;

import Dao.dao.FavouritesMapper;
import Dao.dao.NoteMapper;
import Dao.dao.UserMapper;
import Dao.model.Favourites;
import Dao.model.Note;
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
    public String changeSelfInformation(Integer userId,String email,Float score,Float GPA,Float GRE){
        user=new User();
        user.setUserid(userId);
        user.setEmailaddress(email);
        user.setScore(score);
        user.setGpa(GPA);
        user.setGrescore(GRE);
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
