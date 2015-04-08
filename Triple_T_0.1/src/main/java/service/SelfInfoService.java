package service;

import Dao.dao.UserMapper;
import Dao.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by badguy on 2015/4/5.
 */
@Service
public class SelfInfoService {
    @Autowired(required = false)
    private UserMapper userMapper;
    @Autowired(required = false)
    private User user;
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
    public User getSelfInfomation(Integer userId){
        try {
            user=userMapper.selectByPrimaryKey(userId);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return user;

    }
}
