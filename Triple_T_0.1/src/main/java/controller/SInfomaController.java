package controller;

/**
 * Created by Administrator on 2015/4/4.
 */
import Dao.model.schoolNews;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.GetSchoolNewsService;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/sinfoma")
public class SInfomaController {
    @Autowired
    GetSchoolNewsService getSchoolNewsService;
    @RequestMapping(value="/addmore",method = RequestMethod.GET)
    public String printWelcome(ModelMap modelMap,HttpSession httpSession) {
        int sInfoCount=(Integer)httpSession.getAttribute("sInfoCount");
        sInfoCount=sInfoCount+5;
        httpSession.setAttribute("sInfoCount",sInfoCount);
        List<schoolNews> schoolNewsList=getSchoolNewsService.getschoolNews(sInfoCount);
        modelMap.addAttribute("schoolNewsList",schoolNewsList);
        return "sInfoma";
    }
}

