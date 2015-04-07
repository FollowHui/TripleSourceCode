package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import service.RegisterService;

/**
 * Created by Administrator on 2015/3/30.
 */
@Controller
public class RegisterController {
    @Autowired
    RegisterService registerService;
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String getRegisterResult(ModelMap modelMap,
                                    @RequestParam(value="userName",required = false) String userName,
                                    @RequestParam(value="email",required = false) String email,
                                    @RequestParam(value="password",required = false) String password,
                                    @RequestParam(value="sex",required = false) String sex
                                    ) {
        boolean realSex;
        if(sex.equals("female")){
            realSex=false;
        }else{
            realSex=true;
        }
        String result=registerService.getRegInfo(userName,email,password,realSex);
        System.out.println(result);
        return "index";

    }

}



