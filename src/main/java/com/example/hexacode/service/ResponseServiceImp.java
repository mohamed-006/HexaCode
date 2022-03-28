package tn.esprit.hexacode.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import tn.esprit.hexacode.Entity.Response;
import tn.esprit.hexacode.Entity.utils.PagingHeaders;
import tn.esprit.hexacode.Entity.utils.PagingResponse;
import tn.esprit.hexacode.repo.ResponseRepository;
import tn.esprit.hexacode.repo.SubjectRepository;

@Service
public class ResponseServiceImp implements IResponseService{
	@Autowired
	ResponseRepository responseRepositorys ;
	
	@Autowired
	SubjectRepository subjectRepository ;

	@Override
	public List<Response> retrieveAllResponse() {
		return responseRepositorys.findAll();
	}

	@Override
	public Response addResponse(Response r) {
		r.setDate(LocalDateTime.now());
		return responseRepositorys.save(r);
	}

	@Override
	public void deleteResponseById(Long id) {
		responseRepositorys.deleteById(id);
		
	}

	@Override
	public void deleteResponse(Response r) {
		responseRepositorys.delete(r);
	}

	@Override
	public Response updateResponse(Response r) {
		return responseRepositorys.save(r);
	}

	@Override
	public Response retrieveResponseById(Long id) {
		return responseRepositorys.findById(id).get();
	}
	
	@Override
	public List<Response> findByOrderByNbLikeAsc() {
		return responseRepositorys.findByOrderByNbLikeDesc();
	}
	
	/**
     * get element using Criteria.
     *
     * @param spec    *
     * @param headers pagination data
     * @param sort    sort criteria
     * @return retrieve elements with pagination
     */
	@Override
    public PagingResponse get(Specification<Response> spec, HttpHeaders headers, Sort sort) {
        if (isRequestPaged(headers)) {
            return get(spec, buildPageRequest(headers, sort));
        } else {
            final List<Response> entities = get(spec, sort);
            return new PagingResponse((long) entities.size(), 0L, 0L, 0L, 0L, entities);
        }
    }
    
    private boolean isRequestPaged(HttpHeaders headers) {
        return headers.containsKey(PagingHeaders.PAGE_NUMBER.getName()) && headers.containsKey(PagingHeaders.PAGE_SIZE.getName());
    }

    private Pageable buildPageRequest(HttpHeaders headers, Sort sort) {
        int page = Integer.parseInt(Objects.requireNonNull(headers.get(PagingHeaders.PAGE_NUMBER.getName())).get(0));
        int size = Integer.parseInt(Objects.requireNonNull(headers.get(PagingHeaders.PAGE_SIZE.getName())).get(0));
        return PageRequest.of(page, size, sort);
    }
    
    /**
     * get elements using Criteria.
     *
     * @param spec *
     * @return elements
     */
    public List<Response> get(Specification<Response> spec, Sort sort) {
        return responseRepositorys.findAll(spec, sort);
    }
    
    /**
     * get elements using Criteria.
     *
     * @param spec     *
     * @param pageable pagination data
     * @return retrieve elements with pagination
     */
    public PagingResponse get(Specification<Response> spec, Pageable pageable) {
        Page<Response> page = responseRepositorys.findAll(spec, pageable);
        List<Response> content = page.getContent();
        return new PagingResponse(page.getTotalElements(), (long) page.getNumber(), (long) page.getNumberOfElements(), pageable.getOffset(), (long) page.getTotalPages(), content);
    }

	@Override
	public Response increLike(Long id, boolean incr) {
		// TODO Auto-generated method stub
		Response r = responseRepositorys.findById(id).get();
		if(incr)
		r.setNbLike(r.getNbLike()+1);
		else
			r.setNbLike(r.getNbLike()-1);
		return responseRepositorys.save(r);
	}
    

}
