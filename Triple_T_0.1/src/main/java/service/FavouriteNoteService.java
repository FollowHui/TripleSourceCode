package service;

import Dao.dao.FavouritesMapper;
import Dao.dao.NoteMapper;
import Dao.model.Favourites;
import Dao.model.Note;
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
    @Autowired(required = false)
    NoteMapper noteMapper;
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
        Note note=noteMapper.selectByPrimaryKey(noteId);
        Integer collectedTime=note.getCollectedtimes();
        collectedTime++;
        note.setCollectedtimes(collectedTime);
        noteMapper.updateByPrimaryKeySelective(note);
    }
    public void collectNoteCancle(Integer userId,Integer noteId){
        Favourites favourites=new Favourites();
        favourites.setSchoolornoteid(noteId);
        favourites.setUserid(userId);
        favouritesMapper.collectNoteCancle(favourites);
        Note note=noteMapper.selectByPrimaryKey(noteId);
        Integer collectedTime=note.getCollectedtimes();
        collectedTime--;
        note.setCollectedtimes(collectedTime);
        noteMapper.updateByPrimaryKeySelective(note);

    }
}
