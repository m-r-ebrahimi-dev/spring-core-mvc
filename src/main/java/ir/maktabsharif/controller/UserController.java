package ir.maktabsharif.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/user")
public class UserController {
    @RequestMapping(value = {"/", ""}, method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    @RequestMapping(value = "user", method = RequestMethod.GET)
    public String getUser(Model model) {
        model.addAttribute("userName", "test");
        return "user";
    }

    @RequestMapping(value = "userByUsername", method = RequestMethod.GET)
    public String login(@RequestParam("userId") Integer userId) {
        System.out.println(userId);
        return "login";
    }

    @RequestMapping(value = "userById/{userId}", method = RequestMethod.GET)
    public String login(@PathVariable("userId") Integer userId, Model model) {
        System.out.println(userId);
        return "login";
    }
}
