package Dao.dao;

import Dao.model.Note;

public interface NoteMapper {
    int deleteByPrimaryKey(Integer noteid);

    int insert(Note record);

    int insertSelective(Note record);

    Note selectByPrimaryKey(Integer noteid);

    int updateByPrimaryKeySelective(Note record);

    int updateByPrimaryKey(Note record);
}