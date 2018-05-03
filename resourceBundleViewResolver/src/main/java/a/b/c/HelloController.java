package a.b.c;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

	@RequestMapping("/info")
	public String home(Model model) {
		model.addAttribute("msg","ResourceBundleViewResolver Demo");
		return "home";
	}
	
	@RequestMapping("/home")
	public String getInfo() {
		return "refer";
	}

	
	
}
