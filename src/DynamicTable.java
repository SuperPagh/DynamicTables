import java.util.Arrays;

/**
 * Created by SuperPagh on 10-Sep-16.
 */
public class DynamicTable<E> {
    private static final int MIN_SIZE = 1;

    private int currentItems;
    private int currentSize;

    private Object elements[];

    public DynamicTable(Object... objects) {
        //Update currentSize to appropriate value according to number of objects
        if(objects.length > MIN_SIZE) {
            //If there are more objects than MIN_SIZE, find the nearest, greater power of 2.
            currentSize = (int) Math.pow(2, 32 - Integer.numberOfLeadingZeros(objects.length - 1));
        } else {
            //If there are less objects than MIN_SIZE, set currentSize to MIN_SIZE;
            currentSize = MIN_SIZE;
        }

        //Initialize internal array to currentSize.
        elements = new Object[currentSize];
        //Initialize currentItems to number of objects
        currentItems = objects.length;
    }

    public void add(Object... objects) {
        //Check if current array is big enough
        if(currentItems + objects.length > currentSize) {
            doubleArray();
        }

        //Add all elements to array
        for(int i = 0; i < objects.length; i++) {
            elements[currentItems + i] = objects[i];
            currentItems++;
        }
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
        if(newSize < MIN_SIZE) {
            return;
        } else {
            //Copy elements into new array of half the size
            elements = Arrays.copyOf(elements, newSize);

            //Update currentSize
            currentSize = newSize;
        }
    }
}