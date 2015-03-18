package service;

import Dao.dao.UserMapper;
import Dao.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2015/3/17.
 */
@Service
public class RegisterService {
    @Autowired(required = false)
    private UserMapper userMapper;
    public String saveUserInformation(User user){
        userMapper.insert(user);
        return "just test";
    }
}
