package controller;

/**
 * Created by Administrator on 2015/4/5.
 */
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/slist")
public class SListController {
    @RequestMapping(value="/filter1",method = RequestMethod.GET)
    public void slistAddrRankFilter(ModelMap modelMap,
                                    @RequestParam(value="param",required = false) String filter,
                                    @RequestParam(value="sel",required = false) String sel) {
        //model.addAttribute("message", "Hello world!");
        System.out.println("get ajax " + filter + " " + sel);
        //return "index";
    }

    @RequestMapping(value="/filter2",method = RequestMethod.GET)
    public void printWelcome(ModelMap modelMap,
                             @RequestParam(value="low",required = false) String low,
                             @RequestParam(value="high",required = false) String high) {
        //model.addAttribute("message", "Hello world!");
        System.out.println("get filter " + low + " " + high);
        //return "index";
    }
}
