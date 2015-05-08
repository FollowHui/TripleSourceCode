package controller;

import Dao.model.Favourites;
import Dao.model.Note;
import Dao.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import service.SelfInfoService;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.List;

/**
 * Created by badguy on 2015/5/3.
 */
@Controller
public class uploadPhotoController {
    @Autowired(required = false)
    SelfInfoService selfInfoService;
    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    public String uploadPhoto(
                            @RequestParam(value="file",required = false)CommonsMultipartFile mFile
                            ,HttpSession httpSession,
                            ModelMap modelMap){
        System.out.println("come in upload controller");
        System.out.println(mFile.getBytes().length);
        Integer userId = (Integer) httpSession.getAttribute("userId");
        if (userId != null) {
            if(mFile.getBytes().length==0){
                User user;
                List<Favourites> favouritesList;
                List<Favourites> favouriteSchoolList;
                List<Note> noteList;
                System.out.println(userId);
                user = selfInfoService.getSelfInfomation(userId);
                favouritesList=selfInfoService.getUserFavourNote(userId);
                favouriteSchoolList=selfInfoService.getUserFavourSchool(userId);
                noteList=selfInfoService.getUserNotes(userId);
                modelMap.addAttribute("user", user);
                modelMap.addAttribute("noteList",favouritesList);
                modelMap.addAttribute("schoolList",favouriteSchoolList);
                modelMap.addAttribute("myNotes",noteList);
                return "selfinfo";
            }else {
                String path = new File(this.getClass().getResource("").getPath()).getAbsolutePath();
                path = path + "/../../pages/resources/headImage/";
                String location = path + userId + ".jpg";
                File file = new File(location);
                String pathCopy = "C:\\Users\\Administrator\\Desktop\\计算机设计大赛\\sourceCode\\1.4\\TripleSourceCode201556\\TripleSourceCode\\Triple_T_0.1\\src\\main\\webapp\\WEB-INF\\pages\\resources\\headImage";
                String locationCopy = pathCopy + "/" + userId + ".jpg";
                File fileCopy = new File(locationCopy);
                System.out.println(file.getAbsolutePath());
                try {
                    mFile.getFileItem().write(file);
                    mFile.getFileItem().write(fileCopy);
                    String headImage = userId + ".jpg";
                    selfInfoService.changeImage(userId, headImage);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                User user;
                List<Favourites> favouritesList;
                List<Favourites> favouriteSchoolList;
                List<Note> noteList;
                System.out.println(userId);
                user = selfInfoService.getSelfInfomation(userId);
                favouritesList = selfInfoService.getUserFavourNote(userId);
                favouriteSchoolList = selfInfoService.getUserFavourSchool(userId);
                noteList = selfInfoService.getUserNotes(userId);
                modelMap.addAttribute("user", user);
                modelMap.addAttribute("noteList", favouritesList);
                modelMap.addAttribute("schoolList", favouriteSchoolList);
                modelMap.addAttribute("myNotes", noteList);
                return "selfinfo";
            }
        }else {
            return "redirect:/";
        }
    }

}
