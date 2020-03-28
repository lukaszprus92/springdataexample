package pl.bykowski.springdataexample;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class CarService {

    private CarRepo carRepo;

    public CarService(CarRepo carRepo) {
        this.carRepo = carRepo;
    }

    @Transactional
    public void deleteCarByRegistrationNumber(String number){
        carRepo.deleteByRegistrationNumber(number);
    }
    public void changeColor(){

    }

}
