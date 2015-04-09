package controller;

import Dao.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import service.SelfInfoService;

import javax.servlet.http.HttpSession;
/**
 * Created by badguy on 2015/4/5.
 */
@Controller
public class SelfInfoController {
    @Autowired
    SelfInfoService selfInfoService;
    @RequestMapping(value = "/selfinfo/change",method = RequestMethod.GET)
    public void getSaveInfo(ModelMap modelMap,
                              @RequestParam(value="sex",required = false)String sex,
                              @RequestParam(value="email",required = false)String email,
                              @RequestParam(value="grade",required = false)Float score,
                              @RequestParam(value="gradetype",required = false)String gradetype,
                              @RequestParam(value="gpa",required = false)Float gpa,
                              @RequestParam(value="gre",required = false)Float gre,
                              HttpSession httpSession
    ){
        int userId=(Integer)(httpSession.getAttribute("userId"));
        if(score.isNaN()){
            score=null;
        }
        if(gpa.isNaN()){
            gpa=null;
        }
        if(gre.isNaN()){
            gre=null;
        }
        selfInfoService.changeSelfInformation(userId,email,score,gpa,gre);

    }

    @RequestMapping(value = "/selfinfo",method = RequestMethod.GET)
    public String getSaveInfo(ModelMap modelMap,HttpSession httpSession) {
        System.out.println("come in selfinfo controller");
        Integer userId = (Integer) httpSession.getAttribute("userId");
        if (userId != null) {
            User user;
            System.out.println(userId);
            user = selfInfoService.getSelfInfomation(userId);
            modelMap.addAttribute("user", user);
            return "selfinfo";
        }
        return "selfinfo";
    }
}
