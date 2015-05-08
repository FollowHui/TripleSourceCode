package controller;

import Dao.model.Note;
import Dao.model.SchoolInformation;
import Dao.model.schoolNews;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.GetAllNotesService;
import service.GetSchoolNewsService;
import service.GetSchoolService;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/4/4.
 */
@Controller
@RequestMapping("/")
public class IndexController {
    @Autowired
    GetSchoolService getSchoolService;
    @Autowired
    GetSchoolNewsService getSchoolNewsService;
    @Autowired
    GetAllNotesService getAllNotesService;
    @RequestMapping(value="index", method = RequestMethod.GET)
    public String getJump1(){
        return "bg";
    }

    @RequestMapping(value="sInfoma", method = RequestMethod.GET)
    public String getJump2(ModelMap modelMap,HttpSession httpSession){
        Integer userId=(Integer)httpSession.getAttribute("userId");
        int sInfoCount=5;
        httpSession.setAttribute("sInfoCount",sInfoCount);
        List<schoolNews> schoolNewsList=getSchoolNewsService.getschoolNews(userId);
        modelMap.addAttribute("schoolNewsList",schoolNewsList);
        return "sInfoma";
    }

    @RequestMapping(value="sList", method = RequestMethod.GET)
    public String getJump3(HttpSession httpSession,ModelMap modelMap){
        System.out.println("get ajax sList");
//        httpSession.removeAttribute("filter11");
//        httpSession.removeAttribute("filter12");
//        httpSession.removeAttribute("filter13");
//        httpSession.removeAttribute("filter14");
//        httpSession.removeAttribute("filter15");
//        httpSession.removeAttribute("filter21");
//        httpSession.removeAttribute("filter22");
//        httpSession.removeAttribute("filter23");
//        httpSession.removeAttribute("filter24");
//        httpSession.removeAttribute("filter25");
        int schoolCount=3;
        httpSession.setAttribute("schoolCount",schoolCount);
        httpSession.removeAttribute("filter1");
        httpSession.removeAttribute("filter2");
        List<SchoolInformation> schoolInformationsRank=new ArrayList<SchoolInformation>();
        schoolInformationsRank=getSchoolService.getSchoolListByRanking(50);
        modelMap.addAttribute("schoolList", schoolInformationsRank);
        return "sList";
    }

    @RequestMapping(value="blogList", method = RequestMethod.GET)
    public String getJump4(ModelMap modelMap,HttpSession httpSession){
        int noteCount=5;
        httpSession.setAttribute("noteCount",noteCount);
        List<Note> noteList;
        noteList=getAllNotesService.getAllNotes(noteCount);
        modelMap.addAttribute("noteList",noteList);
        return "blogList";
    }
}
