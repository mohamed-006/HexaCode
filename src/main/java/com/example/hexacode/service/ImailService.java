package tn.esprit.hexacode.service;



import tn.esprit.hexacode.Entity.Reservation;

public interface ImailService {

	 public void sendSimpleMessage( String to, String subject, String text);
	  public String sendHtmlEmail( Reservation res ,long id);
}
