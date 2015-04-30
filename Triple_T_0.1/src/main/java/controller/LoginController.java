package controller;

import com.google.code.kaptcha.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import service.LoginService;


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
    public
    @ResponseBody
    String getLoginResult(ModelMap modelMap,
                                    @RequestParam(value="userName",required = false) String userName,
//                                  @RequestParam(value="email",required = false) String email,
                                    @RequestParam(value="password",required = false) String password,
                                    @RequestParam(value = "verifyCode",required = false) String verifyCode,
                                    HttpServletRequest request,
                                    HttpSession httpSession
    ) {
        System.out.println("login");
        String code = (String)request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
        code = code.toLowerCase();
        if(verifyCode.length()==0){
            return "验证码为空";
        }
        verifyCode = verifyCode.toLowerCase();
        if (verifyCode.equals(code)){
            if(userName.length()==0){
                return "用户名为空";
            }
            else if(password.length()==0){
                System.out.println("密码为空");
                return "密码为空";
            }else{
                int resultCode=loginService.getLoginInfo(userName,password);
                System.out.println("resultcode=" + resultCode);
                if(resultCode>0){
                    httpSession.setAttribute("flag",true);
                    httpSession.setAttribute("userId",resultCode);
                    httpSession.setAttribute("userName",userName);
                    return "登录成功";
                }
                else if(resultCode==-1){
                    return "密码错误";
                }
                else{
                    return "用户不存在";
                }
            }
        }
        else{
           return "验证码错误";
        }

    }

}