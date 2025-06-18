/*package org.cibertec.reservas.controller;

import org.cibertec.reservas.entity.ProveedorEntity;
import org.cibertec.reservas.service.CountryService;
import org.cibertec.reservas.service.ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/proveedor")
public class ProveedorController {

    @Autowired
    private ProveedorService proveedorService;

    @Autowired
    private CountryService paisService;

    @GetMapping("/hola")
    String hola() {
        return "hola";
    }

    @GetMapping("/mantenimiento")
    String listado(Model model) {
        //Preparando datos para la vista
        model.addAttribute("lista", proveedorService.listarTodos());
        model.addAttribute("paises", paisService.listarTodos());
        model.addAttribute("proveedor", new ProveedorEntity());

        return "proveedor/mantenimiento";
    }

//    @GetMapping("/editar")
//    public String editar(@RequestParam("id") Integer id, Model model) {
    @GetMapping("/editar/{id}")
    String editar(@PathVariable Integer id, Model model) {
        model.addAttribute("paises",paisService.listarTodos());
        model.addAttribute("proveedor",proveedorService.buscarPorId(id) );

        return "proveedor/editar";
    }

    @GetMapping("/crear")
    public String crear(Model model) {
        model.addAttribute("paises",paisService.listarTodos());
        model.addAttribute("proveedor",new ProveedorEntity() );

        return "proveedor/editar";
    }


    @PostMapping("/guardar")
    String guardar(@ModelAttribute ProveedorEntity proveedor) {
        proveedorService.guardar(proveedor);

        return "redirect:/proveedor/mantenimiento";
    }

    @GetMapping("/eliminar/{id}")
    String eliminar(@PathVariable Integer id) {
        proveedorService.eliminar(id);
        return "redirect:proveedor/mantenimiento";
    }
}
*/