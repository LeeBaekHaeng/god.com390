package god.test.kakaologin.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GodTestKakaoLoginController {

	@GetMapping("/kakaologin/login.do")
	public String login(Model model) {
		return "god/test/kakaologin/login";
	}

	@GetMapping("/oauth")
	public String oauth(Model model) {
		return "god/test/kakaologin/oauth";
	}

}
