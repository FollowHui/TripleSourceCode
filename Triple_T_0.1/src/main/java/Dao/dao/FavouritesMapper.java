package Dao.dao;

import Dao.model.Favourites;

public interface FavouritesMapper {
    int deleteByPrimaryKey(Integer collectid);

    int insert(Favourites record);

    int insertSelective(Favourites record);

    Favourites selectByPrimaryKey(Integer collectid);

    int updateByPrimaryKeySelective(Favourites record);

    int updateByPrimaryKey(Favourites record);
}