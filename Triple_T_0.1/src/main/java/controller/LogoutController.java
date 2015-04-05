package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

/**
 * Created by badguy on 2015/4/5.
 */
@Controller
public class LogoutController {
    @RequestMapping(value = "/logout",method = RequestMethod.GET)
    public String logout(HttpSession httpSession){
        httpSession.setAttribute("flag",false);
        return "index";

    }
}
