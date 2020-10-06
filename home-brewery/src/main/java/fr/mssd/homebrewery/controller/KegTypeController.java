package fr.mssd.homebrewery.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import fr.mssd.homebrewery.model.KegType;
import fr.mssd.homebrewery.repository.KegTypeRepository;

@CrossOrigin
@Controller
@RequestMapping(path = "/kegtype")
public class KegTypeController extends AbstractController<KegType, KegTypeRepository> {
/*
	@PostMapping("{id}/image")
	public KegType handleImagePost(@PathVariable("id") Integer id, @RequestParam("file") MultipartFile file) {
		try {
			KegType k = repository.findById(id).get();
			k.setIcon(file.getBytes());
			return repository.save(k);
		} catch (IOException e) {

		}
		return null;
	}
	
	@PostMapping("image")
	public KegType handleImagePost2(@RequestParam("kegtype") KegType k, @RequestParam("file") MultipartFile file) {
		try {
			k.setIcon(file.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return repository.save(k);
	}
	
	@GetMapping(path="/{id}/image", produces = MediaType.IMAGE_PNG_VALUE)
	public @ResponseBody byte[] getIcon(@PathVariable("id") Integer id) throws Exception {
		KegType k = repository.findById(id).get();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        out.write(k.getIcon());
        return out.toByteArray();
	}
*/
}
