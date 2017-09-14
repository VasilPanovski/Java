package softuni.server.util;


import softuni.server.routing.Controller;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class DirectoryViewer {

    public static Class[] findControllers(String initialPathStr) throws ClassNotFoundException {
        File[] classes = getClasses(initialPathStr);
        List<Class> controllers = new LinkedList<>();

        for (File file : classes) {
            String fileName = file.getAbsolutePath()
                    .split("HandMadeServer")[2]
                    .replace("\\", ".");

            Class clazz = Class.forName(fileName.substring(1, fileName.length() - 6));

            if (clazz.isAnnotationPresent(Controller.class)) {
                controllers.add(clazz);
            }
        }

        return controllers.toArray(new Class[0]);
    }

    private static File[] getClasses(String initialPathStr) {
        List<File> classFiles = new ArrayList<>();
        File directory = new File(initialPathStr);
        File[] files = directory.listFiles();

        for (File file : files) {
            if (file.isFile()) {
                if (file.getName().endsWith(".class")) {
                    classFiles.add(file);
                }
            } else if (file.isDirectory()) {
                String subDirectory = file.getAbsolutePath();
                classFiles.addAll(Arrays.asList(getClasses(subDirectory)));
            }
        }

        return (File[]) classFiles.toArray();
    }
}
