import java.util.Arrays;

/**
 * Created by SuperPagh on 10-Sep-16.
 */
public class DynamicTable<E> {
    private static final int MIN_SIZE = 1;

    private int currentItems;
    private int currentSize;

    private Object elements[];

    public DynamicTable(E... es) {
        //Update currentSize to appropriate value according to number of objects
        if(es.length > MIN_SIZE) {
            //If there are more objects than MIN_SIZE, find the nearest, greater power of 2.
            currentSize = (int) Math.pow(2, 32 - Integer.numberOfLeadingZeros(es.length - 1));
        } else {
            //If there are less objects than MIN_SIZE, set currentSize to MIN_SIZE;
            currentSize = MIN_SIZE;
        }

        //Initialize internal array to currentSize.
        elements = Arrays.copyOf(es, currentSize);
        //Initialize currentItems to number of objects
        currentItems = es.length;
    }

    public void add(E... es) {
        //Check if current array is big enough
        if(currentItems + es.length > currentSize) {
            doubleArray();
        }

        //Add all elements to array
        for(int i = 0; i < es.length; i++) {
            elements[currentItems + i] = es[i];
            currentItems++;
        }
    }

    public E get(int i) {
        if(i >= currentItems || i < 0) {
            throw new IndexOutOfBoundsException("Element number " + i + " does not exist."
            + " Table only holds " + currentItems + " elements.");
        }
        return (E) elements[i];
    }

    public void deleteLast() {
        int newSize = currentItems-1;

        //If currentItems only fills 1/4 of the array, halve it.
        if(newSize <= currentSize/4) {
            halveArray();
        }
        currentItems--;
    }

    public void printElements() {
        //Print current elements of array
        for(int i = 0; i < currentItems; i++) {
            System.out.print(elements[i].toString() + " ");
        }
        System.out.println();
    }

    public void printSizes() {
        //Print actual size and size of the allocated array
        System.out.println(currentItems + " " + currentSize);
    }

    protected void doubleArray() {
        //Calculate new size
        int newSize = currentSize * 2;

        //Copy the array into new array of double size
        elements = Arrays.copyOf(elements, newSize);

        //Update currentSize
        currentSize = newSize;
    }

    protected void halveArray() {
        int newSize = currentSize / 2;
        //Keep size higher than MIN_SIZE
        if(!(newSize < MIN_SIZE)) {
            //Copy elements into new array of half the size
            elements = Arrays.copyOf(elements, newSize);

            //Update currentSize
            currentSize = newSize;
        }
    }
}