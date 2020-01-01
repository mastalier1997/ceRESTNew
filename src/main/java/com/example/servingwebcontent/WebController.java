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

    String s=null;
    @RequestMapping("/schaltung")
    public String schaltung(@RequestParam(name="name", required=false) String name, @RequestParam String testOrder, Model model) throws IOException {
        ProductsWeb productsWeb = new ProductsWeb();
        List<String> list = new ArrayList<String>();
        list=productsWeb.schaltung(testOrder);
        model.addAttribute("gear", list);
        model.addAttribute("testOrder", testOrder);
        s=testOrder;
        return "schaltung";
    }

    String s1=null;
    @RequestMapping("/griff")
    public String griff(@RequestParam(name="name", required=false) String name, @RequestParam String testOrder,Model model) throws IOException {
        ProductsWeb productsWeb = new ProductsWeb();
        List<String> list = new ArrayList<String>();
        list=productsWeb.griff(testOrder);
        model.addAttribute("handle", list);
        s1=testOrder;
        return "griff";
    }

    String s2=null;
    @RequestMapping("/material")
    public String material(@RequestParam(name="name", required=false) String name, @RequestParam String testOrder, Model model) throws IOException {
        ProductsWeb productsWeb = new ProductsWeb();
        List<String> list = new ArrayList<String>();
        list=productsWeb.material(s);
        model.addAttribute("material", list);
        s2=testOrder;
        return "material";
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