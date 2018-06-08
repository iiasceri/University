#include "asdc.h"

void	ft_citire(List *lista)
{
	ifstream	file("base");
	int			i;

	i = 0;
	while (file >> lista[i].rank >> lista[i].company >> lista[i].recommendation
				>> lista[i].approve >> lista[i].revenue >> lista[i].growth)
		i++;
}
