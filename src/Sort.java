public class Sort {
	static int[] sa;
	static int pvalue, length, fulllength;
	public static void main(String [] arg){
		sa = new int[] {10,9,5,15,1,25,35,6,9,46,3,20,400,17,12,22,19,18,7,600};
		//int [] sa = {20,19,18,17,16,15,14,13,12,11,10,9,8,7,6,5,4,3,2,1};
		//int [] sa = {10,9,8,7,6,5,4,3,2,1,20,19,18,17,16,15,14,13,12,11};
		//int [] sa = {10,20,9,19,8,18,7,17,6,16,5,15,4,14,3,13,2,12,1,11};
		
		int [] ra = Sort.bubbleSort(sa);
		for(int i=0; i< ra.length; i++){
			System.out.print(ra[i]+" ");
		}
		System.out.println("");
		ra = Sort.selectionSort(sa);
		for(int i=0; i< ra.length; i++){
			System.out.print(ra[i]+" ");
		}
		System.out.println("");
		ra = Sort.insertionSort(sa);
		for(int i=0; i< ra.length; i++){
			System.out.print(ra[i]+" ");
		}
		System.out.println("");
		
	}
	private static int[] insertionSort(int [] a) {
	int temp, j, exit;
	for(int i=0; i< a.length; i++){
		j = i; 
		exit = 0;
		while(j != 0 && exit != 1){
			if(a[j] < a[j-1]){
				temp = a[j-1];
				a[j-1] = a[j];
				a[j] = temp;
			}
			else{
				exit = 1;
			}
			j--;
		}
//		for(int k=0; k< a.length; k++){
//			System.out.print(a[k]+" ");
//		}
//		System.out.println("");
	}
	System.out.println("Sorted these numbers with insertion sort");
	return a;	
	}
	private static int[] selectionSort(int [] a) {
		int temp, small;
		for(int i=0; i< a.length; i++){
			small =i;
			for(int j=i; j< a.length; j++){
				if(a[j]<a[small]){
					small=j;
				}
			}
			temp = a[i];
			a[i] = a[small];
			a[small] = temp;
	//		for(int k=0; k< a.length; k++){
	//			System.out.print(a[k]+" ");
	//		}
	//		System.out.println("");
		}
		System.out.println("Sorted these numbers with selection sort");
		return a;	
	}
	
	private static int[] bubbleSort(int [] a) {
		int temp, save = 1;
		for(int i=0; i< a.length; i++){
			for(int j=0; j< a.length-1; j++){
				if(a[j]<a[j+1]){
					temp = a[j];
					a[j] = a[j+1];
					a[j+1] = temp;
					save = 0;
				}
			}
			if(save == 1){
				i = a.length;
			}
		}
		System.out.println("Sorted these numbers with bubble sort");
		return a;	
	}
} //closing class Sort
