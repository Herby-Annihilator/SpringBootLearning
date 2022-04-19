package com.laboratorka.minerals.controllers;

import com.laboratorka.minerals.entities.Mineral;
import com.laboratorka.minerals.repositories.MineralRepository;
import com.laboratorka.minerals.viewModels.MineralViewModel;
import lombok.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/mineral")
public class MineralController {

    private final MineralRepository mineralRepository;

    public MineralController(MineralRepository mineralRepository) {
        this.mineralRepository = mineralRepository;
    }


    @GetMapping("/{id}")
    public String getMineralView(@PathVariable("id") int id, Model model){
        Mineral mineral = mineralRepository.getById(id);
        model.addAttribute(mineral);
        return "minerals";
    }

    @GetMapping("/all")
    public String listMinerals(Model model)
    {
        List<Mineral> minerals = mineralRepository.findAll();
        model.addAttribute("minerals", minerals);
        return "admin";
    }

    @GetMapping("/create")
    public String getAddMineralView(Model model){
        model.addAttribute("mineralViewModel", new MineralViewModel());
        return "addMineral";
    }

    @PostMapping("/create")
    public String createMineral(@ModelAttribute MineralViewModel mineralViewModel, Model model){
        Mineral mineral = FromViewModel(mineralViewModel);
        mineralRepository.save(mineral);
        return "redirect:/admin";
    }

    private Mineral FromViewModel(MineralViewModel mineralViewModel) {
        Mineral mineral = new Mineral();
        mineral.setId(mineralViewModel.getId());
        mineral.setName(mineralViewModel.getName());
        mineral.setDescription(mineralViewModel.getDescription());

        return mineral;
    }

    @DeleteMapping("delete/{id}")
    public ModelAndView delete(@PathVariable("id") int id)
    {
        mineralRepository.deleteById(id);
        return new ModelAndView("redirect:/admin");
    }
//    @GetMapping("/error")
//    public String getErrorText(Model model){
//        model.addAttribute("error");
//        return "error";
//    }
}
