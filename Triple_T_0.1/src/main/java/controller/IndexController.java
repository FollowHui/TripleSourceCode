package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Administrator on 2015/4/4.
 */
@Controller
@RequestMapping("/")
public class IndexController {
    @RequestMapping(value="index", method = RequestMethod.GET)
    public String getJump1(){
        System.out.println("get ajax index");
        return "bg";
    }

    @RequestMapping(value="sInfoma", method = RequestMethod.GET)
    public String getJump2(){
        System.out.println("get ajax sInfoma");
        return "sInfoma";
    }

    @RequestMapping(value="sList", method = RequestMethod.GET)
    public String getJump3(){
        System.out.println("get ajax sList");
        return "sList";
    }

    @RequestMapping(value="blogList", method = RequestMethod.GET)
    public String getJump4(){
        System.out.println("get ajax blogList");
        return "blogList";
    }
}
