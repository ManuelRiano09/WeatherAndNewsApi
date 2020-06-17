package com.weatherandnews.accesingdatamysql;
import org.springframework.data.repository.CrudRepository;
import com.weatherandnews.entitys.Searches;

public interface SearchesRepository extends CrudRepository<Searches, Integer> {
}
