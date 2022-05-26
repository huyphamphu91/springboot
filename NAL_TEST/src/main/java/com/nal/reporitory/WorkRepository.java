package com.nal.reporitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import com.nal.model.Work;

@Repository
public interface WorkRepository extends PagingAndSortingRepository<Work, Long>, JpaRepository<Work, Long>  {

}
