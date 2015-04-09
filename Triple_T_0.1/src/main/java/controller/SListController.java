package controller;

/**
 * Created by Administrator on 2015/4/5.
 */
import Dao.dao.SchoolInformationMapper;
import Dao.model.SchoolInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import service.GetSchoolService;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/slist")
public class SListController {
    @Autowired(required = false)
    GetSchoolService getSchoolService;
    @RequestMapping(value="/filter1",method = RequestMethod.GET)
    public String slistAddrRankFilter(ModelMap modelMap,
                                    @RequestParam(value="param",required = false) String filter,
                                    @RequestParam(value="sel",required = false) String sel,
                                    HttpSession httpSession) {
        System.out.println("get ajax " + filter + " " + sel);
//        String oldFilter11=(String)httpSession.getAttribute("filter11");
//        String oldFilter12=(String)httpSession.getAttribute("filter12");
//        String oldFilter13=(String)httpSession.getAttribute("filter13");
//        String oldFilter14=(String)httpSession.getAttribute("filter14");
//        String oldFilter15=(String)httpSession.getAttribute("filter15");
//        String oldFilter21=(String)httpSession.getAttribute("filter21");
//        String oldFilter22=(String)httpSession.getAttribute("filter22");
//        String oldFilter23=(String)httpSession.getAttribute("filter23");
//        String oldFilter24=(String)httpSession.getAttribute("filter24");
//        String oldFilter25=(String)httpSession.getAttribute("filter25");
        List<SchoolInformation> schoolInformations;
//        if((oldFilter11!=null&&oldFilter11.equals(true)&&(!filter.equals("11")))
//                ||
//                oldFilter11==null&&filter.equals("11")&&sel.equals("true")){
//            httpSession.setAttribute("filter11",true);
//            schoolInformations=
//        }else {
//            httpSession.setAttribute("filter11",false);
//        }
        schoolInformations=getSchoolService.getSchoolListByContinent(1);
        System.out.println(schoolInformations.get(1).getDescription());
        modelMap.addAttribute("schoolList",schoolInformations);
        return "searchRs";
    }

//    @RequestMapping(value="/filter2",method = RequestMethod.GET)
//    public void printWelcome(ModelMap modelMap,
//                             @RequestParam(value="low",required = false) String low,
//                             @RequestParam(value="high",required = false) String high) {
//        //model.addAttribute("message", "Hello world!");
//        System.out.println("get filter " + low + " " + high);
//        //return "index";
//    }
}
