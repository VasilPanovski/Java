package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by mm on 28.8.2016 г..
 */
public class MethodsOperation {

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<StringBuilder> sbClass = StringBuilder.class;
        Constructor ctr = sbClass.getConstructor();

        StringBuilder currentInstance = (StringBuilder) ctr.newInstance();

        // get method from class by method name and parameters
        Method append = sbClass.getDeclaredMethod("append", String.class);

        //invoke method
        append.invoke(currentInstance, "Pesho");
        System.out.println(currentInstance);
    }

}
