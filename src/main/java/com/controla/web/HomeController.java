package com.controla.web;

import com.controla.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

// SE USA CONTROLLER PARA MVC
@Controller
public class HomeController {
    public String msg="sin mensaje";

    @RequestMapping("/menu")           //****   http://localhost:8086/menu
    public String menu(Model model){

        User user = new User("hecho en menu",46,true,"Masculino");
        User user2 = new User();
        model.addAttribute("formData",user2);  //Agregamos un espacio de tipo User
        // para almacenar los datos en el formulario usaremos ese nombre en el formulario
        msg="mnesaje enviado desde metodo menu en   http://localhost:8086/menu ";
        model.addAttribute("msg",msg);
        return "menu";
    }

    @RequestMapping("/create") //****   http://localhost:8086/create
    public String index(Model model){//Model permite trabajar con los modelos de dominio como contenedor temporal

        User user = new User("krsna",46,true,"Masculino");
        model.addAttribute("formData",user);  //Agregamos un espacio de tipo User
                                                                // para almacenar los datos en el formulario usaremos ese nombre en el formulario
        msg="mnesaje enviado desde metodo index   http://localhost:8086/ ";
        model.addAttribute("msg",msg);

        return "index";// USARA resources/templates para los html
    }

    @RequestMapping("/pages") //****   http://localhost:8086/pages
    public String indexPages(){
        return "pages/pages";// USARA resources/templates/pages para los html
    }

    //USAR EN index y ver el desplegado ya procesado normal con la pagina result
    @RequestMapping(value = "/crea1", method = RequestMethod.POST)     //****   http://localhost:8086/crea1    POST
    public String procesarForma1(User user){

        //user ya recibe los datos capturados en le formulario asi que
        //procesamos los datos realizamos alguna operacion con ellos y prosiblemente grabar a base de datos si todo esta correcto
        user.setFullName(user.getFullName()+" datos procesados en /crea1  POST   normal sin redireccion");

        return "result";
    }

    //USAR EN index y ver el desplegado pero con redireccion de datos a otro END POINT  en este caso  /display
    @RequestMapping(value = "/create", method = RequestMethod.POST)     //****   http://localhost:8086/create    POST
    public String procesarForma(User user, RedirectAttributes attr){

        //user ya recibe los datos capturados en le formulario asi que
        //procesamos los datos realizamos alguna operacion con ellospor ejemplo
        user.setFullName(user.getFullName()+" datos procesados en  http://localhost:8086/create    POST  usando redireccion ");

        // , una vez procesados ya se que se graben o no lo agregamos como attributo paraa redireccion
        attr.addFlashAttribute("user",user);

        return "redirect:/display"; //ojo redirect no envia datos
    }

    @RequestMapping(value = "/display",method = RequestMethod.GET)
    public String displayDataForm(User user){
        return "result";
    }
}
