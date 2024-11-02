package ma.ensa.projet.controllers;

import ma.ensa.projet.entities.Client;
import ma.ensa.projet.repository.ClientRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class ClientController {

    @Autowired
    private ClientRepository clientRepository;

    @GetMapping("/")
    public String showClientList(Model model) {
        model.addAttribute("clients", clientRepository.findAll());
        return "index";
    }

    @GetMapping("/client/new")
    public String showAddClientForm(Model model) {
        model.addAttribute("client", new Client());
        return "add-client";
    }

    @PostMapping("/client/add")
    public String addClient(@Valid Client client, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-client";
        }

        clientRepository.save(client);
        return "redirect:/";
    }

    @GetMapping("/client/edit/{id}")
    public String showUpdateClientForm(@PathVariable("id") long id, Model model) {
        Client client = clientRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid client Id:" + id));
        model.addAttribute("client", client);
        return "update-client";
    }

    @PostMapping("/client/update/{id}")
    public String updateClient(@PathVariable("id") long id, @Valid Client client, BindingResult result, Model model) {
        if (result.hasErrors()) {
            client.setId(id);
            return "update-client";
        }

        clientRepository.save(client);
        return "redirect:/";
    }

    @GetMapping("/client/delete/{id}")
    public String deleteClient(@PathVariable("id") long id, Model model) {
        Client client = clientRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid client Id:" + id));
        clientRepository.delete(client);
        return "redirect:/";
    }

    @GetMapping("/client/details/{id}")
    public String showClientDetails(@PathVariable("id") long id, Model model) {
        Client client = clientRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid client Id:" + id));
        model.addAttribute("client", client);
        return "client-details";
    }
}