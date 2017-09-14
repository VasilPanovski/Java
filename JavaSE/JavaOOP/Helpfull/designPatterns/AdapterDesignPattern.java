package designPatterns;


interface Refillable {

    void fillPetrol(int amount);
    void fillDiesel(int amount);
    void fillLpg(int amount);
}

interface GasStation {

    void fill(String fuelType, int amount);
}

class PetrolCar implements Refillable {

    @Override
    public void fillPetrol(int amount) {
        System.out.println(amount + " litters field");
    }

    @Override
    public void fillDiesel(int amount) {
        //do nothing
    }

    @Override
    public void fillLpg(int amount) {
        //do nothing
    }
}

class DieselCar implements Refillable {

    @Override
    public void fillPetrol(int amount) {
        // do nothing
    }

    @Override
    public void fillDiesel(int amount) {
        System.out.println(amount + " litters field");
    }

    @Override
    public void fillLpg(int amount) {
        //do nothing
    }
}

class LpgCar implements Refillable {

    @Override
    public void fillPetrol(int amount) {
        //do nothing
    }

    @Override
    public void fillDiesel(int amount) {
        //do nothing
    }

    @Override
    public void fillLpg(int amount) {
        System.out.println(amount + " litters field");
    }
}

class AdapterGasStation implements GasStation {

    Refillable vehicle;

    public AdapterGasStation(String fuelType) {
        if (fuelType.equalsIgnoreCase("petrol")) {
            this.vehicle = new PetrolCar();
        } else if (fuelType.equalsIgnoreCase("diesel")) {
            this.vehicle = new DieselCar();
        } else {
            this.vehicle = new LpgCar();
        }
    }

    @Override
    public void fill(String fuelType, int amount) {
        if (fuelType.equalsIgnoreCase("petrol")) {
            this.vehicle.fillPetrol(amount);
        } else if (fuelType.equalsIgnoreCase("diesel")) {
            this.vehicle.fillDiesel(amount);
        } else {
            this.vehicle.fillLpg(amount);
        }

    }
}


class CityGasStation implements GasStation {

    // this pattern is old and is not so good as implementation.
    // The purpose of it is to make old code working with the new one

    GasStation gasStation;

    @Override
    public void fill(String fuelType, int amount) {

        if (fuelType.equalsIgnoreCase("water")) {
            System.out.println(amount + " litters filled");
        } else if (fuelType.equalsIgnoreCase("petrol") ||
                fuelType.equalsIgnoreCase("diesel") ||
                fuelType.equalsIgnoreCase("lpg")) {
            this.gasStation = new AdapterGasStation(fuelType);
            this.gasStation.fill(fuelType, amount);
        } else {
            System.out.println("This fuel is not supported!");
        }
    }
}
public class AdapterDesignPattern {

    public static void main(String[] args) {
        GasStation gasStation = new CityGasStation();
        gasStation.fill("petrol", 100);
    }
}
