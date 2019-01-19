package SpringMvc.Frontend;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import model.User;
import service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/registration")
	public String addUser(Model model) {
		model.addAttribute("user",new User());
		return "registration";
	}
	
	@PostMapping("/registration")
	public String addNewUser(@ModelAttribute("user")User user)
	{
		userService.addUser(user);
		return "redirect:/login";
	}
	
	@GetMapping("/login")
	public String loginPage() {
		return "login";
	}
	@PostMapping("/login")
	public String login(@RequestParam("username")String username,@RequestParam("password")String password,Model model,HttpSession session) {
		User user=userService.login(username, password);
		if(user!=null) {
			session.setAttribute("user",user);
			return "redirect:/";
		}else {
			model.addAttribute("login_error","Invalid Credentials");
			return "login";
		}
	}
	}


