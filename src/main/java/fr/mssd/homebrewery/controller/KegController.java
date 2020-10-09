package fr.mssd.homebrewery.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import fr.mssd.homebrewery.model.Code;
import fr.mssd.homebrewery.model.Keg;
import fr.mssd.homebrewery.model.Vintage;
import fr.mssd.homebrewery.repository.KegRepository;
import fr.mssd.homebrewery.repository.KegRepository.NbKegByVintage;
import fr.mssd.homebrewery.repository.VintageRepository;

@CrossOrigin
@Controller	
@RequestMapping(path="/keg") 
public class KegController extends AbstractController<Keg, KegRepository>{
	
	@Value("${app.code}")
	private String appCode;

	@Value("${ingress.endpoint}")
	private String restGetCode;

	@Autowired 
	protected VintageRepository vintageRepository;
	
	@Autowired
	protected RestTemplate restTemplate;
	
	@PutMapping(path="/add-all/{nb}")
	public @ResponseBody List<Keg> newKegs(@PathVariable("nb") Integer nb) throws Exception {
		List<Keg> l = new ArrayList<Keg>(nb);
		for(int i = 0; i<nb; i++) {
			Code c = new Code();
			c.setAppCode(appCode);
			c = restTemplate.postForObject(restGetCode, c, Code.class);
			Keg k = repository.save(new Keg(c.getId()));
			l.add(k);
		}
		return l;
	}
	
	@GetMapping(path="/all/registered")
	public @ResponseBody Iterable<Keg> getAllRegistered() {
		return repository.findAllRegisteredKegs();
	}
	
	@GetMapping(path="/all/unregistered")
	public @ResponseBody Iterable<Keg> getAllUnregistered() {
		return repository.findAllUnregisteredKegs();
	}
	
	@GetMapping(path="/all/filled")
	public @ResponseBody Iterable<Keg> getAllFilled() {
		return repository.findAllFilledKegs();
	}
	
	@GetMapping(path="/all/empty")
	public @ResponseBody Iterable<Keg> getAllEmpty() {
		return repository.findAllRegisteredAndEmptyKegs();
	}
	
	@GetMapping(path="/{id}/empty")
	public @ResponseBody Keg empty(@PathVariable("id") Integer id) {
		Keg k = repository.findById(id).get();
		k.setVintage(null);
		return repository.save(k);
	}
	
	@GetMapping(path="/{kegId}/fill/{vintageId}")
	public @ResponseBody Keg fillByVintageId(@PathVariable("kegId") Integer kegId, @PathVariable("vintageId") Integer vintageId) {
		Keg k = repository.findById(kegId).get();
		k.setVintage(vintageRepository.findById(vintageId).get());
		return repository.save(k);
	}
	
	@GetMapping(path="/{kegId}/fill")
	public @ResponseBody Keg fill(@PathVariable("kegId") Integer kegId) {
		Keg k = repository.findById(kegId).get();
		Vintage v = vintageRepository.findUniqueVintageNotBrewed();
		k.setVintage(v);
		return repository.save(k);
	}
	
	@GetMapping(path="/nb-keg-by-vintage")
	public @ResponseBody Iterable<NbKegByVintage> getNbKegByVintage() throws Exception {
		return repository.getNbKegByVintage();
	}

}
