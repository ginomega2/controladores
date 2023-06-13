package com.controla.web;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/greeting")    //*********       http://localhost:8086/greeting
public class HelloController {

    @RequestMapping(value = "/basic",method = RequestMethod.GET)   //*********       http://localhost:8086/greeting/basic
    public String sayHello(){
        return "<h1>sayHello</h1>";
    }

    @RequestMapping(value = "/proper",method = RequestMethod.GET)    //*********       http://localhost:8086/greeting/proper
    public String sayProperHello(){
        return "<h1>hola como estas tuuuuuu</h1>";
    }

    @RequestMapping("/user_entry")           //*********       http://localhost:8086/greeting/user_entry
    public String userForm(){

        //   return "<form action=\"/greeting/user_greeting\" method=\"GET\">\n" +
        //http://localhost:8086/greeting/user_greeting?firstname=krsna&lastname=emauel
        //CAMBIA POR GET Y VERAS LOS DAOTS ENVIADOS, POR POST NO SE VEN

                return "<form action=\"/greeting/user_greeting\" method=\"POST\">\n" +

                "  First name:\n" +
                "  <input type=\"text\" id=\"firstname\" name=\"firstname\" ><br>\n" +
                " Last name:\n" +
                "  <input type=\"text\" id=\"lastname\" name=\"lastname\" ><br><br>\n" +
                "  <input type=\"submit\" value=\"Submit\">\n" +
                "</form> ";
    }

    ///*******************     RECIBIR PARAMETROS DEL FORMULARIO    **************************
    @RequestMapping(value = "/user_greeting",method = RequestMethod.POST) //**********   http://localhost:8086/greeting/user_greeting    POST
//    @RequestMapping(value = "/user_greeting",method = RequestMethod.GET) //**********   http://localhost:8086/greeting/user_greeting    GET

    public String printUserGreeting(@RequestParam String firstname, @RequestParam String lastname  ){  ///  SE RECIBEN CON @RequestParam y el nombre que tiene ene l formulario
        return firstname+ "  forma fue enviada con exito  "+ lastname;
    }

    //***  /orders/1
    //***  /orders/2
    //***  /orders/etc
    // usando  @PathVariable String id obtenemos el parametro del path o ruta
    @RequestMapping(value = "/order/{id}/cliente/{name}", method = RequestMethod.GET)  //**********   http://localhost:8086/greeting/order/1/cliente/krsna    GET
    public String getOrder(@PathVariable String id,@PathVariable String name){

        return "Order No. "+id+"<br>nombre: "+name;

    }
}
