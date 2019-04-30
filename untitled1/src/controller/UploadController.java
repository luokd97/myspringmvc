package controller;

import org.apache.commons.lang.xwork.RandomStringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import pojo.UploadedImageFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@Controller
public class UploadController {
    @RequestMapping("/uploadImage")
    public ModelAndView upload(HttpServletRequest request, UploadedImageFile file) throws IOException {
        String name = RandomStringUtils.randomAlphanumeric(10);

        String clientFileName = file.getImage().getOriginalFilename();
        String suffix = clientFileName.substring(clientFileName.lastIndexOf('.'));

        String newFileName = name + suffix;
        File newFile = new File(request.getServletContext().getRealPath("/image"),newFileName);
        newFile.getParentFile().mkdirs();

        file.getImage().transferTo(newFile);

        ModelAndView mav = new ModelAndView("showUploadFile");
        mav.addObject("imageName",newFileName);

        return mav;
    }
}
