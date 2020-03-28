package pl.bykowski.springdataexample;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//nie musze pisać @Repository, bo JpaRepository już tym jest
public interface CarRepo extends JpaRepository<Car, Long> {
    //nie kumam czemu w parametrach podaję Car, Long - Car to klasa, a Long to typ

    List<Car> findAllByColor(Color color);
    List<Car> findAllByMark(String mark);
    Car findByRegistrationNumber(String registrationNumber);

    //void deleteAllByRegistrationNumber(String registrationNumber);
    void deleteByRegistrationNumber(String registrationNumber);

    /*{
        Long deleteId = findByRegistrationNumber(registrationNumber).getId();
        deleteById(deleteId);
    }*/


}
