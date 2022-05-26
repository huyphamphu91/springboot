package com.nal.service;



import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nal.reporitory.WorkRepository;
import com.nal.model.Work;

@Service
@Transactional
public class WorkService {

	@Autowired
	private WorkRepository workRepository;
	
	public List<Work> getAllWork(int page, int size, String sortBy){
		Pageable paging = PageRequest.of(page, size, Sort.by(sortBy));
		Page<Work> pageResult = workRepository.findAll(paging);
		if(pageResult.hasContent()) {
            return pageResult.getContent();
        } else {
            return new ArrayList<Work>();
        }
	}
	
	public Work saveWork(Work work) {
		return workRepository.save(work);
	}
	
	public Work updateWork(Work work) {
		Optional<Work> workInstance = (workRepository.findById(work.getId()));
		if(workInstance.isPresent()) {
			workInstance.get().setWorkName(work.getWorkName());
			workInstance.get().setStartingDate(work.getStartingDate());
			workInstance.get().setEndDate(work.getEndDate());
			workInstance.get().setStatus(work.getStatus());
			return workInstance.get();
		}
		return null;

	}
	
	public void deleteWork(Long id) {
		Optional<Work> workInstance = workRepository.findById(id);
		if(workInstance.isPresent()) {
			workRepository.delete(workInstance.get());
		}
	}
}
