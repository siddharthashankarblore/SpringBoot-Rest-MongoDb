package com.mongodb.starter.controllers;

import static java.util.Arrays.asList;

import java.util.List;

import javax.management.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.jayway.jsonpath.Criteria;
import com.mongodb.starter.models.Quotes;
import com.mongodb.starter.repositories.QuotesRepository;
/* 
 * author : Rajesh Thokala
 * date : 29/05/2020
 */
@RestController
@RequestMapping("/api")
public class QuotesController {
    private final static Logger LOGGER = LoggerFactory.getLogger(QuotesController.class);
    private final QuotesRepository quotesRepository;

    public QuotesController(QuotesRepository quotesRepository) {
        this.quotesRepository = quotesRepository;
    }

    @PostMapping("quote")
    @ResponseStatus(HttpStatus.CREATED)
    public Quotes postQuotes(@RequestBody Quotes quote) {
        return quotesRepository.save(quote);
    }

    @PostMapping("quotes")
    @ResponseStatus(HttpStatus.CREATED)
    public List<Quotes> postQuotess(@RequestBody List<Quotes> Quotes) {
        return quotesRepository.saveAll(Quotes);
    }

    @GetMapping("quotes")
    public List<Quotes> getQuotess() {
        return quotesRepository.findAll();
    }

    @GetMapping("quote/{id}")
    public ResponseEntity<Quotes> getQuotes(@PathVariable String id) {
        Quotes quotes = quotesRepository.findOne(id);
        if (quotes == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return ResponseEntity.ok(quotes);
    }
    
    /** Getting list of quotes with type ***/
    @GetMapping("quotes/type/{all}")
    public List<Quotes> getQuotesByType(@PathVariable String all){ 

    	return quotesRepository.finAllByType(all);
    }

    /** Getting quote with type  ***/
    
    @GetMapping("quote/type/{findOne}")
    public List<Quotes> getQuoteByType(@PathVariable String findOne){
    	return quotesRepository.finByType(findOne);
    
    }
    
   
    /** Getting list of quotes with author  ***/
    @GetMapping("quotes/author/{all}")
    public List<Quotes> getQuotesByAuthor(@PathVariable String all){ 
    		return quotesRepository.finAllByAuthor(all);
    }

    
    /** Getting quote with author  ***/
    @GetMapping("quote/author/{findOne}")
    public List<Quotes> getQuoteByAuthor(@PathVariable String findOne){
    	return quotesRepository.finByAuthor(findOne);
    		
    }
   
    @GetMapping("quotes/{ids}")
    public List<Quotes> getQuotess(@PathVariable String ids) {
        List<String> listIds = asList(ids.split(","));
        return quotesRepository.findAll(listIds);
    }

    @GetMapping("quotes/count")
    public Long getCount() {
        return quotesRepository.count();
    }

    @DeleteMapping("quotes/{id}")
    public Long deleteQuotes(@PathVariable String id) {
        return quotesRepository.delete(id);
    }

    @DeleteMapping("quotes/{ids}")
    public Long deleteQuotess(@PathVariable String ids) {
        List<String> listIds = asList(ids.split(","));
        return quotesRepository.delete(listIds);
    }

    @DeleteMapping("quotes")
    public Long deleteQuotess() {
        return quotesRepository.deleteAll();
    }

    @PutMapping("quote")
    public Quotes putQuote(@RequestBody Quotes quote) {
        return quotesRepository.update(quote);
    }

    @PutMapping("quotes")
    public Long putQuotes(@RequestBody List<Quotes> quotes) {
        return quotesRepository.update(quotes);
    }

  
    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public final Exception handleAllExceptions(RuntimeException e) {
        LOGGER.error("Internal server error.", e);
        return e;
    }
}
