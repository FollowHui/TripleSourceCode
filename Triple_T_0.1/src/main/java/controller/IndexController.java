package controller;

import Dao.model.Note;
import Dao.model.SchoolNews;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.GetAllNotesService;
import service.GetSchoolNewsService;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Administrator on 2015/4/4.
 */
@Controller
@RequestMapping("/")
public class IndexController {
    @Autowired
    GetSchoolNewsService getSchoolNewsService;
    @Autowired
    GetAllNotesService getAllNotesService;
    @RequestMapping(value="index", method = RequestMethod.GET)
    public String getJump1(){
        System.out.println("get ajax index");
        return "bg";
    }

    @RequestMapping(value="sInfoma", method = RequestMethod.GET)
    public String getJump2(ModelMap modelMap,HttpSession httpSession){
        int sInfoCount=2;
        httpSession.setAttribute("sInfoCount",sInfoCount);
        List<SchoolNews> schoolNewsList=getSchoolNewsService.getschoolNews(sInfoCount);
        modelMap.addAttribute("schoolNewsList",schoolNewsList);
        return "sInfoma";
    }

    @RequestMapping(value="sList", method = RequestMethod.GET)
    public String getJump3(){
        System.out.println("get ajax sList");
        return "sList";
    }

    @RequestMapping(value="blogList", method = RequestMethod.GET)
    public String getJump4(ModelMap modelMap,HttpSession httpSession){
        int noteCount=2;
        httpSession.setAttribute("noteCount",noteCount);
        List<Note> noteList;
        noteList=getAllNotesService.getAllNotes(noteCount);
        modelMap.addAttribute("noteList",noteList);
        return "blogList";
    }
}
