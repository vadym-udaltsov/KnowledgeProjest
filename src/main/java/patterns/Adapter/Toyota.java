package patterns.Adapter;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Toyota {

    private Integer healthEngine;
    private String carName = "Toyota";


    public Toyota() {
        this.healthEngine = 100;
    }

    public void doDamage() {
        if (getHealthEngine() <= 10) {
            healthEngine = 0;
            System.out.println("Toyota Engine is full broken");
        } else {
            healthEngine = getHealthEngine() - 10;
        }
    }
}
