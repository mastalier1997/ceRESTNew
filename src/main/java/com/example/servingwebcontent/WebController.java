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
        return "handlebar";
    }

    @GetMapping("/schaltung")
    public String schaltung(@RequestParam(name="name", required=false) String name, Model model) throws IOException {
        ProductsWeb productsWeb = new ProductsWeb();
        List<String> list = new ArrayList<String>();
        list=productsWeb.schaltung("");
        model.addAttribute("type", list);
        return "schaltung";
    }

    @GetMapping("/griff")
    public String griff(@RequestParam(name="name", required=false) String name, Model model) throws IOException {
        ProductsWeb productsWeb = new ProductsWeb();
        List<String> list = new ArrayList<String>();
        list=productsWeb.griff("");
        model.addAttribute("type", list);
        return "griff";
    }

    @GetMapping("/material")
    public String material(@RequestParam(name="name", required=false) String name, Model model) throws IOException {
        ProductsWeb productsWeb = new ProductsWeb();
        List<String> list = new ArrayList<String>();
        list=productsWeb.material("");
        model.addAttribute("type", list);
        return "material";
    }

    /*String s12 =null;
    @PostMapping("/handlebar")
    public String addNewType(@ModelAttribute("type") @Valid @RequestBody String type, Model model) {


        model.addAttribute("type", type);

        s12=type;
        System.out.println(s12+"1213645");


        return s12;


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