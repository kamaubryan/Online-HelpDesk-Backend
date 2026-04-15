package Online.Help.Desk.Controller;

import Online.Help.Desk.Model.Ticket;
import Online.Help.Desk.Model.User;
import Online.Help.Desk.Repository.TicketRepository;
import Online.Help.Desk.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private TicketRepository ticketRepository;

    @ModelAttribute("loggedInUser")
    public User populateUserDetails(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User loggedInUser = userService.findUserByEmail(auth.getName());
        model.addAttribute("isUser", userService.isUser(loggedInUser));
        model.addAttribute("isAdmin", userService.isAdmin(loggedInUser));
        return loggedInUser;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String userHome(Model model, @ModelAttribute User loggedInUser){
        populateUserDetails(model);

        return "user/index";
    }

    @RequestMapping(value = "{id}")
    public String userPage(Model model, @PathVariable("id") int id){
        //TODO: create stats page
        return "user/stats";
    }

    @RequestMapping(value = "{id}/queue")
    public String userQueue(Model model, @PathVariable("id") int id){
        List<Ticket> openTickets = ticketRepository.findAll();
        model.addAttribute("userTickets", openTickets);
        //TODO: create user queue page
        return "user/queue";
    }

    @RequestMapping(value = "{id}/account")
    public String userSettings(Model model, @PathVariable("id") int id){
        //TODO: create settings page
        return "user/stats";
    }
}
