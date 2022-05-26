package com.nal.controller;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nal.model.Work;
import com.nal.service.WorkService;
@RestController
@RequestMapping("/api")
public class WorkController {
  @Autowired
  WorkService workService;
  @GetMapping("/works")
  public ResponseEntity<List<Work>> getAllWork(@RequestParam(defaultValue = "0") int page,
	      @RequestParam(defaultValue = "3") int size, @RequestParam(defaultValue = "id") String sortBy) {
    try {
      List<Work> works = new ArrayList<Work>();
      works = workService.getAllWork(page, size, sortBy);
      if (works.isEmpty()) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
      }
      return new ResponseEntity<>(works, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
  
  @PostMapping("/work")
  public ResponseEntity<Work> createWork(@RequestBody Work work) {
    try {
    	Work _work = workService.saveWork(work);
      return new ResponseEntity<>(_work, HttpStatus.CREATED);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @PutMapping("/work")
  public ResponseEntity<Work> updateWork(@RequestBody Work work) {
    Work workData = workService.updateWork(work);
    if (workData != null) {
      return new ResponseEntity<>(workData, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @DeleteMapping("/works/{id}")
  public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("id") long id) {
    try {
    	workService.deleteWork(id);
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}
