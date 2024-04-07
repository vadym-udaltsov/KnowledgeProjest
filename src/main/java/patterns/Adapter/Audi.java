package patterns.Adapter;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Audi {

    private Integer healthEngine;
    private String carName = "Audi";

    public Audi() {
        this.healthEngine = 100;
    }

    public void doDamage() {
        if (getHealthEngine() <= 10) {
            healthEngine = 0;
            System.out.println("Audi Engine is full broken");
        } else {
            healthEngine = getHealthEngine() - 10;
        }

    }
}
