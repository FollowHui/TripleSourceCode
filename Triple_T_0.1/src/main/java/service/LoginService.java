package service;

import Dao.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2015/3/17.
 */
@Service
public class LoginService {
    @Autowired(required = false)
    private UserMapper userMapper;


}
