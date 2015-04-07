package service;

import Dao.dao.CommentMapper;
import Dao.dao.NoteMapper;
import Dao.model.Comment;
import Dao.model.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * Created by Administrator on 2015/4/6.
 */
@Service
public class BlogListService {
    @Autowired(required = false)
    NoteMapper noteMapper;
    @Autowired(required = false)
    CommentMapper commentMapper;
    public Note getNoteByNoteId(int noteId){
        Note note;
        note=noteMapper.selectByPrimaryKey(noteId);
        int commentCount=noteMapper.getCommentTimes(noteId);
        note.setCommentCount(commentCount);
        return note;
    }
    public List<Comment> getCommentsByNoteId(int noteId){
        List<Comment> commentList;
        commentList=commentMapper.getCommentsByNoteId(noteId);
        return commentList;
    }

}
