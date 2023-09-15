package com.example.lab5_20206442.controllers;

import com.example.lab5_20206442.entity.Mascotas;
import com.example.lab5_20206442.entity.Viajes;
import com.example.lab5_20206442.reposity.LugaresRepository;
import com.example.lab5_20206442.reposity.MascotasRepository;
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
@RequestMapping("/mascotas")
public class MascotasControllers {

    final   ViajesRepository viajesRepository;
    final LugaresRepository lugaresRepository;
    final PersonasRepository personasRepository;
    final MascotasRepository mascotasRepository;
    public MascotasControllers( ViajesRepository viajesRepository, PersonasRepository personasRepository, LugaresRepository lugaresRepository, MascotasRepository mascotasRepository){
        this.viajesRepository = viajesRepository;
        this.lugaresRepository = lugaresRepository;
        this.personasRepository = personasRepository;
        this.mascotasRepository = mascotasRepository;
    }
    @GetMapping("")
    public String principal(Model model){
        model.addAttribute("listaMascotas",mascotasRepository.findAll());
        return "mascotas";
    }

    @GetMapping("/new")
    public String NuevoViaje(Model model){
        model.addAttribute("listaPersonas", personasRepository.findAll());

        return "newFrmMascota";
    }
    @PostMapping("save")
    public String guardar(Mascotas mascotas,RedirectAttributes attr){
        mascotasRepository.save(mascotas);
        return "redirect:/viajes";
    }

    @GetMapping("/delete")
    public String borrarTransportista(RedirectAttributes attr,
                                      @RequestParam("id") int id) {

        Optional<Mascotas> optionalMascotas = mascotasRepository.findById(id);

        if (optionalMascotas.isPresent()) {
            mascotasRepository.deleteById(id);
        }
        return "redirect:/mascotas";

    }



}
