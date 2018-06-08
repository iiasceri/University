#include "asdc.h"

int	main()
{
	List	clasa_lista[51];
	int		sw_var;
	int		dim;

	dim = 51;
	ft_citire(clasa_lista);
	sw_var = 999;
	
	while (sw_var)
	{
		cout << "\033[1;31m-Meniul Principal-\033[0m\n";
		cout << "1.Afisarea fisierului" << endl;
		cout << "2.Lista simpla" << endl;
		cout << "3.Lista dublu inlantuita" << endl;
		cout << "4.Lista ciruclara" << endl;
		cout << "5.Stiva" << endl;
		cout << "6.Coada" << endl;
		cout << "7.Arbore binar de cautare" << endl;
		cout << "8.Clear" << endl;
		cout << "0.Iesire" << endl;
		cin >> sw_var;
			if (sw_var == 1)
			{
				ft_citire(clasa_lista);
				ft_afisare(clasa_lista, dim);
			}
			if (sw_var == 2)
				ft_lista_simpla(clasa_lista);
			if (sw_var == 3)
				ft_lista_dubla(clasa_lista);
			if (sw_var == 4)
				ft_lista_circulara(clasa_lista);
			if (sw_var == 5)
				ft_stive(clasa_lista);
			if (sw_var == 6)
				ft_coada(clasa_lista);
			if (sw_var == 7)
				ft_bst(clasa_lista);
			if (sw_var == 8)
				cout << "\033[2J\033[1;1H";
	}
	return (0);
}
