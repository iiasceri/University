#include "asdc.h"

//Simple Bubble Sort ;)
void	ft_bubble_sort(List *lista)
{
	int 	tmp;
	int		i;
	int		j;

	for (j = 0; j < 51; j++)
		for (i = 0; i < 51; i++)
		{
			Swapasi::pasi++;
			if (lista[i].rank > lista[i+1].rank && i + 1 != 51)
			{
				Swapasi::swapuri++;
				ft_change_str(lista, i);
			}
		}
}
