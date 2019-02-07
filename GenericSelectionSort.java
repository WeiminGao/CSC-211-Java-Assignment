
package genericselectionsort;

import java.util.Arrays;
public class GenericSelectionSort<T>
{
    private T[] data;
    
    public GenericSelectionSort()
     {
        this( 10 );
     } 
    public GenericSelectionSort(int size)
    {
        int initSize = size > 0 ? size : 10; 
        T[] data = (T[])new Object[initSize];
    } 
    
    public < T extends Comparable< T > > void sort(T[] data)
    {
        for (int i = 0; i < data.length - 1; i++) {
            int smallest = i;
            for (int j = i + 1; j < data.length; j++) {
                if (data[j].compareTo(data[smallest])< 0) {
                    smallest = j;
                }
            }
            swap(data, i, smallest); 
            printPass(data, i + 1, smallest);

        }
    }
    
     private <T> void swap(T[] array, int first, int second) {
        T temp = array[first];
        array[first] = array[second];
        array[second] = temp;
        
    }
     
    public <T> void printPass(T[] array, int pass, int index ) {
        System.out.print( String.format( "after pass %2d: ", pass ) );
        for ( int i = 0; i < index; i++ )
            System.out.print( array[ i ] + " " );
        System.out.print( array[ index ] + "* " );
        for ( int i = index + 1; i < array.length; i++ )
            System.out.print( array[ i ] + " " );
        System.out.print( "\n " );
        for ( int j = 0; j < pass; j++ )
            System.out.print( "-- " );
        System.out.println( "\n" );
    }
    public String toString(){
        return Arrays.toString( data );
    }
        
}
   

