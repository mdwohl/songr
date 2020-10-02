package com.mdwohl.songr;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller//Spring knows to look at this class and establish controller
public class HomeController {

    @GetMapping("/")
    public String showHome() {//mapping needs to be pub and return string
        return "index";
    }

    @GetMapping("/hello")
    @ResponseBody
    public String helloWorld() {
        return  "Hello world";



    }

        @GetMapping("/capitalize/{var}")
        public String capitalize (
                Model m,
                @PathVariable String var
        ) {
            System.out.println(var.toUpperCase());
            m.addAttribute("uppercase", var.toUpperCase());

            return "capitalize";
    }

}
