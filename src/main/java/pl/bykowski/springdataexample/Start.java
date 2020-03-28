package pl.bykowski.springdataexample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.Scanner;


@Component
public class Start {

    //twojamatka

    Scanner scanner = new Scanner(System.in);
    private UserService userService;
    private CarRepo carRepo;
    private CarService carService;

    public Start(UserService userService, CarRepo carRepo, CarService carService) {
        this.userService = userService;
        this.carRepo = carRepo;
        this.carService = carService;
    }


    @EventListener(ApplicationReadyEvent.class)
    public void runExample() {


        /*
        Wyjąłem z bazy auta bez rejestracji i im nadałem

        Car car1 = carRepo.findById(1L).get();
        car1.setRegistrationNumber("GA929CU");
        carRepo.save(car1);

        car1 = carRepo.findById(2L).get();
        car1.setRegistrationNumber("GA00000");
        carRepo.save(car1);

        car1 = carRepo.findById(3L).get();
        car1.setRegistrationNumber("GA33555");
        carRepo.save(car1);
        */

        String choose = "";
        while(1<2)
        {
            choose = mainMenu();

            if(choose.equals("1")){
                System.out.println("Podaj markę:");
                String mark = scanner.nextLine();
                System.out.println("Podaj model:");
                String model = scanner.nextLine();
                System.out.println("Wybierz kolor: RED/BLACK/BLUE/GREY");
                String color = scanner.nextLine();
                System.out.println("Podaj numer rejestracji:");
                String registrationNumber = scanner.nextLine();

                Car car = new Car(mark,model,null, registrationNumber);

                userService.changeColor(car, color);

                carRepo.save(car);
                System.out.println("Dodano samochód.");
            }
            else if(choose.equals("2")){
                Iterable<Car> all = carRepo.findAll();
                all.forEach(System.out::println);
            }
            else if(choose.equals("3")){
                System.out.println("Podaj numer rejestracji samochodu, który chcesz usunąć.");
                carService.deleteCarByRegistrationNumber(scanner.nextLine());
                System.out.println("Usunięto.");
            }
            else if(choose.equals("4")){
                System.out.println("Podaj numer rejestracji samochodu, którego kolor chcesz zmienić:");
                Car car = carRepo.findByRegistrationNumber(scanner.nextLine());
                System.out.println("Podaj nowy kolor:");
                String color = scanner.nextLine();
                userService.changeColor(car,color);
                carRepo.save(car);
            }
            else{
                System.out.println("złe polecenie");
            }

        }
        //System.exit(SpringApplication.exit(SpringApplication.run(SpringdataexampleApplication.class)));
        // działa zamknięcie ale są errory



        //carRepo.deleteById(1L);
        //nie kumam czemu 1L, a nie poprostu 1



//        System.out.println("Same BLACK:");
//
//       Iterable<Car> byColor = carRepo.findAllByColor(Color.BLACK);
//       byColor.forEach(System.out::println);
//
//        System.out.println("Same Audi:");
//
//       Iterable<Car> byMark = carRepo.findAllByMark("Audi");
//       byMark.forEach(System.out::println);


    }

    public String mainMenu(){
        System.out.println("MAIN MENU");
        System.out.println("1. Dodaj samochód");
        System.out.println("2. Wyświetl wszystkie samochody");
        System.out.println("3. Usuń samochód");
        System.out.println("4. Zmień kolor");
        return scanner.nextLine();
    }


}
