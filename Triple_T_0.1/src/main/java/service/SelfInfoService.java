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
    public String getselfino(String userName,String email,float score,float GPA,float GRE){
        user=new User();
        user = userMapper.selectByUserName(userName);
        user.setEmailaddress(email);
//        Md5PasswordEncoder md5PasswordEncoder = new Md5PasswordEncoder();
//        String md5Pwd=md5PasswordEncoder.encodePassword(password,userName);
//        user.setPassword(md5Pwd);
        user.setScore(score);
        user.setGpa(GPA);
        user.setGrescore(GRE);
        try {
            userMapper.updateByPrimaryKey(user);
        }
        catch (Exception e){
            e.printStackTrace();
            return "update failed";
        }
        return "success";

    }
}
