package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@Controller
public class IndexController{

    @RequestMapping("/index")
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("message","hello spring mvc");
        return mav;
    }

    @RequestMapping("/jump")
    public ModelAndView jump(){
        ModelAndView mav = new ModelAndView("redirect:/index");
        return mav;
    }

    @RequestMapping("/check")
    public ModelAndView check(HttpSession session){
        Integer i = (Integer) session.getAttribute("count");
        if(i==null){
            i=0;
        }
        i++;
        session.setAttribute("count",i);
        ModelAndView mav = new ModelAndView("check");
        return mav;
    }

    @RequestMapping("/clear")
    public ModelAndView clear(HttpSession session){
        session.setAttribute("count",0);
        ModelAndView mav = new ModelAndView("redirect:check");
        return mav;
    }
}
