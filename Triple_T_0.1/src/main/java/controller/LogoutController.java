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
        httpSession.setAttribute("favourFlag",false);
        httpSession.setAttribute("favourNoteFlag",false);
        httpSession.removeAttribute("userId");
//        httpSession.removeAttribute("userId");
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
        return "redirect:/";

    }
}
