package com.mongodb.starter.repositories;

import static com.mongodb.client.model.Filters.eq;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
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
	List<Quotes> finAllByType(String type);
	/*added to find by type **/
	 List<Quotes> finByType(String type);
		public List<Quotes> finAllByAuthor(String author);
		/*added to find by type **/
			List<Quotes> finByAuthor(String author);
	 

}
