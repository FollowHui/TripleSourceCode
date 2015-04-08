package Dao.dao;

import Dao.model.Favourites;

import java.util.List;

public interface FavouritesMapper {
    int deleteByPrimaryKey(Integer collectid);

    int insert(Favourites record);

    int insertSelective(Favourites record);

    Favourites selectByPrimaryKey(Integer collectid);

    int updateByPrimaryKeySelective(Favourites record);

    int updateByPrimaryKey(Favourites record);
    List<Favourites> selectSchoolByUserId(int userId);
    int collectSchoolCancle(Favourites record);
    List<Favourites> selectNoteByUserId(int userId);
    int collectNoteCancle(Favourites record);
}