package service;

import Dao.dao.FavouritesMapper;
import Dao.model.Favourites;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2015/4/7.
 */
@Service
public class FavouriteSchoolService {
    @Autowired(required = false)
    FavouritesMapper favouritesMapper;
    public boolean getFavouriteSchoolResult(Integer userId,Integer schoolId){
        List<Favourites> favouritesList;
        favouritesList=favouritesMapper.selectSchoolByUserId(userId);
        for(Favourites favourites:favouritesList){
            if(favourites==null){
                return false;
            }
            if(favourites.getSchoolornoteid().equals(schoolId)){
                return true;
            }
        }
        return  false;
    }
    public void collectSchool(Integer userId,Integer schoolId){
        Favourites favourites=new Favourites();
        favourites.setCollecttype(true);
        favourites.setSchoolornoteid(schoolId);
        favourites.setUserid(userId);
        favouritesMapper.insertSelective(favourites);
    }
    public void collectSchoolCancle(Integer userId,Integer schoolid){
        Favourites favourites=new Favourites();
        favourites.setSchoolornoteid(schoolid);
        favourites.setUserid(userId);
        favouritesMapper.collectSchoolCancle(favourites);

    }

}
