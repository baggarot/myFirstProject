package chatService.controller;

import chatService.service.ChatMessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequiredArgsConstructor
public class MainController {

    private final ChatMessageService messageService;

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("messages", messageService.allMessage());
        return "chat";
    }

    @RequestMapping(path = "/login", method = RequestMethod.GET)
    public String showLoginPage() {
        return "login";
    }

    @RequestMapping(path = "/logout")
    public String logout(HttpServletRequest request) {
        request.getSession(true).invalidate();
        return "redirect:/login";
    }
}
