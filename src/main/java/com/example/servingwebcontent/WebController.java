package com.example.servingwebcontent;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class WebController {
    Overview overview = new Overview();




    @GetMapping("/handlebar")
    public String handlebar(@RequestParam(name="name", required=false) String name, Model model) throws IOException {
	    ProductsWeb productsWeb = new ProductsWeb();
        List<String> list = new ArrayList<String>();
        list=productsWeb.lenkertyp();
        model.addAttribute("type", list);
        return "handlebar";
    }

    public String type=null;
    @RequestMapping("/gear")
    public String gear(@RequestParam(name="name", required=false) String name, @RequestParam String testOrder, Model model) throws IOException {
        ProductsWeb productsWeb = new ProductsWeb();
        List<String> list = new ArrayList<String>();
        list=productsWeb.schaltung(testOrder);
        model.addAttribute("gear", list);
        model.addAttribute("testOrder", testOrder);
        type=testOrder;
        return "gear";
    }

    public String material=null;
    @RequestMapping("/handle")
    public String handle(@RequestParam(name="name", required=false) String name, @RequestParam String testOrder,Model model) throws IOException {
        ProductsWeb productsWeb = new ProductsWeb();
        List<String> list = new ArrayList<String>();
        list=productsWeb.griff(testOrder);
        model.addAttribute("handle", list);
        material=testOrder;
        return "handle";
    }

    public String gear=null;
    @RequestMapping("/material")
    public String material(@RequestParam(name="name", required=false) String name, @RequestParam String testOrder, Model model) throws IOException {
        ProductsWeb productsWeb = new ProductsWeb();
        List<String> list = new ArrayList<String>();
        list=productsWeb.material(type);
        model.addAttribute("material", list);
        gear=testOrder;
        return "material";
    }

    public String handle=null;
    @RequestMapping("/overview")
    public String overview(@RequestParam(name="name", required=false) String name,@RequestParam String testOrder, Model model) throws IOException {
        handle=testOrder;
        model.addAttribute("ha",handle);
        model.addAttribute("ge",gear);
        model.addAttribute("ty",type);
        model.addAttribute("ma",material);
        overview.setMaterial(material);
        overview.setHandle(handle);
        overview.setHandlebar(type);
        overview.setGear(gear);
        overview.order();
        return "overview";
    }

    @GetMapping("/createUser")
    public String createUser(Model model) {
        model.addAttribute("user", new User());
        return "createUser";
    }

    @PostMapping("/createUser")
    public String createUser(@ModelAttribute User user){
        return "userDone";
    }





}