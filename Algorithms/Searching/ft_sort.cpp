#include "asdc.h"

void	ft_change_str(List *lista, int i)
{
	string stmp;

	stmp = lista[i + 1].company;
	lista[i + 1].company = lista[i].company;
	lista[i].company = stmp;

	stmp = lista[i + 1].recommendation;
	lista[i + 1].recommendation = lista[i].recommendation;
	lista[i].recommendation = stmp;

	stmp = lista[i + 1].approve;
	lista[i + 1].approve = lista[i].approve;
	lista[i].approve = stmp;

	stmp = lista[i + 1].revenue;
	lista[i + 1].revenue = lista[i].revenue;
	lista[i].revenue = stmp;

	stmp = lista[i + 1].growth;
	lista[i + 1].growth = lista[i].growth;
	lista[i].growth = stmp;
}

//Simple Bubble Sort ;)

void	ft_bubble_sort(List *lista)
{
	int 	tmp;
	int		i;
	int		j;

	for (j = 0; j < 51; j++)
		for (i = 0; i < 51; i++)
			if (lista[i].rank > lista[i+1].rank && i + 1 != 51)
			{
				tmp = lista[i + 1].rank;
				lista[i + 1].rank = lista[i].rank;
				lista[i].rank = tmp;
				ft_change_str(lista, i);
			}
}
