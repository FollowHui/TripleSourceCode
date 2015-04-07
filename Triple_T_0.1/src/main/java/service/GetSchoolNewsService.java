package service;

import Dao.dao.SchoolNewsMapper;
import Dao.model.SchoolNews;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2015/4/5.
 */
@Service
public class GetSchoolNewsService {
    @Autowired(required = false)
    SchoolNews schoolNews;
    @Autowired(required = false)
    SchoolNewsMapper schoolNewsMapper;
    public List<SchoolNews> getschoolNews(Integer sInfoCount){
        List<SchoolNews> schoolNewsList;
        schoolNewsList=schoolNewsMapper.selectAllSchoolNews(sInfoCount);
//        String date=schoolNewsList.get(0).getNewsdate();
//        String dateString;
//        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
//        dateString=dateFormat.format(date);
//        System.out.println(date);
        return schoolNewsList;
    }
}
