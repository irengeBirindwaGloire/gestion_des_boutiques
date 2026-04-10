package nsim.coding.boutique.controllers;

import org.springframework.stereotype.Controller;

import ch.qos.logback.core.model.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

    @GetMapping(path = "/", name = "boutique.dashboard")
    public String dashboard(Model model) {
        return "dashboard/index";
    }
}
