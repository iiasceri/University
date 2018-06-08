#include "asdc.h"

int	main()
{
	List lista[51];
	int		sw_var;
	int		poz;

	ft_citire(lista);
	poz = -1;
	sw_var = 1;
	while (sw_var)
	{
		cout << "1. Metoda secventiala" << endl;
		cout << "2. Metoda binara" << endl;
		cout << "3. Afisarea fisierului nesortat" << endl;
		cout << "4. Afisarea fisierului sortat (Bubble sort)" << endl;
		cout << "5. Afisarea datelor pe pozitia gasita" << endl;
		cout << "6. Arbore Binar" << endl;
		cout << "7. Hash tabel" << endl;
		cout << "8. Fibonacci search" << endl;
		cout << "9. Quick Sort" << endl;
		cout << "10. Heap Sort" << endl;
		cout << "11. Curatare Ecran ;)" << endl;
		cout << "12. Iesire" << endl;
		cin >> sw_var;
		if (sw_var < 13 && sw_var > 0)
		{
			if (sw_var == 1)
				poz = ft_caut_secv(lista);
			if (sw_var == 2)
			{
				cout << "Urmeaza ordonarea pentru metoda binara\n";
				ft_bubble_sort(lista);
				poz = ft_caut_bin(lista);
			}
			if (sw_var == 3)
			{
				ft_citire(lista);
				ft_afisare(lista);
			}
			if (sw_var == 4)
			{
				ft_bubble_sort(lista);
				ft_afisare(lista);
			}
			if (sw_var == 5)
			{
				if (poz != -1)
					ft_afisare_elem(lista, poz);
				else
					cout << "\nInca nu sa gasit pozitia cautata!\n" << endl;
			}
			if (sw_var == 6)
			{
				int key;
				BST copacelu;
				for (int i = 0; i < 51; i++)
					copacelu.AddLeaf(lista[i].rank);
				cout << "Iata copacelu nostru:\n";
				copacelu.AfisareInOrdine();
				cout << "\nCheia cautata: ";
				cin >> key;
				copacelu.ReturnNode(key);
			}
			if (sw_var == 7)
			{
				HashMap hash;
				int key, value;
				int choice;
				int iesi;

				iesi = 1;
				while (iesi)
				{
					cout<<"----------------------"<<endl;
					cout<<"Operations on Hash Table"<<endl;
					cout<<"----------------------"<<endl;
					cout<<"1.Insert all elements into the table"<<endl;
					cout<<"2.Search element from the key"<<endl;
					cout<<"3.Delete element at a key"<<endl;
					cout<<"4.Exit"<<endl;
					cout<<"Enter your choice: ";
					cin>>choice;
					switch(choice)
					{
					case 1:
					for (int i = 0; i < 51; i++)
						hash.Insert(lista[i].rank, lista[i].company);
						break;
					case 2:
						cout<<"Enter key of the element to be searched: ";
						cin>>key;
						if (hash.Search(key) == "-1")
						{
							cout<<"No element found at key "<< key << endl;
							continue;
						}
					else
					{
						cout<<"Element at key "<<key<<" : ";
						cout<<hash.Search(key)<<endl;
						int pasi = hash.getPasi();
						cout << "L-am gasit in: " << pasi << " pasi" << endl;
					}
						break;
					case 3:
						cout<<"Enter key of the element to be deleted: ";
						cin>>key;
						hash.Remove(key);
						break;
					case 4:
						iesi = 0;
						break;
					default:
					   cout<<"\nEnter correct option\n";
				   }
				}
			}
			if (sw_var == 8)
			{
				ft_bubble_sort(lista);
				int x;
				int arr[51];

				for (int i = 0; i < 51; i++)
					arr[i] = lista[i].rank;
				int n = sizeof(arr)/sizeof(arr[0]);
				cout << "Dati cheia cautata: ";
				scanf("%d", &x);
				printf("Found at index: %d\n",fibMonaccianSearch(arr, x, n)+1);
				cout << endl;
			}
			if (sw_var == 9)
			{
				int arr[51];

				for (int i = 0; i < 51; i++)
					arr[i] = lista[i].rank;
				quickSort(arr, 0, 50);
				printArray(arr, 51);
				cout << endl;
			}
			if (sw_var == 10)
			{
				int arr[51];
				for (int i = 0; i < 51; i++)
					arr[i] = lista[i].rank;
				//int n = sizeof(arr)/sizeof(arr[0]);
				heapSort(arr, 51);
				cout << "Sorted array is \n";
				printArray(arr, 51);
			}
			if (sw_var == 11)
				cout << "\033[2J\033[1;1H";
			if (sw_var == 12)
				sw_var = 0;
		}
	}
	return (0);
}
