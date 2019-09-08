package onlineShop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomePageController {
    
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String returnHomePage() { //通过上一行的/index作为查询时用的网址，通过这一行的return index，来找到page下的jsp 的name为index.jsp的文件，改成index1也可以
        return "index";
    }
    
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(@RequestParam(value = "error", required = false) String error,
            @RequestParam(value = "logout", required = false) String logout) {
        ModelAndView modelAndView = new ModelAndView();
        
        if (error != null) {
            modelAndView.addObject("error", "Invalid username and Password");
        }

        if (logout != null) {
            modelAndView.addObject("logout", "You have logged out successfully");
        }
        
        modelAndView.setViewName("login");
        return modelAndView;
    }
    
    @RequestMapping("/aboutus")
    public String sayAbout() {
        return "aboutUs";
    }
}
