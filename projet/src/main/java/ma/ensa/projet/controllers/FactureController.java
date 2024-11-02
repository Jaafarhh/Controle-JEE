package ma.ensa.projet.controllers;

import ma.ensa.projet.entities.Facture;
import ma.ensa.projet.repository.ClientRepository;
import ma.ensa.projet.repository.FactureRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class FactureController {

    @Autowired
    private FactureRepository factureRepository;

    @Autowired
    private ClientRepository clientRepository;

    @GetMapping("/facture/new")
    public String showAddFactureForm(Model model) {
        model.addAttribute("facture", new Facture());
        model.addAttribute("clients", clientRepository.findAll());
        return "add-facture";
    }

    @PostMapping("/facture/add")
    public String addFacture(@Valid Facture facture, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("clients", clientRepository.findAll());
            return "add-facture";
        }

        factureRepository.save(facture);
        return "redirect:/client/details/" + facture.getClient().getId();
    }

    @GetMapping("/facture/edit/{id}")
    public String showUpdateFactureForm(@PathVariable("id") long id, Model model) {
        Facture facture = factureRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid facture Id:" + id));
        model.addAttribute("facture", facture);
        model.addAttribute("clients", clientRepository.findAll());
        return "update-facture";
    }

    @PostMapping("/facture/update/{id}")
    public String updateFacture(@PathVariable("id") long id, @Valid Facture facture,
            BindingResult result, Model model) {
        if (result.hasErrors()) {
            facture.setId(id);
            model.addAttribute("clients", clientRepository.findAll());
            return "update-facture";
        }

        factureRepository.save(facture);
        return "redirect:/client/details/" + facture.getClient().getId();
    }

    @GetMapping("/facture/delete/{id}")
    public String deleteFacture(@PathVariable("id") long id, Model model) {
        Facture facture = factureRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid facture Id:" + id));
        Long clientId = facture.getClient().getId();
        factureRepository.delete(facture);
        return "redirect:/client/details/" + clientId;
    }
}
