package service;

import Dao.dao.SchoolNewsMapper;
import Dao.dao.UserMapper;
import Dao.model.User;
import Dao.model.schoolNews;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/4/5.
 */
@Service
public class GetSchoolNewsService {
    @Autowired(required = false)
    Dao.model.schoolNews schoolNews;
    @Autowired(required = false)
    SchoolNewsMapper schoolNewsMapper;
    @Autowired(required = false)
    UserMapper userMapper;
    public List<Dao.model.schoolNews> getschoolNews(Integer userId){
        User user=userMapper.selectByPrimaryKey(userId);
        Integer schoolId=user.getSchoolId();
        List<Dao.model.schoolNews> schoolNewsList=new ArrayList<Dao.model.schoolNews>();
        if(schoolId!=null){
            schoolNewsList=schoolNewsMapper.selectSchoolNewsBySchoolId(schoolId);
        }
//        String date=schoolNewsList.get(0).getNewsdate();
//        String dateString;
//        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
//        dateString=dateFormat.format(date);
//        System.out.println(date);
        return schoolNewsList;
    }
}
