package service;

import Dao.dao.NoteMapper;
import Dao.model.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2015/4/9.
 */
@Service
public class AddNoteService {
    @Autowired(required = false)
    NoteMapper noteMapper;
    public void addNote(Integer userId,String title,String content){
        Note note=new Note();
        note.setPushcontent(content);
        note.setUserid(userId);
        note.setTitle(title);
        note.setCollectedtimes(0);
        noteMapper.insertSelective(note);
    }
}
