
package genericselectionsort;

import java.util.Random;
import java.util.Arrays;
public class GenericSelectionSortTest {
    public static void main( String[] args )
    {
        int size=10;
        GenericSelectionSort<Integer> sortIntArray = new GenericSelectionSort();
        GenericSelectionSort<Float> sortFloatArray = new GenericSelectionSort();
        final Random generator = new Random();
        Integer[] intArray=new Integer[size];
        Float[] floatArray=new Float[size];
        for ( int i = 0; i < size; i++ )
            intArray[i] = 10 + generator.nextInt(90);
        for ( int j = 0; j < size; j++ )
            floatArray[ j ] = generator.nextFloat() * (90.0f - 10.0f) + 10.0f;
        
        System.out.println( "Unsorted integer array:" );
        System.out.println( Arrays.toString(intArray) + "\n" );
        sortIntArray.sort(intArray);
        System.out.println( "Sorted integer array:" );
        System.out.println( Arrays.toString(intArray) + "\n" );
        
        System.out.println( "Unsorted float array:" );
        System.out.println( Arrays.toString(floatArray) + "\n" );
        sortFloatArray.sort(floatArray);
        System.out.println( "Sorted float array:" );
        System.out.println( Arrays.toString(floatArray) + "\n" );
    }
}
