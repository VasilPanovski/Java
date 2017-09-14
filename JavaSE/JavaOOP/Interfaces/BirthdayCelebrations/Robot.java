package pr6_BirthdayCelebrations;

import pr5_BorderControl.Detainable;

/**
 * Created by mm on 12.7.2016 г..
 */
public class Robot implements Detainable {
    private String model;
    private String id;

    public Robot(String model, String id) {
        this.model = model;
        this.id = id;
    }

    private void setModel(String model) {
        if (model == null || model.isEmpty()) {
            throw new IllegalArgumentException("Invalid robot model!");
        }
        this.model = model;
    }

    private void setId(String id) {
        if (id == null || id.isEmpty()) {
            throw new IllegalArgumentException("Invalid id!");
        }
        this.id = id;
    }

    @Override
    public void detain() {
        System.out.println(this.id);
    }
}
