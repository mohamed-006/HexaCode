package tn.esprit.hexacode.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lowagie.text.DocumentException;

import tn.esprit.hexacode.Entity.Offers;
import tn.esprit.hexacode.service.IOfferService;
import tn.esprit.hexacode.service.OfferPDFExporter;

@RequestMapping("/offer")
@org.springframework.web.bind.annotation.RestController
public class OfferController {
	
	@Autowired
	IOfferService iOfferService ;
	
	@PostMapping("/add-offer")
	@ResponseBody
	// http://localhost:8089/SpringMVC/offer/add-offer
	public Offers addOffer(@RequestBody Offers o ){
		return iOfferService.addOffer(o);
	}
	
	// http://localhost:8089/SpringMVC/offer/retrieve-all-offer
		@GetMapping("/retrieve-all-offer")
		@ResponseBody
		public List<Offers> RetrieveAllOffers(){
			List<Offers> offer = iOfferService.RetrieveAllOffers();
			return offer ;
		}
		
		// http://localhost:8089/SpringMVC/offer/retrieve-offer/{offer-id}
		@GetMapping("/retrieve-offer/{offer-id}")
		@ResponseBody
		public Offers retrieveOffers(@PathVariable("offer-id") long id){
			return iOfferService.retrieveOffer(id);
		}	
		
		//localhost:8089/SpringMVC/offer/modify-offer
		@PutMapping("/modify-offer")
		@ResponseBody
		public Offers modifyOffer (@RequestBody Offers o ){
			return iOfferService.modifyOffer(o);
		}
		
	
		//localhost:8089/SpringMVC/offer/delete-offer/{offer-id}
		@DeleteMapping("/delete-offer/{offer-id}")
		@ResponseBody
		void deleteEvent(@PathVariable("offer-id") long id){
			iOfferService.deleteOffer(id);
		}
		
		@GetMapping("/export/pdf")
	    public void exportToPDF(HttpServletResponse response) throws DocumentException, IOException {
	        response.setContentType("application/pdf");
	        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
	        String currentDateTime = dateFormatter.format(new Date());
	         
	        String headerKey = "Content-Disposition";
	        String headerValue = "attachment; filename=users_" + currentDateTime + ".pdf";
	        response.setHeader(headerKey, headerValue);
	         
	        List<Offers> listUsers = iOfferService.listAll();
	         
	        OfferPDFExporter exporter = new OfferPDFExporter(listUsers);
	        exporter.export(response);
	         
	    }

}
