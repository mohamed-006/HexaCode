package tn.esprit.hexacode.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import tn.esprit.hexacode.Entity.Offers;
import tn.esprit.hexacode.repository.OfferRepository;
@Service
public class OfferServiceImp implements IOfferService{
	
	@Autowired
	OfferRepository offerRepository ;

	@Override
	public List<Offers> RetrieveAllOffers() {
		List<Offers> offer =offerRepository.findAll();
		return offer;
	}

	@Override
	public Offers addOffer(Offers o) {
		
		return offerRepository.save(o) ;
	}

	@Override
	public Offers retrieveOffer(Long id) {
		Offers offer = offerRepository.findById(id).orElse(null);
		return offer;
	}

	

	@Override
	public void deleteOffer(Long id) {
		offerRepository.deleteById(id);
		
	}

	@Override
	public Offers modifyOffer(Offers o) {
		
		return offerRepository.save(o);
	}

	@Override
	public List<Offers> listAll() {
		
		return offerRepository.findAll(Sort.by("id").ascending());
	}

}
