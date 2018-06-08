#include "asdc.h"

t_list*	ft_mem()
{
	return ((t_list*)malloc(sizeof(t_list)));
}

t_list*	ft_set_dim(t_list* list, int flag)
{
	t_list*	head;

	head = list;
	while (list)
	{
		if (flag == 1)
			list->dim = list->dim + 1;
		if (flag == -1)
			list->dim = list->dim - 1;
		list = list->next;
	}
	return (head);
}

t_list*	ft_add_boundary(t_list* list, int poz)
{
	int		sw;
	t_list*	tmp;
	t_list*	head;

	if (poz == 1)
	{
		tmp = ft_mem();
		tmp->dim = list->dim;
		sw = 1;
		while (sw)
		{
			cout << "Dati valoarea pentru nod: ";
			cin >> tmp->key;
			if (tmp->key >= 0)
				sw = 0;
		}
		tmp->next = list;
		return (tmp);
	}
	else
	{
		head = list;
		for (int i = 0; i < list->dim - 3; i++)
			list = list->next;
		list->next = ft_add_boundary(list->next, 1);
		return (head);
	}
	return (NULL);
}

int		ft_get_poz(t_list* list)
{
	int	sw;
	int	poz;

	sw = 1;
	while (sw)
	{
		cout << "Dati pozitia (1-" << list->dim << ") : ";
		cin >> poz;
		if (poz < list->dim + 1 && poz > 0)
			sw = 0;
	}
	return (poz);
}

t_list*	ft_adauga_in_lista(t_list*	list)
{
	int		poz;
	t_list*	head;
	t_list*	start;

	poz = ft_get_poz(list);
	list = ft_set_dim(list, 1);
	if (poz == 1 || poz == list->dim-1)
		return (ft_add_boundary(list, poz));
	else
	{
		start = ft_mem();
		head = start;
		if (poz == 2)
		{
			start->key = list->key;
			start->dim = list->dim;
			list = ft_add_boundary(list->next, 1);
			start->next = list;
		}
		else
		{
			poz -= 2;
			while (poz--)
			{
				start->key = list->key;
				start->dim = list->dim;
				start->next = ft_mem();
				start = start->next;
				list = list->next;
			}
			start->key = list->key;
			start->dim = list->dim;
			list = ft_add_boundary(list->next, 1);
			start->next = list;
		}
	}
	return (head);
}

t_list*	ft_copiere_lista_simpla(List *clasa_lista, int dimension)
{
	t_list*	list;
	t_list*	head;

	list = ft_mem();
	head = list;
	for (int i = 0; i < dimension - 1; i++)
	{
		list->dim = dimension;
		list->key = clasa_lista[i].rank;
		list->next = ft_mem();
	 	list = list->next;
	}
	list->dim = dimension;
	list->key = clasa_lista[dimension - 1].rank;
	list->next = NULL;
	return (head);
}

void	ft_show_me_that_nice_list(t_list *tmp)
{
	int		i;

	i = 0;
	while (tmp)
	{
		cout << "Elementul Nr." << ++i;
		cout << " este = " << tmp->key << endl;
		tmp = tmp->next;
	}
	cout << "\n	Frumos nu ?" << endl;
}

void	ft_cautare_elem(t_list*	list)
{
	int	i;
	int	key;

	cout << "Cheia cautata: ";
	cin >> key;

	i = 1;
	while (list)
	{
		if (list->key == key)
		{
			cout << "Cheia a fost gasit pe pozitia: ";
			cout << i << "\nValoarea fiind: ";
			cout << list->key << "\nIar numarul de comparatii = ";
			cout << i << endl;
			return ;
		}
		i++;
		list = list->next; 
	}
	cout << "Cheia nu a fost gasita!" << endl;
}

t_list*	ft_sterge_din_lista(t_list* list)
{
	int		poz;
	t_list*	head;

	poz = ft_get_poz(list);
	list = ft_set_dim(list, -1);
	if (poz == 1)
		return (list->next);
	else
	{
		poz -= 2;
		head = list;
		while (poz--)
			list = list->next;
		list->next = list->next->next;
		return (head);
	}
	return (head);
}

void	ft_lista_simpla(List* clasa_lista)
{
	t_list*	list;
	int		sw_var;

	sw_var = 1;
	list = ft_copiere_lista_simpla(clasa_lista, 51);
	while (sw_var)
	{
		cout << "	\033[1;32m-Lista Simpla-\033[0m\n";
		cout << "	1.Afisarea listei" << endl;
		cout << "	2.Adaugare element" << endl;
		cout << "	3.Cautare element" << endl;
		cout << "	4.Stergere element" << endl;
		cout << "	5.Clear & Reset" << endl;
		cout << "	0.Iesire" << endl;
		cin >> sw_var;
		if (sw_var == 1)
			ft_show_me_that_nice_list(list);
		if (sw_var == 2)
			list = ft_adauga_in_lista(list);
		if (sw_var == 3)
			ft_cautare_elem(list);
		if (sw_var == 4)
			list = ft_sterge_din_lista(list);
		if (sw_var == 5)
		{
			cout << "\033[2J\033[1;1H";
			list = ft_copiere_lista_simpla(clasa_lista, 51);
		}
	}
}
