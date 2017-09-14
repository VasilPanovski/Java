package anotations;

public class Employee<T> {

    @SuppressWarnings("unchecked")
    public T[] getEmployees() {
        T[] array = (T[]) new Object[] {"Pesho", "Sasho"};
        return array;
    }
}
