package tn.esprit.hexacode.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.hexacode.Entity.Reservation;
import tn.esprit.hexacode.repository.ReservationRepository;
@Service
public class ReservationServiceImp implements IReservationService{
	@Autowired
	ReservationRepository reservationRepository ;

	@Override
	public List<Reservation> RetrieveAllReservation() {
		List<Reservation> reservation =reservationRepository.findAll();	
		return reservation;
	}

	@Override
	public Reservation addReservation(Reservation r) {
		
		return reservationRepository.save(r);
	}

	@Override
	public Reservation retrieveReservation(Long id) {
		Reservation reservation = reservationRepository.findById(id).orElse(null);
		return reservation;
	}

	@Override
	public Reservation modifyReservation(Reservation r) {
		return reservationRepository.save(r);
	}

	@Override
	public void deleteReservation(Long id) {
		reservationRepository.deleteById(id);		
	}

}
