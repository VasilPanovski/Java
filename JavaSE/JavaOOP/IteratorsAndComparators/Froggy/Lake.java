package pr4_Froggy;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by mm on 19.7.2016 г..
 */
public class Lake implements Iterable {
    private int[] steps;

    public Lake(int... steps) {
        this.setSteps(steps);
    }

    public int[] getSteps() {
        return steps;
    }

    public void setSteps(int[] steps) {
        this.steps = steps;
    }


    @Override
    public Iterator iterator() {
        return new FroggIterator();
    }

    private class FroggIterator implements Iterator<Integer> {
        private int index;
        private boolean isEven;
        public FroggIterator() {
            this.index = 0;
        }

        @Override
        public boolean hasNext() {
           if (index >= steps.length && !isEven) {
               index = 1;
               isEven = true;
           }
            return index < steps.length;
        }

        @Override
        public Integer next() {
            if (hasNext()) {
                int step = steps[this.index];
                this.index += 2;
                return step;
            }

            throw new NoSuchElementException("No such index");
        }
    }
}
