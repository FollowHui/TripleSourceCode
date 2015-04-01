package controller;

import com.google.code.kaptcha.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import service.LoginService;
import service.RegisterService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by Administrator on 2015/3/31.
 */
@Controller
public class LoginController {
    @Autowired
    LoginService loginService;
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String getLoginResult(ModelMap modelMap,
                                    @RequestParam(value="userName",required = false) String userName,
//                                  @RequestParam(value="email",required = false) String email,
                                    @RequestParam(value="password",required = false) String password,
                                    @RequestParam(value = "verifyCode") String verifyCode,
                                    HttpServletRequest request,
                                    HttpSession httpSession
    ) {
        String code = (String)request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
        code = code.toLowerCase();
        verifyCode = verifyCode.toLowerCase();
        System.out.println(verifyCode);
        if (verifyCode.equals(code)){
            System.out.println("match verifyCode");
        }
        modelMap.addAttribute("message","dongge");
        System.out.println(userName);
        System.out.println(password);
        int resultCode=loginService.getLoginInfo(userName,password);
        if(resultCode>0){
            httpSession.setAttribute("flag",true);
            httpSession.setAttribute("userId",resultCode);
            httpSession.setAttribute("userName",userName);
        }
        return "hello";
    }

}