package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import service.AddNoteService;

import javax.servlet.http.HttpSession;

/**
 * Created by badguy on 2015/4/9.
 */
@Controller
public class SendCommentController {
    @Autowired(required = false)
    AddNoteService addNoteService;
    @RequestMapping(value = "/sendcomment",method = RequestMethod.POST)
    public String  getSendInfo(ModelMap modelMap,
                             @RequestParam(value = "notemessage",required = false)String message,
                             @RequestParam(value = "notetitle",required = false)String title,
                             HttpSession httpSession
                             ){
            System.out.println(message);
            Integer userId=(Integer)httpSession.getAttribute("userId");
            addNoteService.addNote(userId,title,message);
            return "selfinfo";
        }

}
