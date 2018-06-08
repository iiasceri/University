#include "asdc.h"

void	ft_afisare_elem(List *lista, int i)
{
		cout << "---------------" << i+1 << "---------------" << endl;
		cout << "rank: " <<lista[i].rank << endl;
		cout << "company name: " <<lista[i].company << endl;
		cout << "recommendation: " <<lista[i].recommendation << endl;
		cout << "approveness of workers: " <<lista[i].approve << endl;
		cout << "revenue: " <<lista[i].revenue << endl;
		cout << "growth of company: " <<lista[i].growth << endl;
		cout << "--------------------------------" << endl;
		cout << endl;
}

void	ft_afisare(List *lista)
{
	int		i;

	i = -1;
	while (++i < 51)
		ft_afisare_elem(lista, i);
}
