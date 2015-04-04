package controller;

/**
 * Created by Administrator on 2015/4/4.
 */
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/sinfoma")
public class SInfomaController {
    @RequestMapping(value="/addmore",method = RequestMethod.GET)
    public void printWelcome(Model model) {
        //model.addAttribute("message", "Hello world!");
        System.out.println("get ajax");
        //return "index";
    }
}

