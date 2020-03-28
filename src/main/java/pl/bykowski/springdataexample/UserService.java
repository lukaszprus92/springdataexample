package pl.bykowski.springdataexample;

import org.springframework.stereotype.Service;

@Service
public class UserService {


    public void changeColor(Car car, String color){
        switch(color){
            case "RED": {
                car.setColor(Color.RED);
                break;
            }
            case "BLACK": {
                car.setColor(Color.BLACK);
                break;
            }
            case "BLUE": {
                car.setColor(Color.BLUE);
                break;
            }
            case "GREY": {
                car.setColor(Color.GREY);
                break;
            }
            case "WHITE": {
                car.setColor(Color.WHITE);
                break;
            }
            default: {
                System.out.println("Kolor niedostępny, domyślnie ustawiono czarny.");
                car.setColor(Color.BLACK);
                break;
            }
        }
    }

}
