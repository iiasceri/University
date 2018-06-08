#include "asdc.h"

void	ft_change_str(List *lista, int i)
{
	int		tmp;
	string	stmp;

	tmp = lista[i + 1].rank;
	lista[i + 1].rank = lista[i].rank;
	lista[i].rank = tmp;
	
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
