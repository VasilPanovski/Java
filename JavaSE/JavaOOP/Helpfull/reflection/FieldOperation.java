package reflection;

import java.lang.reflect.Field;

/**
 * Created by mm on 28.8.2016 г..
 */
public class FieldOperation {
    private int number;
    private String name = "Peshoslav";
    protected double x;
    public double y;
    public String allName;

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, InstantiationException {
        Class<FieldOperation> foClass = FieldOperation.class;
        Field[] publicFields = foClass.getFields(); // return all public fields
        Field[] fields = foClass.getDeclaredFields(); // return all fields
        for (Field field : fields) {
            String name = field.getName(); // number, name, x, y, allName
            String type = field.getType().getName(); // Integer, String, Double
            System.out.println(name + " " + type);
        }

        // get wanted field
        Field field = foClass.getField("number");

        // change field value... first we have to make new instance

        FieldOperation currentInstance = FieldOperation.class.newInstance();
        Field nameField = FieldOperation.class.getDeclaredField("name");
        nameField.setAccessible(true);
        String value = (String) field.get(currentInstance);
        System.out.println(value); // Peshoslav
        nameField.set(currentInstance, "Tosho");
        String newValue = (String) field.get(currentInstance);
        System.out.println(newValue); // Tosho
    }

}
