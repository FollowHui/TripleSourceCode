package controller;

import Dao.model.Favourites;
import Dao.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import service.AddNoteService;
import service.SelfInfoService;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by badguy on 2015/4/9.
 */
@Controller
public class SendCommentController {
    @Autowired(required = false)
    SelfInfoService selfInfoService;
    @Autowired(required = false)
    AddNoteService addNoteService;
    @RequestMapping(value = "/sendcomment",method = RequestMethod.POST)
    public String getSendInfo(ModelMap modelMap,
                             @RequestParam(value = "notemessage",required = false)String message,
                             @RequestParam(value = "notetitle",required = false)String title,
                             HttpSession httpSession
                             ){
        System.out.println(message);
        Integer userId = (Integer) httpSession.getAttribute("userId");
        if (userId != null) {
            User user;
            List<Favourites> favouritesList;
            List<Favourites> favouriteSchoolList;
            System.out.println(userId);
            user = selfInfoService.getSelfInfomation(userId);
            favouritesList=selfInfoService.getUserFavourNote(userId);
            favouriteSchoolList=selfInfoService.getUserFavourSchool(userId);
            modelMap.addAttribute("user", user);
            modelMap.addAttribute("noteList",favouritesList);
            modelMap.addAttribute("schoolList",favouriteSchoolList);
            addNoteService.addNote(userId,title,message);
            return "selfinfo";
        }
        return "selfinfo";
        }

}
