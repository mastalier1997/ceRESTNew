package com.example.servingwebcontent;

import org.apache.commons.collections4.MultiValuedMap;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@Controller
public class GreetingController {

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




}