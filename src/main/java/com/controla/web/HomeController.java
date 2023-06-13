package com.controla.web;

import com.controla.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

// SE USA CONTROLLER PARA MVC
@Controller
public class HomeController {

    @RequestMapping("/") //****   http://localhost:8086/
    public String index(Model model){//Model permite trabajar con los modelos de dominio como contenedor temporal

        model.addAttribute("formData",new User());  //Agregamos un espacio de tipo User
                                                                // para almacenar los datos en el formulario usaremos ese nombre en el formulario
        model.addAttribute("mensaje","mensaje mandado desde index controller");

        return "index";// USARA resources/templates para los html
    }

    @RequestMapping("/pages") //****   http://localhost:8086/pages
    public String indexPages(){
        return "pages/pages";// USARA resources/templates/pages para los html
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String procesarForma(User user){
        return "result";
    }
}
