package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import service.AddCommentService;
import service.FavouriteNoteService;

import javax.servlet.http.HttpSession;

/**
 * Created by Administrator on 2015/4/7.
 */
@Controller
@RequestMapping("/blogdetail")
public class BlogDetailController {
    @Autowired(required = false)
    FavouriteNoteService favouriteNoteService;
    @Autowired(required = false)
    AddCommentService addCommentService;
    @RequestMapping(value = "comment",method = RequestMethod.GET)
    public void getcomment(ModelMap modelMap,
                                 @RequestParam(value="param",required = false) String commentContent,
                                 @RequestParam(value="noteId",required = false) Integer noteId,
                                 HttpSession httpSession){
        System.out.println("get comment=" + commentContent);
        Integer userId=(Integer)httpSession.getAttribute("userId");
        if(userId!=null){
            addCommentService.addComment(userId,noteId,commentContent);
        }


    }

    @RequestMapping(value = "collect",method = RequestMethod.GET)
    public void getBlogCollect(ModelMap modelMap,
                                 @RequestParam(value="param",required = false) String param,
                                 @RequestParam(value="noteId",required = false)Integer noteId,
                                 HttpSession httpSession){
        System.out.println("get collect="+ param);
        Integer userId=(Integer)httpSession.getAttribute("userId");
        System.out.println(noteId);
        if(param.equals("collect")){
            favouriteNoteService.collectNote(userId,noteId);
        }else{
            favouriteNoteService.collectNoteCancle(userId,noteId);
        }

    }
}
