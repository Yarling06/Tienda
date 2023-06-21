
package com.tienda.controller;

import com.tienda.service.CategoriaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/categoria")
@Slf4j
public class CategoriaController {
    
    @Autowired
     private CategoriaService categoriaService;
    
    @GetMapping("/listado")
    public String page(Model model) {
       log.info("Consumo del recuros /categoria/listado");
       var categorias = categoriaService.getCategorias(false);
       model.addAttribute("categorias", categorias);
       model.addAttribute("totalCategorias", categorias.size());
       
       return "/categoria/listado";
    }
    
}
