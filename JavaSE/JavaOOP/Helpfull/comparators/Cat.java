package comparators;

/**
 * Created by mm on 27.8.2016 г..
 */
public class Cat implements Comparable<Cat> {

//Интерфейсът Comparable<T>, намиращ се в пакета java.lang,
// се състои само от един метод int compareTo(T obj),
// който връща отрицателно цяло число, нула или положително цяло число съответно,
// ако текущият обект е по-малък, равен или по-голям от този, който е подаден на метода.
// Дефиницията му изглежда по приблизително следния начин:

    // - if our is less
    // + if our is bigger
    // 0 of both are equals

    private String name;
    private int age;

    private Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }

    private String getName() {
        return name;
    }

    private int getAge() {
        return age;
    }

    @Override
    public int compareTo(Cat otherCat) {
        Integer comparer = Integer.compare(this.getAge(), otherCat.getAge());

        if (comparer == 0) {
            return this.getName().compareTo(otherCat.getName());
        }

        return comparer;
    }
}
