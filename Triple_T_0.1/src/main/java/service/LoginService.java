package service;

import Dao.dao.UserMapper;
import Dao.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2015/3/17.
 */
@Service
public class LoginService {
    @Autowired(required = false)
    private UserMapper userMapper;
    @Autowired(required =  false)
    User user;
    @Autowired(required = false)
    public int getLoginInfo(String userName,String password){
        String passwordTemp;
        try {
            user = userMapper.selectByUserName(userName);
        }
        catch(Exception e){
            e.printStackTrace();
            return -2;
        }
        if(user.getPassword().equals(password)){
            return user.getUserid();
        }
        else {
            return -1;
        }



    }


}
