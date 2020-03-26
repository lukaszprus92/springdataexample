package pl.bykowski.springdataexample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import javax.persistence.Table;

@Component
@Table(name="huj")
public class Start {

    private CarRepo carRepo;

    @Autowired
    public Start(CarRepo carRepo) {
        this.carRepo = carRepo;
    }


    @EventListener(ApplicationReadyEvent.class)
    public void runExample() {

        //Car car1 = new Car("Honda", "Jazz", Color.BLUE);
        //carRepo.save(car1);

        Car car2 = new Car("Audi", "A1", Color.BLACK);
        carRepo.save(car2);

        //Car car3 = new Car("Audi", "A2", Color.RED);
        //carRepo.save(car3);

        //Car car4 = new Car("huj", "hwdp", Color.RED);
        //carRepo.save(car4);

       // Iterable<Car> all2 = carRepo.findAll();
       // all2.forEach(System.out::println);


    }


}
