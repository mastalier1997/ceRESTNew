package com.example.servingwebcontent;

import org.apache.commons.collections4.MultiValuedMap;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

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

    @RequestMapping("/schaltung")
    public String schaltung(@RequestParam(name="name", required=false) String name, @RequestParam String testOrder, Model model) throws IOException {
        ProductsWeb productsWeb = new ProductsWeb();
        List<String> list = new ArrayList<String>();
        list=productsWeb.schaltung("");
        model.addAttribute("gear", list);
        model.addAttribute("testOrder", testOrder);
        return "schaltung";
    }

    @GetMapping("/griff")
    public String griff(@RequestParam(name="name", required=false) String name, Model model) throws IOException {
        ProductsWeb productsWeb = new ProductsWeb();
        List<String> list = new ArrayList<String>();
        list=productsWeb.griff("");
        model.addAttribute("handle", list);
        return "griff";
    }

    @GetMapping("/material")
    public String material(@RequestParam(name="name", required=false) String name, Model model) throws IOException {
        ProductsWeb productsWeb = new ProductsWeb();
        List<String> list = new ArrayList<String>();
        list=productsWeb.material("");
        model.addAttribute("material", list);
        return "material";
    }

    /*String s12 =null;
    @PostMapping("/handlebar")
    public String addNewType(@ModelAttribute("handlebar") Handlebar handlebar) {

       return "";


    }*/

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