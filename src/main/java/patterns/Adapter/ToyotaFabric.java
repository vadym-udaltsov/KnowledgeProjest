package patterns.Adapter;

public class ToyotaFabric {

    public <T extends Toyota> T repairEngine(T car) {
        var healthEngine = car.getHealthEngine();
        if (healthEngine != 100) {
            car.setHealthEngine(100);
            System.out.println("Your " + car.getCarName() + " was repaired");
        } else {
            System.out.println("Engine is not broken");
        }
        return car;
    }
}
