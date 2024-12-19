package xin.chunming.moneymanager.Controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class clearmainController {

    @RequestMapping(value = "/clear",produces = "application/json")
    @ResponseBody
    public String now(HttpSession hs) {
        hs.removeAttribute("monthyear");
        return "{\"code\":\"200\"}";

    }
}
