import java.util.*;

public class QuickSort {
	/*Objective of the 'partition' function is to choose the first element of the parameter array as the pivot element
	 *  and put it in the sorted position while keeping its left elements smaller and right elements larger than it.
	 *  So at the end of this function, the PIVOT ELEMENT will be in its sorted position while keeping elements
	 *  smaller than it on the left and the larger elements on the right.
	 */
	public static int partition(int[] A,int l,int h){
		int pivot = A[l];
		int i=l,j=h;
		// i must be less than j otherwise we would cross them, and would disturb the elements which were already changed
		while(i<j) {
			/*We start from the element after the pivot because we want to compare other numbers with the pivot and
			 * not compare it with itself
			 */
			do {
				i++;
			}while(i<h&&A[i]<=pivot);
			/*We start from the last index while decrementing j*/
			do {
				j--;
			}while(j>l&&A[j]>pivot);
			if(i<j) {
				swap(A,i,j);//Swap elements at i and j if they are small
			}
		}
		swap(A,l,j);//Swap the pivot element with the element at index j because j is the sorted position of the pivot.
		return j;
	}
	//Swap method 
	public static void swap(int[] A,int a, int b) {
		int temp = A[a];
		A[a] = A[b];
		A[b] = temp;
	}
	//Sort method which recurses while l is less than h
	public void sort(int[] A,int l,int h) {
		if(l<h) {
			int index = partition(A,l,h);
			sort(A,l,index);
			sort(A,index+1,h);
		}
	}
	public static void printArray(int[] A) {
		for(int i=0;i<A.length;i++) {
			System.out.println(A[i]);
		}
	}

	public static void main(String[] args) {
		//Create new QuickSort object
		QuickSort qs = new QuickSort();
		//new Random class object
		Random rand = new Random();
		//Setting maximum size of array, feel free to change it
		int x = rand.nextInt(20)+5;
		int[] n = new int[x];
		for(int i=0;i<x;i++) {
			n[i] = rand.nextInt(100);
		}
		//Array before sorting
		printArray(n);
		//QuickSort algorithm
		qs.sort(n,0,n.length);
		System.out.println("- - - - - - - - - - - - - - - - -");
		//Array after sorting
		printArray(n);
	}

}
