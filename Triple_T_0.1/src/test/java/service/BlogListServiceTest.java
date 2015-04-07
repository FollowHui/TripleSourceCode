package service;

import Dao.model.Comment;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/mvc-dispatcher-servlet.xml","file:src/main/webapp/WEB-INF/spring-mybatis.xml"})

public class BlogListServiceTest extends TestCase {
    @Autowired
    BlogListService blogListService;
    @Test
    public void setBlogListService(){
        int noteid=1;
        List<Comment> commentList=blogListService.getCommentsByNoteId(noteid);
        for(Comment comment:commentList){
            System.out.println(comment.getCommentcontent());
            System.out.println(comment.getCommenter());
        }
        blogListService.getNoteByNoteId(noteid);
    }

}