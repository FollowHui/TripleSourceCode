package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import java.io.File;

/**
 * Created by badguy on 2015/5/3.
 */
@Controller
public class uploadPhotoController {
    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    public String uploadPhoto(
                            @RequestParam(value="file",required = false)CommonsMultipartFile mFile){
        String path = new File(this.getClass().getResource("").getPath()).getAbsolutePath();
        path = path+"/../../../../../../"+"src/main/webapp/WEB-INF/pages/resources/img/";
        String location = path+"3.jpg";
        File file = new File(location);
        try {
            mFile.getFileItem().write(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "/selfinfo";
    }


}
