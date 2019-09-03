package br.com.helpsystem.message.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.helpsystem.message.dto.Mensagen;

@Repository
public interface MessagesRepository extends MongoRepository<Mensagen, String>{
	
	@Query("{ $and: [ { $or : [ {'de' : ?0}, {'para' : ?0} ] }, { $or : [ {'para' : ?1}, {'de' : ?1} ] } ] }")
	List<Mensagen> listaMensagem(@Param("de") String de, @Param("para") String para);
	
	//@Query("{ $group: [{ _id: '$para', 'total': { $sum : 1} }] }")
	//@Query("{aggregate([{$group : {_id:'$para', 'total':{$sum:1}}}])}")
	//List<Mensagen> listaMensagensNaoLidas();
}
