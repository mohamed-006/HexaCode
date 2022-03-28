package tn.esprit.hexacode.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.hexacode.HexaCodeApplication;
import tn.esprit.hexacode.Entity.Response;
import tn.esprit.hexacode.Entity.utils.PagingHeaders;
import tn.esprit.hexacode.Entity.utils.PagingResponse;
import tn.esprit.hexacode.service.IResponseService;


import net.kaczmarzyk.spring.data.jpa.domain.Like;
import net.kaczmarzyk.spring.data.jpa.web.annotation.And;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.transaction.Transactional;






@RestController
@RequestMapping(value = "response")
public class ResponseController {
	@Autowired
	private IResponseService iResponseService;
	
	
	
//	localhost:8080/response/add-response
	@PostMapping(value = "/add-response")
	public Response addResponse(@RequestBody Response r) { 
		String[] words = r.getContent().split(" ");
		for(int i = 0;i< words.length;i++){
		if(HexaCodeApplication.forbiddenwords.contains(words[i].trim())){
			r.setContent(r.getContent().replace(words[i], "*****"));
		}
		}
		return iResponseService.addResponse(r);
	}
	
	

	@DeleteMapping(value = "/delete-response/{id}")
	void deleteResponseById(@PathVariable Long id) {
		Response response = iResponseService.retrieveResponseById(id);
		if(LocalDateTime.now().minusSeconds(24L).isBefore(response.getDate()))
		 iResponseService.deleteResponseById(id);
	}
	
	@DeleteMapping(value = "/delete-response")
	void deleteSubject(@RequestBody Response r) {
		 iResponseService.deleteResponse(r);
	}
	
	 @GetMapping(value ="/showall")
	 public List<Response> retrieveAllResponset() {
	    return iResponseService.retrieveAllResponse();
	  }
	 
	 @GetMapping(value ="/showres/{id}")
	 public Response retriveResponse(@PathVariable Long id) {
	    return iResponseService.retrieveResponseById(id);
	  }
	 
	 @PutMapping(value = "/update-response")
		public Response updaRayon(@RequestBody Response r) {
		 Response response = iResponseService.retrieveResponseById(r.getId());
			if(LocalDateTime.now().minusSeconds(24L).isBefore(response.getDate()))
			return iResponseService.updateResponse(r);
			return null;
		}
	 
	 @GetMapping(value ="/showallbynb")
	 public List<Response> findByOrderBynb_LikeAsc() {
	    return iResponseService.findByOrderByNbLikeAsc();
	  }
	 
	 @GetMapping(value ="/increlike/{id}")
	 public Response increLike(@PathVariable Long id) {
	    return iResponseService.increLike(id,true);
	  }
	 
	 @GetMapping(value ="/decrilike/{id}")
	 public Response decrilike(@PathVariable Long id) {
	    return iResponseService.increLike(id,false);
	  }
	 
	 @Transactional
	 @GetMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
	 @ResponseStatus(HttpStatus.OK)
	 public ResponseEntity<List<Response>> get(
	         @And({
	                 @Spec(path = "content", params = "content", spec = Like.class),
	                 @Spec(path = "nbLike", params = "nbLike", spec = Like.class),
	                 @Spec(path = "date", params = "date", spec = Like.class)
	         }) Specification<Response> spec,
	         Sort sort,
	         @RequestHeader HttpHeaders headers) {
	     final PagingResponse response = iResponseService.get(spec, headers, sort);
	     return new ResponseEntity<>(response.getElements(), returnHttpHeaders(response), HttpStatus.OK);
	 }
	 
	 public HttpHeaders returnHttpHeaders(PagingResponse response) {
	        HttpHeaders headers = new HttpHeaders();
	        headers.set(PagingHeaders.COUNT.getName(), String.valueOf(response.getCount()));
	        headers.set(PagingHeaders.PAGE_SIZE.getName(), String.valueOf(response.getPageSize()));
	        headers.set(PagingHeaders.PAGE_OFFSET.getName(), String.valueOf(response.getPageOffset()));
	        headers.set(PagingHeaders.PAGE_NUMBER.getName(), String.valueOf(response.getPageNumber()));
	        headers.set(PagingHeaders.PAGE_TOTAL.getName(), String.valueOf(response.getPageTotal()));
	        return headers;
	    }
	
}
