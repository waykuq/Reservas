package org.cibertec.reservas.controller;

import org.cibertec.reservas.entity.EspecialidadEntity;
import org.cibertec.reservas.service.EspecialidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.springframework.dao.DataIntegrityViolationException;
import jakarta.persistence.PersistenceException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/especialidad")
public class EspecialidadController {

    @Autowired
    private EspecialidadService especialidadService;

    @GetMapping({"", "/", "/index"})
    String index(Model model) {
        model.addAttribute("especialidades", especialidadService.getAll());
        return "admin/especialidad/listar";
    }

    @GetMapping("/crear")
    public String crear(Model model) {
        model.addAttribute("especialidad",new EspecialidadEntity() );

        return "admin/especialidad/crear";
    }

    @GetMapping("/editar/{id}")
    String editar(@PathVariable Integer id, Model model) {
        model.addAttribute("especialidad",especialidadService.getById(id) );

        return "admin/especialidad/editar";
    }

    @GetMapping("/eliminar/{id}")
    String eliminar(@PathVariable Integer id, Model model) {
        model.addAttribute("especialidad",especialidadService.getById(id) );

        return "admin/especialidad/eliminar";
    }

    @PostMapping("/guardar")
    String guardar(@ModelAttribute EspecialidadEntity especialidad, RedirectAttributes redirectAttrs) {
        try {
            especialidadService.modify(especialidad);
            redirectAttrs.addFlashAttribute("success", "Especialidad guardada correctamente.");
        } catch (DataIntegrityViolationException | PersistenceException ex) {
            redirectAttrs.addFlashAttribute("error", "No se puede eliminar la especialidad porque está en uso.");
        } catch (Exception ex) {
            redirectAttrs.addFlashAttribute("error", "Ocurrió un error al guardar la especialidad.");
        }

        return "redirect:/especialidad";
    }

    @PostMapping("/eliminar")
    String eliminar(@ModelAttribute EspecialidadEntity especialidad, RedirectAttributes redirectAttrs) {
        try {
            especialidadService.remove(especialidad.getId());
            redirectAttrs.addFlashAttribute("success", "Especialidad eliminada correctamente.");
        } catch (DataIntegrityViolationException | PersistenceException ex) {
            redirectAttrs.addFlashAttribute("error", "No se puede eliminar la especialidad porque está en uso.");
        } catch (Exception ex) {
            redirectAttrs.addFlashAttribute("error", "Ocurrió un error al eliminar la especialidad.");
        }
        return "redirect:/especialidad";
    }


}