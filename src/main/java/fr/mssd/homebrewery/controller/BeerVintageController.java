package fr.mssd.homebrewery.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import fr.mssd.homebrewery.model.BeerVintage;
import fr.mssd.homebrewery.model.Vintage;
import fr.mssd.homebrewery.repository.BeerVintageRepository;

@CrossOrigin
@Controller	
@RequestMapping(path="/Beer-vintage") 
public class BeerVintageController extends AbstractController<BeerVintage, BeerVintageRepository>{
	
	@GetMapping(path="/all/not-brewed")
	public @ResponseBody Iterable<BeerVintage> getAllVintagesNotBrewed() {
		return repository.findAllVintagesNotBrewed();
	}

}
