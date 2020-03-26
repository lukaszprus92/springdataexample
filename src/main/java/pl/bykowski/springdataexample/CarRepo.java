package pl.bykowski.springdataexample;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepo extends CrudRepository<Car, Long> {
    //nie kumam czemu w parametrach podaję Car, Long - Car to klasa, a Long to typ

}
