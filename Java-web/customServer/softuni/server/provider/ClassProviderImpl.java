package softuni.server.provider;

import softuni.server.util.DirectoryViewer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ClassProviderImpl implements ClassProvider {

    private Class[] classes;
    private Map<Class, Class[]> classesByAnnotation;

    public ClassProviderImpl() throws ClassNotFoundException {
        this.classes = DirectoryViewer
                .findControllers(System.getProperty("user.dir") + "/out/production/HandMadeServer/softuni/app/");
        this.classesByAnnotation = new HashMap<>();
    }

    @Override
    public Class[] getClassByAnnotation(Class annotation) {
        if (this.classesByAnnotation.containsKey(annotation)) {
            return this.classesByAnnotation.get(annotation);
        }

        Class[] result = Arrays.stream(classes)
                .filter(c -> c.isAnnotationPresent(annotation))
                .toArray(Class[]::new);

        this.classesByAnnotation.put(annotation, result);

        return result;
    }
}
