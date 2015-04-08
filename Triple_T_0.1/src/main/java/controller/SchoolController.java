package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import service.FavouriteSchoolService;

import javax.servlet.http.HttpSession;

/**
 * Created by Administrator on 2015/4/5.
 */
@Controller
public class SchoolController {
    @Autowired
    FavouriteSchoolService favouriteSchoolService;
    @RequestMapping(value = "/school/{schoolId}",method = RequestMethod.GET)
    public String getSchool(ModelMap modelMap,
                                 @PathVariable(value="schoolId") Integer schoolId,
                                 HttpSession httpSession
                            ){
        Integer userId=(Integer)httpSession.getAttribute("userId");
        if(userId==null){
            httpSession.setAttribute("favourFlag",false);
            modelMap.addAttribute("schoolId",schoolId);
            return "school";
        }
        boolean result=favouriteSchoolService.getFavouriteSchoolResult(userId,schoolId);
        httpSession.setAttribute("favourFlag",false);
        if(result){
            httpSession.setAttribute("favourFlag", true);
        }
        modelMap.addAttribute("schoolId",schoolId);
        return "school";
    }

    @RequestMapping(value = "/school/collect",method = RequestMethod.GET)
    public String getSchoolCollect(ModelMap modelMap,
                                 @RequestParam(value="param",required = false) String param,
                                 @RequestParam(value="schoolId",required = false) Integer schoolId,
                                 HttpSession httpSession
                                 ){
        //传过来的参数有两种可能：收藏学校(表示要收藏)，已收藏(表示要取消收藏)。当为“收藏学校时”，返回字符串“已收藏”；否则返回“收藏学校”
        Integer userId=(Integer)httpSession.getAttribute("userId");
        System.out.println(schoolId);
        if(param.equals("collect")){
            favouriteSchoolService.collectSchool(userId,schoolId);
            return "school";
        }else{
            favouriteSchoolService.collectSchoolCancle(userId,schoolId);
            return "school";
        }
    }
}
