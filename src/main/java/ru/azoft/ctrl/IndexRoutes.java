package ru.azoft.ctrl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class IndexRoutes {

    @RequestMapping({
            "/",
            "/about"
    })
    public String index() {
        return "forward:/WEB-INF/views/index.jsp";
    }

}



