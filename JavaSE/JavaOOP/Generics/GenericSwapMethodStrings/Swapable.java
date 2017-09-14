package pr3_GenericSwapMethodStrings;

import java.util.List;

/**
 * Created by mm on 15.7.2016 г..
 */
public interface Swapable<T> {

    void swapElements(List<T> elements, int index1, int index2 );
}
