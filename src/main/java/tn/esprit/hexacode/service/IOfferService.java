package tn.esprit.hexacode.service;

import java.util.List;


import tn.esprit.hexacode.Entity.Offers;

public interface IOfferService {
	List<Offers> RetrieveAllOffers ();
	Offers addOffer (Offers o); 
	Offers retrieveOffer (Long id );
	Offers modifyOffer (Offers o) ;
	 void deleteOffer (Long id) ;
	 public List<Offers> listAll();

}
