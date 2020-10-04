package fr.mssd.homebrewery.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.mssd.homebrewery.model.KegType;
import fr.mssd.homebrewery.repository.KegTypeRepository;

@CrossOrigin
@Controller	
@RequestMapping(path="/kegtype") 
public class KegTypeController extends AbstractController<KegType, KegTypeRepository>{
	

}
