package com.registro.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.registro.app.domain.Libro;

@Controller
public class LibroController {

    @Autowired
    private LibroService libroService;

    @GetMapping("/")
    public String vistaPrincipal() {
        return "index";
    }

    @GetMapping("/agregar-libro")
    public String MostrarAñadirLibro(Model model) {
        model.addAttribute("libro", new Libro());
        return "add_libro";

    }

    @PostMapping("/agregar-libro")
    public String GuardarLibro(@ModelAttribute("libro") Libro libro) {
        libroService.AgregarLibro(libro);
        return "redirect:/libros";

    }

    @GetMapping("/eliminar-libro")
    public String mostrarEliminarLibro(Model model) {
        model.addAttribute("libro", new Libro());
        return "eliminar_libro";
    }

    @PostMapping("/eliminar-libro")
    public String eliminarLibro(@ModelAttribute Libro libro) {
        libroService.EliminarLibro(libro.getIsbn());
        return "redirect:/libros";
    }

    @GetMapping("/libros")
    public String ListaDeLibros(Model model) {
        model.addAttribute("libroListAttribute", libroService.ListarLibros());
        return "libros";
    }

    @GetMapping("/buscar-libro")
    public String mostrarBuscarLibros(Model model) {
        model.addAttribute("libro", new Libro());
        return "buscar_libro";
    }

    @PostMapping("/buscar-libro")
    public String buscarLibro(@RequestParam String filtro, Model model) {
        Libro libroEncontrado = libroService.BuscarLibro(filtro);
        model.addAttribute("libroEncontrado", libroEncontrado);
        model.addAttribute("filtro", filtro);
        return "resultado_buscar";
    }

    @GetMapping("/editar-libro/{isbn}")
    public String mostrarFormularioEditar(@PathVariable String isbn, Model model) {
        Libro libro = libroService.BuscarLibro(isbn);
        if (libro != null) {
            model.addAttribute("libro", libro);
            return "editar_libro";
        } else {

            return "redirect:/libros";
        }
    }

    @PostMapping("/editar-libro")
    public String editarLibro(@ModelAttribute Libro libro) {
        libroService.EditarLibro(libro);
        return "redirect:/libros";
    }

}