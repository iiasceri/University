#include "asdc.h"

//Pentru cautarea binara avem nevoie de id sortat

int		ft_caut_bin(List *lista)
{
	int		i;
	int		m;
	int		s;
	int		id;
	int		pasi;
	int		sw_var;
	int		teorie;

	cout << "Dati id-ul cautat: ";
	cin >> id;

	pasi = 1;
	i = 0;
	s = 50;
	teorie = (i + s) / 2;
	do
	{
		m = (i + s) / 2;
		if (lista[m].rank == id)
		{
			cout << "id-ul cautat a fost gasit pe pozitia: " << m + 1 << endl;
			cout << "Lungimea teoretica de cautare: " << teorie << endl;
			cout << "Lungimea practica de cautare: " << pasi << endl;
			return (m);
		}
		else if (id < lista[m].rank)
			s = m;
		else
			i = m;
		pasi++;
	}while(i < s);
	cout << "id-ul introdus nu a fost gasit!" << endl;
	return (0);
}

int		ft_caut_secv(List *lista)
{
	int		i;
	int		id;
	int		pasi;

	cout << "Dati id-ul cautat: ";
	cin >> id;

	i = 0;
	pasi = 0;
	while (i < 51)
	{
		if (lista[i].rank == id)
		{
			cout << "id-ul cautat a fost gasit pe pozitia: " << i + 1 << endl;
			cout << "Lungimea teoretica de cautare: " << 51/2 << endl;
			cout << "Lungimea practica de cautare: " << pasi+1 << endl;
			return (i);
		}
		pasi++;
		i++;
	}
	cout << "id-ul introdus nu a fost gasit!" << endl;
	return (0);
}
