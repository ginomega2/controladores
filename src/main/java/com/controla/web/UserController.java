package com.controla.web;

import com.controla.domain.Product;
//import com.controla.entities.Product;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("/user")        ///*******   se usara  /user/{userId}/invoices
public class UserController {

    @RequestMapping("/{userId}")        //****   http://localhost:8086/user/35
    public String displayUser(@PathVariable String userId){

        return "usuario encontrado :"+userId;
    }

    @RequestMapping("/{id}/invoices")        //****   http://localhost:8086/user/35/invoices?date=12/22/2023
//    public String displayUserInvoices(@PathVariable String userId, @RequestParam Date date){    //  esta obligado a pasar el date en la ruta como un query ?
    public String displayUserInvoices(@PathVariable("id") String userId,
                                      @RequestParam(value = "date", required = true) Date dateOrNull){    //   el date es opcional en la ruta como un query ?
        // y se mantiene en la ruta con el nombre de date pero dentro del metodo usaremos otro nosmbre  dateOrNull  probar cambiar el nombre de date por fecha
        // y tambien el id po userId
        return "invoice found for user :"+userId+" on date: "+dateOrNull;
    }

    @RequestMapping("/{userId}/items")            //****   http://localhost:8086/user/35/items
    public List<String> displayStringJson(){
        return Arrays.asList("compu","telefono","escritorio");

    }

    // RETORNAMOS UNA LISTA DE PRODUCTOS
    @RequestMapping("/{userId}/productsjson")  //****   http://localhost:8086/user/35/productsjson
    public List<Product> displayProductAsJson(){

        return Arrays.asList(
                new Product(1,"jabon",11.15),
                new Product(2,"jamon",12.25),
                new Product(3,"papitas",13.35),
                new Product(4,"pan bimbo",14.45),
                new Product(5,"coca cola",15.55),
                new Product(6,"hot dogs",16.65)

                );
    }

    // RETORNAMOS UN PRODUCTO
    @RequestMapping("/{userId}/product")  //****   http://localhost:8086/user/35/product
    public Product displayProduct(){
        return  new Product(87,"compu apple",9999.11);
    }

}
