package pr8_PetClinic.models;

import pr8_PetClinic.interfaces.Clinic;

import java.util.Arrays;
import java.util.Iterator;
import java.util.function.Consumer;

/**
 * Created by mm on 24.7.2016 г..
 */
public class ClinicImpl implements Clinic {
    private int size;
    private Pet[] rooms;
    private int middleRoom;

    public ClinicImpl(int rooms) {
        this.setSize(rooms);
        this.rooms = new Pet[rooms];
        middleRoom = rooms / 2;
    }

    public void setSize(int rooms) {
        if (rooms % 2 == 0) {
            throw new IllegalArgumentException("Invalid Operation!");
        }
        this.size = rooms;
    }


    @Override
    public Iterator<Pet> iterator() {
        return Arrays.asList(this.rooms).iterator();
    }

    @Override
    public void forEach(Consumer<? super Pet> action) {
        for (Pet pet : this.rooms) {
            action.accept(pet);
        }
    }

    @Override
    public boolean add(Pet pet) {
        int currentRoom = this.middleRoom;
        int step = 0;
        int stepsMade = 0;
        boolean stepLeft = true;

        while (this.rooms[currentRoom] != null && step <= this.rooms.length / 2) {
            if (stepLeft) {
                currentRoom = this.middleRoom - step;
            } else {
                currentRoom = this.middleRoom + step;
            }

            stepsMade++;
            stepLeft = !stepLeft;
            if (stepsMade == 2) {
                step++;
                stepsMade = 0;
            }
        }

        if (this.rooms[currentRoom] == null) {
            this.rooms[currentRoom] = pet;
            return true;
        }

        return false;
    }

    @Override
    public boolean release() {
        if (this.rooms[this.middleRoom] != null) {
            this.rooms[this.middleRoom] = null;
            return true;
        } else if(this.size > 1) {
            int currentRoom = middleRoom + 1;
            while (this.rooms[currentRoom] == null && currentRoom != middleRoom) {
                currentRoom = ++currentRoom % this.rooms.length;
            }

            if (this.rooms[currentRoom] != null) {
                this.rooms[currentRoom] = null;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean hasEmptyRooms() {
        for (Pet pet : this.rooms) {
            if (pet == null) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String print(int room) {
        if (this.rooms[room - 1] == null) {
            return "Room empty";
        } else {
            return this.rooms[room - 1].toString();
        }
    }

    @Override
    public String print() {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= this.size; i++){
            sb.append(this.print(i)).append(System.lineSeparator());
        }
        return sb.toString();
    }
}
