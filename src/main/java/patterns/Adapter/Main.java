package patterns.Adapter;

public class Main {
    public static void main(String[] args) {
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

        System.out.println("Toyota Engine: " + toyota.getHealthEngine());
        System.out.println("Audi Engine: " + audi.getHealthEngine());

        carFabric.repairEngine(toyota);
        carFabric.repairEngine(carAdapter).getAudi();
        System.out.println("Toyota Engine: " + toyota.getHealthEngine());
        System.out.println("Audi Engine: " + audi.getHealthEngine());
        carFabric.repairEngine(carAdapter).getAudi();
    }
}
