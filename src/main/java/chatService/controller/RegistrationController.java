package chatService.controller;

import chatService.model.security.ChatUser;
import chatService.service.ChatUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class RegistrationController {

    private final ChatUserService userService;

    @RequestMapping(path = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("userForm", new ChatUser());
        return "registration";
    }

    @RequestMapping(path = "/registration", method = RequestMethod.POST)
    public String addUser(@ModelAttribute("userForm") @Valid ChatUser userForm,
                          BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) return "registration";
        if (!userForm.getPassword().equals(userForm.getConfirmPassword())) {
            model.addAttribute("passwordError", "Passwords do not match");
            return "registration";
        }
        if (!userService.saveUser(userForm)) {
            model.addAttribute("usernameError",
                    "A user with the same name already exists");
            return "registration";
        }
        model.addAttribute("username", userForm.getUsername());
        return "redirect:/login";
    }
}
