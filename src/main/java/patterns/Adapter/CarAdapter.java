package patterns.Adapter;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CarAdapter extends Toyota {
    private Audi audi;
    private Integer healthEngine;
    private String carName;
    private static CarAdapter instance;

    public CarAdapter(Audi audi) {
        this.audi = audi;
        healthEngine = this.audi.getHealthEngine();
    }

    public void getAudi() {
        audi.setHealthEngine(healthEngine);
    }
    public String getCarName() {
        carName = audi.getCarName();
        return carName;
    }

    public void doDamage() {
        if (getHealthEngine() < 10) {
            healthEngine = 0;
            System.out.println("Toyota Engine is full broken");
        } else {
            healthEngine = getHealthEngine() - 10;
        }
    }

}
