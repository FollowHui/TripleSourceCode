package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Administrator on 2015/4/5.
 */
@Controller
@RequestMapping("/")
public class SchoolController {
    @RequestMapping(value = "school",method = RequestMethod.GET)
    public String getLoginResult(ModelMap modelMap,
                                 @RequestParam(value="id",required = false) String id){
        System.out.println("get id="+id);
        return "school";
    }
}
