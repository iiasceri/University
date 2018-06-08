#include "asdc.h"

void insertionSort(int arr[], int n)
{
   int i, key, j;
   for (i = 1; i < n; i++)
   {
	   Swapasi::pasi++;
       key = arr[i];
       j = i-1;

       while (j >= 0 && arr[j] > key)
       {
		   Swapasi::pasi++;
		   Swapasi::swapuri++;
           arr[j+1] = arr[j];
           j = j-1;
       }
       arr[j+1] = key;
   }
}
