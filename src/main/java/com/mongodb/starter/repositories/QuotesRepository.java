package com.mongodb.starter.repositories;

import java.util.List;


import org.springframework.stereotype.Repository;

import com.mongodb.starter.models.Quotes;
/* 
 * author : Rajesh Thokala
 * date : 29/05/2020
 */
@Repository
public interface QuotesRepository {
    Quotes save(Quotes quotes);

    List<Quotes> saveAll(List<Quotes> quotes);

    List<Quotes> findAll();

    List<Quotes> findAll(List<String> ids);

    Quotes findOne(String id);

    long count();

    long delete(String id);

    long delete(List<String> ids);

    long deleteAll();

    Quotes update(Quotes quotes);

    long update(List<Quotes> quotess);

}
