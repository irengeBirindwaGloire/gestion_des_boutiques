package nsim.coding.boutique.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.validation.Valid;
import nsim.coding.boutique.dtos.BoutiqueDto;
import nsim.coding.boutique.services.BoutiqueService;

@Controller
@RequestMapping(path = "/store", name = "boutique.home")
public class BoutiqueController {

    private final BoutiqueService boutiqueService;

    public BoutiqueController(BoutiqueService boutiqueService) {
        this.boutiqueService = boutiqueService;
    }

    @GetMapping(path = "/", name = "boutique.home")
    public String home(Model model,
            @RequestParam(defaultValue = "0") int p,
            @RequestParam(defaultValue = "10") int s) {

        model.addAttribute("listeBoutique", boutiqueService.getAllBoutiques(p, s));
        return "dashboard/index";
    }

    @GetMapping(path = "/new", name = "store.new")
    public String newBoutique(Model model) {
        model.addAttribute("boutique", new BoutiqueDto());
        return "boutique/createBoutique";
    }

    @PostMapping(path = "/addBoutique", name = "store.create")
    public String createBoutique(@Valid @ModelAttribute BoutiqueDto boutiqueDto,
            BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("messageError",
                    "Echec, La boutique n'a pas été ajouté.");
        } else {
            boutiqueService.createBoutique(boutiqueDto);
            redirectAttributes.addFlashAttribute("messageSucces",
                    "La boutique " + boutiqueDto.getDesignation() + " ajouté avec succès.");
        }

        return "redirect:/store/new";

    }

}
