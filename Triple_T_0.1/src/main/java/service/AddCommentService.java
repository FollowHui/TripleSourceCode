package service;

import Dao.dao.CommentMapper;
import Dao.model.Comment;
import Dao.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2015/4/8.
 */
@Service
public class AddCommentService {
    @Autowired(required = false)
    CommentMapper commentMapper;
    public void addComment(Integer userId,Integer noteId,String commentContent){
        Comment comment=new Comment();
        comment.setUserid(userId);
        comment.setNoteid(noteId);
        comment.setCommentcontent(commentContent);
        commentMapper.insertSelective(comment);

    }
}
