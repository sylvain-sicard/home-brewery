package fr.mssd.homebrewery.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import fr.mssd.homebrewery.model.Keg;
import fr.mssd.homebrewery.model.Vintage;
import fr.mssd.homebrewery.repository.VintageRepository;

@CrossOrigin
@Controller	
@RequestMapping(path="/vintage") 
public class VintageController extends AbstractController<Vintage, VintageRepository>{
	
	@GetMapping(path="/all/not-brewed")
	public @ResponseBody Iterable<Vintage> getAllVintagesNotBrewed() {
		return repository.findAllVintagesNotBrewed();
	}

}
