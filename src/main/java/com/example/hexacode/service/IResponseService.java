package tn.esprit.hexacode.service;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpHeaders;

import tn.esprit.hexacode.Entity.Response;
import tn.esprit.hexacode.Entity.utils.PagingResponse;;

public interface IResponseService {
	List<Response> retrieveAllResponse();
	Response addResponse(Response r);
	void deleteResponseById(Long id);
	void deleteResponse(Response r);
	Response updateResponse(Response r);
	Response retrieveResponseById(Long id);
	PagingResponse get(Specification<Response> spec, HttpHeaders headers, Sort sort);
	List<Response> findByOrderByNbLikeAsc();
	Response increLike(Long id, boolean b);

}
