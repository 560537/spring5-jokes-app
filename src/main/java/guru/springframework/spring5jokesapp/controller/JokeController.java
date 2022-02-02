package guru.springframework.spring5jokesapp.controller;

import guru.springframework.spring5jokesapp.services.JokeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JokeController {

    private final JokeService jokeService;

    // @Autowired // Spring will automatically inject that; we can omit that due to only one single constructor
    public JokeController(JokeService jokeService) {
        this.jokeService = jokeService;
    }

    @RequestMapping({"/",""}) // Array; gives path; if we have '/' or nothing; a request comes to it, goes to the root of the context and that is running the application context
    public String showJoke(Model model) {
        model.addAttribute("joke", jokeService.getJoke());

        return "index";
    }
}
