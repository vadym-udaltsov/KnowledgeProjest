package patterns.Adapter;

import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {
        var logger = Logger.getLogger("Main.class");
        var carFabric = new ToyotaFabric();
        var toyota = new Toyota();
        var audi = new Audi();

        toyota.doDamage();
        toyota.doDamage();
        audi.doDamage();

        carFabric.repairEngine(toyota);
        // carFabric.repairEngine(audi); не скомпилируется

        var carAdapter = new CarAdapter(audi);
        carFabric.repairEngine(carAdapter).getAudi();

        while (toyota.getHealthEngine() != 0) {
            toyota.doDamage();
        }
        while (audi.getHealthEngine() != 50) {
            audi.doDamage();
        }
        carAdapter = new CarAdapter(audi);

        logger.info("Toyota Engine: " + toyota.getHealthEngine());
        logger.info("Audi Engine: " + audi.getHealthEngine());

        carFabric.repairEngine(toyota);
        carFabric.repairEngine(carAdapter).getAudi();
        logger.info("Toyota Engine: " + toyota.getHealthEngine());
        logger.info("Audi Engine: " + audi.getHealthEngine());
        carFabric.repairEngine(carAdapter).getAudi();
    }
}
