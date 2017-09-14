package pr3_GenericSwapMethodStrings;

import java.util.List;

public class BoxImpl<T>  implements Swapable<T> {

    public BoxImpl() {

    }

    @Override
    public void swapElements(List<T> elements, int index1, int index2) {
        T temp = elements.get(index1);

        elements.set(index1, elements.get(index2));
        elements.set(index2, temp);
    }

    public String toString(List<T> elements) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < elements.size(); i++) {
            sb.append(String.format("%s: %s%n", elements.get(i).getClass().getName(), elements.get(i)));
        }

        return sb.toString();
    }
}
