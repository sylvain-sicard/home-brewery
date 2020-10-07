package fr.mssd.homebrewery.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import fr.mssd.homebrewery.model.BeerKit;
import fr.mssd.homebrewery.model.Keg;
import fr.mssd.homebrewery.repository.BeerKitRepository;

@CrossOrigin
@Controller	
@RequestMapping(path="/beerkit") 
public class BeerKitController extends AbstractController<BeerKit, BeerKitRepository>{
	
	@GetMapping(path="/all/available")
	public @ResponseBody Iterable<BeerKit> getAllAvailable() {
		return repository.findAllAvailable();
	}
	
	@GetMapping(path="/all/brewed")
	public @ResponseBody Iterable<BeerKit> getAllBrewed() {
		return repository.findAllBrewed();
	}

}
