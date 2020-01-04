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
        overview.setHandlebar(type);
        //model.addAttribute("handlebar", new Handlebar());
        return "handlebar";
    }

    public String type=null;
    @RequestMapping("/gear")
    public String schaltung(@RequestParam(name="name", required=false) String name, @RequestParam String testOrder, Model model) throws IOException {
        ProductsWeb productsWeb = new ProductsWeb();
        List<String> list = new ArrayList<String>();
        list=productsWeb.schaltung(testOrder);
        model.addAttribute("gear", list);
        model.addAttribute("testOrder", testOrder);
        overview.setGear(testOrder);
        type=testOrder;
        return "gear";
    }

    public String material=null;
    @RequestMapping("/handle")
    public String griff(@RequestParam(name="name", required=false) String name, @RequestParam String testOrder,Model model) throws IOException {
        ProductsWeb productsWeb = new ProductsWeb();
        List<String> list = new ArrayList<String>();
        list=productsWeb.griff(testOrder);
        model.addAttribute("handle", list);
        overview.setGrip(testOrder);
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
        overview.setMaterial(testOrder);
        gear=testOrder;
        return "material";
    }

    public String handle=null;
    @RequestMapping("/overview")
    public String overview(@RequestParam(name="name", required=false) String name,@RequestParam String testOrder, Model model){
        handle=testOrder;
        model.addAttribute("ha",handle);
        model.addAttribute("ge",gear);
        model.addAttribute("ty",type);
        model.addAttribute("ma",material);
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