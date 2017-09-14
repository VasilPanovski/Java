package pr8_PetClinic.interfaces;

import pr8_PetClinic.models.Pet;

/**
 * Created by mm on 24.7.2016 г..
 */
public interface Clinic extends Iterable<Pet> {

    boolean add(Pet pet);
    boolean release();
    boolean hasEmptyRooms();
    String print(int room);
    String print();
}
