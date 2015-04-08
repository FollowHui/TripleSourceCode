package service;

import Dao.dao.FavouritesMapper;
import Dao.model.Favourites;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2015/4/8.
 */
@Service
public class FavouriteNoteService {
    @Autowired(required = false)
    FavouritesMapper favouritesMapper;
    public boolean getFavouriteNoteResult(Integer userId,Integer noteId){
        List<Favourites> favouritesList;
        favouritesList=favouritesMapper.selectNoteByUserId(userId);
        for(Favourites favourites:favouritesList){
            if(favourites==null){
                return false;
            }
            if(favourites.getSchoolornoteid().equals(noteId)){
                return true;
            }
        }
        return  false;
    }
    public void collectNote(Integer userId,Integer noteId){
        Favourites favourites=new Favourites();
        favourites.setCollecttype(false);
        favourites.setSchoolornoteid(noteId);
        favourites.setUserid(userId);
        favouritesMapper.insertSelective(favourites);
    }
    public void collectNoteCancle(Integer userId,Integer noteId){
        Favourites favourites=new Favourites();
        favourites.setSchoolornoteid(noteId);
        favourites.setUserid(userId);
        favouritesMapper.collectNoteCancle(favourites);

    }
}
