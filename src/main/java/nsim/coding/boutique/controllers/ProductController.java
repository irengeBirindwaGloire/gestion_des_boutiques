package nsim.coding.boutique.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ch.qos.logback.core.model.Model;

@Controller
@RequestMapping(path = "/product", name = "boutique.home")
public class ProductController {

    @GetMapping(path = "/", name = "product.home")
    public String getMethodName(Model model) {
        return "product/index";
    }

}
