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
import java.util.Iterator;
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
        String oldFilter11=(String)httpSession.getAttribute("filter11");
        String oldFilter12=(String)httpSession.getAttribute("filter12");
        String oldFilter13=(String)httpSession.getAttribute("filter13");
        String oldFilter14=(String)httpSession.getAttribute("filter14");
        String oldFilter15=(String)httpSession.getAttribute("filter15");
        String oldFilter21=(String)httpSession.getAttribute("filter21");
        String oldFilter22=(String)httpSession.getAttribute("filter22");
        String oldFilter23=(String)httpSession.getAttribute("filter23");
        String oldFilter24=(String)httpSession.getAttribute("filter24");
        String oldFilter25=(String)httpSession.getAttribute("filter25");
        List<SchoolInformation> schoolInformationsContury=new ArrayList<SchoolInformation>();
        List<SchoolInformation> schoolInformationsRank=new ArrayList<SchoolInformation>();
        if((oldFilter11!=null&&oldFilter11.equals("true")&&(!filter.equals("11")))
                ||
                filter.equals("11")&&sel.equals("true")){
            httpSession.setAttribute("filter11","true");
            schoolInformationsContury.addAll(getSchoolService.getSchoolListByContinent(1));
        }else {
            httpSession.setAttribute("filter11","false");
        }
        if((oldFilter12!=null&&oldFilter12.equals("true")&&(!filter.equals("12")))
                ||
                filter.equals("12")&&sel.equals("true")
                ){
            httpSession.setAttribute("filter12","true");
            schoolInformationsContury.addAll(getSchoolService.getSchoolListByContinent(2));
        }else {
            httpSession.setAttribute("filter12","false");
        }
        if((oldFilter13!=null&&oldFilter13.equals("true")&&(!filter.equals("13")))
                ||
                filter.equals("13")&&sel.equals("true")){
            httpSession.setAttribute("filter13","true");
            schoolInformationsContury.addAll(getSchoolService.getSchoolListByContinent(3));
        }else {
            httpSession.setAttribute("filter13","false");
        }
        if((oldFilter14!=null&&oldFilter14.equals("true")&&(!filter.equals("14")))
                ||
                filter.equals("14")&&sel.equals("true")){
            httpSession.setAttribute("filter14","true");
            schoolInformationsContury.addAll(getSchoolService.getSchoolListByContinent(4));
        }else {
            httpSession.setAttribute("filter14","false");
        }
        if((oldFilter15!=null&&oldFilter15.equals("true")&&(!filter.equals("15")))
                ||
                filter.equals("15")&&sel.equals("true")){
            httpSession.setAttribute("filter15","true");
            schoolInformationsContury.addAll(getSchoolService.getSchoolListByContinent(5));
        }else {
            httpSession.setAttribute("filter15","false");
        }
        if((oldFilter21!=null&&oldFilter21.equals("true")&&(!filter.equals("21")))
                ||
                filter.equals("21")&&sel.equals("true")){
            httpSession.setAttribute("filter21","true");
            if(schoolInformationsContury.size()==0) {
                schoolInformationsRank.addAll(getSchoolService.getSchoolListByRanking(50));
            }else{
                Iterator<SchoolInformation> itr=schoolInformationsContury.iterator();
                while (itr.hasNext()){
                    SchoolInformation schoolInformationTemp=itr.next();
                    int rank=schoolInformationTemp.getRanking();
                    if(rank>0&&rank<50){
                        schoolInformationsRank.add(schoolInformationTemp);
                    }else{
                    }
                }
            }
        }else {
            httpSession.setAttribute("filter21","false");
        }
        if((oldFilter22!=null&&oldFilter22.equals("true")&&(!filter.equals("22")))
                ||
                filter.equals("22")&&sel.equals("true")){
            httpSession.setAttribute("filter22","true");
            if(schoolInformationsContury.size()==0) {
                schoolInformationsRank.addAll(getSchoolService.getSchoolListByRanking(100));
            }else{
                Iterator<SchoolInformation> itr=schoolInformationsContury.iterator();
                while (itr.hasNext()){
                    SchoolInformation schoolInformationTemp=itr.next();
                    int rank=schoolInformationTemp.getRanking();
                    if(rank>50&&rank<100){
                        schoolInformationsRank.add(schoolInformationTemp);
                    }else{
                    }
                }
            }
        }else {
            httpSession.setAttribute("filter22","false");
        }
        if((oldFilter23!=null&&oldFilter23.equals("true")&&(!filter.equals("23")))
                ||
                filter.equals("23")&&sel.equals("true")){
            httpSession.setAttribute("filter23","true");
            if(schoolInformationsContury.size()==0) {
                schoolInformationsRank.addAll(getSchoolService.getSchoolListByRanking(150));
            }else{
                Iterator<SchoolInformation> itr=schoolInformationsContury.iterator();
                while (itr.hasNext()){
                    SchoolInformation schoolInformationTemp=itr.next();
                    int rank=schoolInformationTemp.getRanking();
                    if(rank>100&&rank<150){
                        schoolInformationsRank.add(schoolInformationTemp);
                    }else{
                    }
                }
            }
        }else {
            httpSession.setAttribute("filter23","false");
        }
        if((oldFilter24!=null&&oldFilter24.equals("true")&&(!filter.equals("24")))
                ||
                filter.equals("24")&&sel.equals("true")){
            httpSession.setAttribute("filter24","true");
            if(schoolInformationsContury.size()==0) {
                schoolInformationsRank.addAll(getSchoolService.getSchoolListByRanking(200));
            }else{
                Iterator<SchoolInformation> itr=schoolInformationsContury.iterator();
                while (itr.hasNext()){
                    SchoolInformation schoolInformationTemp=itr.next();
                    int rank=schoolInformationTemp.getRanking();
                    if(rank>150&&rank<200){
                        schoolInformationsRank.add(schoolInformationTemp);
                    }else{
                    }
                }
            }
        }else {
            httpSession.setAttribute("filter24","false");
        }
        if((oldFilter25!=null&&oldFilter25.equals("true")&&(!filter.equals("25")))
                ||
                filter.equals("25")&&sel.equals("true")){
            httpSession.setAttribute("filter25","true");
            if(schoolInformationsContury.size()==0) {
                schoolInformationsRank.addAll(getSchoolService.getSchoolListByRanking(250));
            }else{
                Iterator<SchoolInformation> itr=schoolInformationsContury.iterator();
                while (itr.hasNext()){
                    SchoolInformation schoolInformationTemp=itr.next();
                    int rank=schoolInformationTemp.getRanking();
                    if(rank>200){
                        schoolInformationsRank.add(schoolInformationTemp);
                    }else{
                    }
                }
            }
        }else {
            httpSession.setAttribute("filter25","false");
        }

       // System.out.println(schoolInformationsContury.get(1).getDescription());
        if(schoolInformationsRank.size()==0){
            modelMap.addAttribute("schoolList",schoolInformationsContury);
        }else{
            modelMap.addAttribute("schoolList",schoolInformationsRank);
        }

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
