package Online.Help.Desk.Controller;


import Online.Help.Desk.Model.Ticket;
import Online.Help.Desk.Model.User;
import Online.Help.Desk.Repository.TicketRepository;
import Online.Help.Desk.Service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class IndexController {

@Autowired
    UserService userService;

@Autowired
    TicketRepository ticketRepository;


    @ModelAttribute("loggedInUser")
    public User populateUserDetails(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User loggedInUser = userService.findUserByEmail(auth.getName());
        return loggedInUser;
    }

    @RequestMapping(value = "")
    public String index(Model model, @ModelAttribute("loggedInUser") User loggedInUser, HttpServletRequest request){

        List<Ticket> openTickets = ticketRepository.findAll();
        model.addAttribute("openTickets", openTickets);


        return "index";
    }

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String login(Model model){
        model.addAttribute("title", "login");
//        User adminExists = userService.findUserByEmail("admin@admin.com");
//
//        if(adminExists == null){
//            User admin = new User();
//            admin.setFirstName("admin");
//            admin.setLastName("admin");
//            admin.setEmail("admin@admin.com");
//            admin.setPassword("admin");
//            userService.saveUser(admin);
//        }
//
//        System.out.println(adminExists.getPassword());

        return "login";
    }


}
