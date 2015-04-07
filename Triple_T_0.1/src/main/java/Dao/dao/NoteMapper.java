package Dao.dao;

import Dao.model.Note;

import java.util.List;


public interface NoteMapper {
    int deleteByPrimaryKey(Integer noteid);

    int insert(Note record);

    int insertSelective(Note record);

    Note selectByPrimaryKey(Integer noteid);

    int updateByPrimaryKeySelective(Note record);

    int updateByPrimaryKey(Note record);

    List<Note> getAllNotes(Integer noteCount);
    Integer getCommentTimes(Integer noteid);
}