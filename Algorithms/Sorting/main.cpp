#include "asdc.h"

void how_much()
{
	cout << "Comparatii: " << Swapasi::pasi << endl;
	cout << "Swapuri: " << Swapasi::swapuri << endl;
}

void colectie_de_functii(int arr[])
{
	cout << "Vectorul sortat: \n";
	printArray(arr, 51);
	cout << endl;
	how_much();
	cout << endl;
}

void recitire_array(int *arr, List *list)
{
	for (int i = 0; i < 51; i++)
		arr[i] = list[i].rank;
}

int Swapasi::pasi = 0;
int Swapasi::swapuri = 0;

int	main()
{
	List lista[51];
	int		arr[51];
	int		sw_var;
	int		poz;

	ft_citire(lista);
	recitire_array(arr, lista);
	poz = -1;
	sw_var = 1;
	
	while (sw_var)
	{
		cout << "1.  Afisarea fisierului nesortat" << endl;
		cout << "2.  Bubble Sort" << endl;
		cout << "3.  Quick Sort" << endl;
		cout << "4.  Heap Sort" << endl;
		cout << "5.  Merge Sort" << endl;
		cout << "6.  Insertion Sort" << endl;
		cout << "7.  Selection Sort" << endl;
		cout << "8.  Shell Sort" << endl;
		cout << "9.  Curatare Ecran ;)" << endl;
		cout << "10. Clear contori" << endl;
		cout << "11. Iesire" << endl;
		cin >> sw_var;
		if (sw_var < 12 && sw_var > 0)
		{
			if (sw_var == 1)
			{
				ft_citire(lista);
				ft_afisare(lista);
			}
			if (sw_var == 2)
			{
				ft_bubble_sort(lista);
				cout << "Vectorul sortat: \n";
				ft_afisare(lista);
				cout << endl;
				how_much();
				cout << endl;
			}
			if (sw_var == 3)
			{
				recitire_array(arr, lista);
				quickSort(arr, 0, 50);
				colectie_de_functii(arr);
			}
			if (sw_var == 4)
			{
				recitire_array(arr, lista);
				heapSort(arr, 51);
				colectie_de_functii(arr);
			}
			if (sw_var == 5)
			{
				recitire_array(arr, lista);
				mergeSort(arr, 0, 51 - 1);
				colectie_de_functii(arr);
			}
			if (sw_var == 6)
			{
				recitire_array(arr, lista);
				insertionSort(arr, 51);
				colectie_de_functii(arr);
			}
			if (sw_var == 7)
			{
				recitire_array(arr, lista);
				selectionSort(arr, 51);
				colectie_de_functii(arr);
			}
			if (sw_var == 8)
			{
				recitire_array(arr, lista);
				shellSort(arr, 51);
				colectie_de_functii(arr);
			}
			if (sw_var == 9)
				cout << "\033[2J\033[1;1H";
			if (sw_var == 10)
			{
				ft_citire(lista);
				Swapasi::pasi = 0;
				Swapasi::swapuri = 0;
			}
			if (sw_var == 11)
				sw_var = 0;
		}
	}
	return (0);
}
