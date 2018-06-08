#include "asdc.h"

t_d_list*	ft_mem_d()
{
	return ((t_d_list*)malloc(sizeof(t_d_list)));
}

void		ft_show_double(t_d_list*	d_linked, int flag)
{
	t_d_list*	tmp;
	int			i;

	tmp = d_linked;
	for (i = 0; i < d_linked->dim - 1; i++)
		d_linked = d_linked->next;
	i++;
	//1 for forwards
	if (flag == 1)
	{
		i = 1;
		while (tmp)
		{
			cout << "Elementul Nr." << i++;
			cout << " este = " << tmp->key << endl;
			tmp = tmp->next;
		}
	}
	//-1 for backwards
	else if (flag == -1)
		while (i)
		{
			cout << "Elementul Nr." << i--;
			cout << " este = " << d_linked->key << endl;
			d_linked = d_linked->prev;
		}
	else
		cout << "Invalid flag" << endl;
	cout << "\n	Frumos nu ?" << endl;
}

t_d_list*	ft_copiere_lista_dubla(List* clasa_lista, int dimension)
{
	t_d_list*	d_linked;
	t_d_list*	head;

	d_linked = ft_mem_d();
	head = d_linked;
	for (int i = 0; i < dimension - 1; i++)
	{
		d_linked->dim = dimension;
		d_linked->key = clasa_lista[i].rank;
		d_linked->next = ft_mem_d();
		d_linked->next->prev = d_linked;
		d_linked = d_linked->next;
	}
	d_linked->dim = dimension;
	d_linked->key = clasa_lista[dimension - 1].rank;
	d_linked->next = NULL;
	return (head);
}

t_d_list*	ft_set_dim_dubla(t_d_list* list, int flag)
{
	t_d_list*	head;

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

t_d_list*	ft_add_boundary_dubla(t_d_list* list, int poz)
{
	int			sw;
	t_d_list*	tmp;
	t_d_list*	head;

	if (poz == 1)
	{
		tmp = ft_mem_d();
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
		tmp->next->prev = tmp;
		return (tmp);
	}
	else
	{
		head = list;
		for (int i = 0; i < list->dim - 3; i++)
			list = list->next;
		list->next = ft_add_boundary_dubla(list->next, 1);
		list->next->prev = list;
		return (head);
	}
	return (NULL);
}

int		ft_get_poz_dubla(t_d_list* list)
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

t_d_list*	ft_adauga_in_lista_dubla(t_d_list*	list)
{
	int			poz;
	t_d_list*	head;
	t_d_list*	start;

	poz = ft_get_poz_dubla(list);
	list = ft_set_dim_dubla(list, 1);
	if (poz == 1 || poz == list->dim-1)
		return (ft_add_boundary_dubla(list, poz));
	else
	{
		start = ft_mem_d();
		head = start;
		if (poz == 2)
		{
			start->key = list->key;
			start->dim = list->dim;
			start->prev = list->prev;
			list = ft_add_boundary_dubla(list->next, 1);
			start->next = list;
		}
		else
		{
			poz -= 2;
			while (poz--)
			{
				start->key = list->key;
				start->dim = list->dim;
				start->prev = list->prev;
				start->next = ft_mem_d();
				start = start->next;
				list = list->next;
			}
			start->key = list->key;
			start->dim = list->dim;
			start->prev = list->prev;
			list = ft_add_boundary_dubla(list->next, 1);
			start->next = list;
			start->next->prev = start;
		}
	}
	return (head);
}

void	ft_cautare_elem_dubla(t_d_list*	d_linked)
{
	int	i;
	int	key;
	int	flag;
	t_d_list*	tmp;

	tmp = d_linked;
	for (i = 0; i < d_linked->dim - 1; i++)
		d_linked = d_linked->next;
	i++;
	cout << "Cheia cautata: ";
	cin >> key;
	cout << "Cum doriti sa cautati 1 incepant cu capul -1 cu spatele\n";
	cin >> flag;
	//1 for forwards
	if (flag == 1)
	{
		i = 1;
		while (tmp)
		{
			if (tmp->key == key)
			{
				cout << "Cheia a fost gasit pe pozitia: ";
				cout << i << "\nValoarea fiind: ";
				cout << tmp->key << "\nIar numarul de comparatii = ";
				cout << i << endl;
				return ;
			}
			i++;
			tmp = tmp->next;
		}
		cout << "Cheia nu a fost gasita!" << endl;
	}
	//-1 for backwards
	else if (flag == -1)
	{
		while (i)
		{
			if (d_linked->key == key)
			{
				cout << "Cheia a fost gasit pe pozitia: ";
				cout << i << "\nValoarea fiind: " <<  d_linked->key << endl;
				return ;
			}
			i--;
			d_linked = d_linked->prev;
		}
		cout << "Cheia nu a fost gasita!" << endl;
	}
	else
		cout << "Invalid flag" << endl;
}

t_d_list*	ft_sterge_din_lista_dubla(t_d_list*	d_linked)
{
	int			poz;
	t_d_list*	head;
	t_d_list*	tmp;
	t_d_list*	save_tmp;

	poz = ft_get_poz_dubla(d_linked);
	d_linked = ft_set_dim_dubla(d_linked, -1);
	if (poz == 1)
		return (d_linked->next);
	else
	{
		poz--;
		tmp = ft_mem_d();
		head = tmp;
		while (poz--)
		{
			tmp->key = d_linked->key;
			tmp->dim = d_linked->dim;
			tmp->prev = d_linked->prev;
			tmp->next = ft_mem_d();
			save_tmp = tmp;
			tmp = tmp->next;
			d_linked = d_linked->next;
		}
		save_tmp->next = d_linked->next;
	}
	return (head);
}

void	ft_lista_dubla(List* clasa_lista)
{
	t_d_list*	d_linked;
	int			sw_var;

	sw_var = 1;
	d_linked = ft_copiere_lista_dubla(clasa_lista, 51);
	while (sw_var)
	{
		cout << "	\033[1;32m-Lista Dubla-\033[0m\n";
		cout << "	1.Afisarea listei" << endl;
		cout << "	2.Adaugare element" << endl;
		cout << "	3.Cautare element" << endl;
		cout << "	4.Stergere element" << endl;
		cout << "	5.Clear & Reset" << endl;
		cout << "	0.Iesire" << endl;
		cin >> sw_var;
		if (sw_var == 1)
		{
			int	flag;
			cout << "1 pentru afisarea normala\n";
			cout << "-1 pentru afisarea inversa\n";
			cin >> flag;
			ft_show_double(d_linked, flag);
		}
		if (sw_var == 2)
			d_linked = ft_adauga_in_lista_dubla(d_linked);
		if (sw_var == 3)
			ft_cautare_elem_dubla(d_linked);
		if (sw_var == 4)
			d_linked = ft_sterge_din_lista_dubla(d_linked);
		if (sw_var == 5)
		{
			cout << "\033[2J\033[1;1H";
			d_linked = ft_copiere_lista_dubla(clasa_lista, 51);
		}
	}
}