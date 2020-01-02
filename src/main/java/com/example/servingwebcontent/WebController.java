package com.example.servingwebcontent;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class WebController {

	@GetMapping("/greeting")
	public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
		model.addAttribute("name", name);
		return "handlebar";
	}

    @GetMapping("/handlebar")
    public String handlebar(@RequestParam(name="name", required=false) String name, Model model) throws IOException {
	    ProductsWeb productsWeb = new ProductsWeb();
        List<String> list = new ArrayList<String>();
        list=productsWeb.lenkertyp();
        model.addAttribute("type", list);
        //model.addAttribute("handlebar", new Handlebar());
        return "handlebar";
    }

    public String type=null;
    @RequestMapping("/schaltung")
    public String schaltung(@RequestParam(name="name", required=false) String name, @RequestParam String testOrder, Model model) throws IOException {
        ProductsWeb productsWeb = new ProductsWeb();
        List<String> list = new ArrayList<String>();
        list=productsWeb.schaltung(testOrder);
        model.addAttribute("gear", list);
        model.addAttribute("testOrder", testOrder);
        type=testOrder;
        return "schaltung";
    }

    public String material=null;
    @RequestMapping("/griff")
    public String griff(@RequestParam(name="name", required=false) String name, @RequestParam String testOrder,Model model) throws IOException {
        ProductsWeb productsWeb = new ProductsWeb();
        List<String> list = new ArrayList<String>();
        list=productsWeb.griff(testOrder);
        model.addAttribute("handle", list);
        material=testOrder;
        return "griff";
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
    public String overview(@RequestParam(name="name", required=false) String name,@RequestParam String testOrder, Model model){
        handle=testOrder;
        return "jsp/overview";
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