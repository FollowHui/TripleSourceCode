package service;

import Dao.dao.NoteMapper;
import Dao.model.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2015/4/6.
 */
@Service
public class GetAllNotesService {
    @Autowired(required = false)
    NoteMapper noteMapper;
    public List<Note> getAllNotes(Integer noteCount){
        List<Note> noteList;
        noteList=noteMapper.getAllNotes(noteCount);
        for(Note noteTemp:noteList){
            int commentCount=noteMapper.getCommentTimes(noteTemp.getNoteid());
            noteTemp.setCommentCount(commentCount);
            System.out.println(noteTemp.getTitle());
        }
        return noteList;
    }
}
