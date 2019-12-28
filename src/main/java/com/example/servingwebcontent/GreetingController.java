package com.example.servingwebcontent;

import org.apache.commons.collections4.MultiValuedMap;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.Collection;
import java.util.Map;

@Controller
public class GreetingController {

	@GetMapping("/greeting")
	public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
		model.addAttribute("name", name);
		return "greeting";
	}

    @GetMapping("/handlebar")
    public String handlebar(@RequestParam(name="name", required=false) String name, Model model) throws IOException {
	    Products products = new Products();
        products.schaltung("Rennradlenker");
        products.material("Rennradlenker");
        products.griff("Carbon", "Rennradlenker");
        products.griff("Aluminium", "Rennradlenker");
        //test
        products.lenkertyp();
        Collection<Map.Entry<String, MultiValuedMap<String, String>>> entries1 = products.fahrradlenker.entries();

        model.addAttribute("test", entries1);
        return "greeting";
    }



}