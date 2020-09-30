package com.mdwohl.songr;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Controller//Spring knows to look at this class and establish controller
public class HomeController {

    @GetMapping("/")
    public String showHome() {//mapping needs to be pub and return string
        return "index";
    }

    @GetMapping("/greeting/{to}")
    public String greetPerson(
            Model helloModel,
            String person,
            Integer lastSeenWhen,
            String greeting,
            @PathVariable String to) {
        System.out.println("To :" + to);
        System.out.println(String.format(
                "Message from %s: " +
                        "The last time I saw you was %d ago, %s",
                person,
                lastSeenWhen,
                greeting));

        helloModel.addAttribute("person", person);
        helloModel.addAttribute("days", lastSeenWhen);
        helloModel.addAttribute("greeting", greeting);

        return "helloooo";
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
