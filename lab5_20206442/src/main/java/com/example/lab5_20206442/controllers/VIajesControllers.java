package com.example.lab5_20206442.controllers;

import com.example.lab5_20206442.entity.Viajes;
import com.example.lab5_20206442.reposity.LugaresRepository;
import com.example.lab5_20206442.reposity.PersonasRepository;
import com.example.lab5_20206442.reposity.ViajesRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/viajes")
public class VIajesControllers {

    final ViajesRepository viajesRepository;
    final LugaresRepository lugaresRepository;
    final PersonasRepository personasRepository;
    public VIajesControllers( ViajesRepository viajesRepository, PersonasRepository personasRepository, LugaresRepository lugaresRepository){
        this.viajesRepository = viajesRepository;
        this.lugaresRepository = lugaresRepository;
        this.personasRepository = personasRepository;
    }

    @GetMapping("")
    public String inicio(Model model){
        model.addAttribute("listaViajes", viajesRepository.findAll());
        return "viajes";
    }

    @GetMapping("/new")
    public String NuevoViaje(Model model){
        model.addAttribute("listaPersonas", personasRepository.findAll());
        model.addAttribute("listaLugares", lugaresRepository.findAll());

        return "newFrmViaje";
    }

    @GetMapping("/edit")
    public String editarTransportista(Model model, @RequestParam("id") int id) {

        Optional<Viajes> optionalViajes = viajesRepository.findById(id);

        if (optionalViajes.isPresent()) {
            Viajes viajes=optionalViajes.get();
            model.addAttribute("listaPersonas", personasRepository.findAll());
            model.addAttribute("listaLugares", lugaresRepository.findAll());
            model.addAttribute("viaje",viajes);

            return "editFrmViaje";
        } else {
            return "redirect:/viajes";
        }
    }

    @PostMapping("save")
    public String guardar(Viajes viajes,RedirectAttributes attr){
        viajesRepository.save(viajes);
        return "redirect:/viajes";
    }


    @GetMapping("/delete")
    public String borrarTransportista(RedirectAttributes attr,
                                      @RequestParam("id") int id) {

        Optional<Viajes> optionalViajes = viajesRepository.findById(id);

        if (optionalViajes.isPresent()) {
            viajesRepository.deleteById(id);
        }
        return "redirect:/viajes";

    }



}
