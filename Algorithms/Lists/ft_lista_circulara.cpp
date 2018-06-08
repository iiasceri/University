#include "asdc.h"

t_c_list*	ft_mem_c()
{
	return ((t_c_list*)malloc(sizeof(t_c_list)));
}

t_c_list*	ft_set_dim_circulara(t_c_list* circular, int flag)
{
	t_c_list*	tmp;
	int			i;

	i = 0;
	tmp = circular;
	if (circular != NULL)
	{
		do
		{
			if (flag == 1)
				circular->dim = circular->dim + 1;
			if (flag == -1)
				circular->dim = circular->dim - 1;
			circular = circular->next;
		}
		while (circular != tmp);
	}
	return (tmp);
}

t_c_list*	ft_add_boundary_circulara(t_c_list* circular, int poz, int scroll)
{
	int			sw;
	t_c_list*	tmp;
	t_c_list*	copy;
	t_c_list*	head;
	t_c_list*	compare;
	t_c_list*	last_node;

	if (poz == 1)
	{
		tmp = ft_mem_c();
		tmp->dim = circular->dim;
		sw = 1;
		while (sw)
		{
			cout << "Dati valoarea pentru nod: ";
			cin >> tmp->key;
			if (tmp->key >= 0)
				sw = 0;
		}

		if (scroll)
		{
			compare = circular;
			copy = circular;
			do
			{
				last_node = copy;
				copy = copy->next;
			}
			while (copy != compare);
		}
		
		tmp->next = circular;
		
		if (scroll)
		{
			last_node->next = tmp;
			return (last_node->next);
		}
		else
			return (tmp);
	}
	else if (poz == circular->dim - 1)
	{
		head = circular;
		for (int i = 0; i < circular->dim - 3; i++)
			circular = circular->next;
		circular->next = ft_add_boundary_circulara(circular->next, 1, 0);
		return (head);
	}
	return (NULL);
}

int		ft_get_poz_circulara(t_c_list* circular)
{
	int	sw;
	int	poz;

	sw = 1;
	while (sw)
	{
		cout << "Dati pozitia (1-" << circular->dim << ") : ";
		cin >> poz;
		if (poz < circular->dim + 1 && poz > 0)
			sw = 0;
	}
	return (poz);
}

t_c_list*	ft_adauga_in_lista_circulara(t_c_list* circular, int poz, int scroll)
{
	int i;
	t_c_list*	head;
	t_c_list*	copy;
	t_c_list*	start;
	t_c_list*	compare;
	t_c_list*	last_node;

	if (!poz)
	{
		poz = ft_get_poz_circulara(circular);
		circular = ft_set_dim_circulara(circular, 1);
	}
	if (poz == 1)
		return (ft_add_boundary_circulara(circular, poz, 1));
	else if (poz == circular->dim - 1)
		return (ft_add_boundary_circulara(circular, poz, -1));
	else
	{
		start = ft_mem_c();
		head = start;
		if (poz == 2)
		{
			start->dim = circular->dim;
			start->key = circular->key;
			start->next = ft_add_boundary_circulara(circular->next, 1, 0);
			if (scroll)
			{
				copy = start;
				compare = circular;
				do
				{
					last_node = copy;
					copy = copy->next;
				}
				while (copy != compare);
				last_node->next = start;
			}
			return (head);
		}
		else
		{
			i = 0;
			poz -= 2;
			while (poz--)
			{
				start->key = circular->key;
				start->dim = circular->dim;
				start->next = ft_mem_c();
				start = start->next;
				circular = circular->next;
			}
			start->key = circular->key;
			start->dim = circular->dim;
			circular = ft_add_boundary_circulara(circular->next, 1, 0);
			start->next = circular;
			while (i++ < start->dim - 2)
				start = start->next;
			start->next = head;
			return (head);
		}
	}
	return (head);
}

t_c_list*	ft_copiere_lista_circulara(List* clasa_lista, int dimension)
{
	t_c_list*	circular;
	t_c_list*	head;

	circular = ft_mem_c();
	head = circular;
	for (int i = 0; i < dimension - 1; i++)
	{
		circular->dim = dimension;
		circular->key = clasa_lista[i].rank;
		circular->next = ft_mem_c();
	 	circular = circular->next;
	}
	circular->dim = dimension;
	circular->key = clasa_lista[dimension - 1].rank;
	circular->next = head;
	return (head);
}

void	ft_show_circled(t_c_list *tmp)
{
	int			i;
	t_c_list*	compare;

	compare = tmp;
	i = 0;
	do
	{
		if (i >= tmp->dim)
			break;
		cout << "Elementul Nr." << ++i;
		cout << " este = " << tmp->key << endl;
		tmp = tmp->next;
	}
	while (tmp != compare);
	cout << "\n	Frumos nu ?" << endl;
}

void	ft_cautare_elem_circulara(t_c_list*	circular)
{
	int	i;
	int	key;

	cout << "Cheia cautata: ";
	cin >> key;

	i = 1;
	while (circular)
	{
		if (circular->key == key)
		{
			cout << "Cheia a fost gasit pe pozitia: ";
			cout << i << "\nValoarea fiind: ";
			cout << circular->key << "\nIar numarul de comparatii = ";
			cout << i << endl;
			return ;
		}
		i++;
		circular = circular->next; 
	}
	cout << "Cheia nu a fost gasita!" << endl;
}

t_c_list*	ft_sterge_din_lista_circulara(t_c_list* circular)
{
	int			i;
	int			poz;
	t_c_list*	head;

	poz = ft_get_poz_circulara(circular);
	circular = ft_set_dim_circulara(circular, -1);
	if (poz == 1)
		return (circular->next);
	else
	{
		poz -= 2;
		head = circular;
		while (poz--)
			circular = circular->next;
		circular->next = circular->next->next;
		return (head);
	}
	return (NULL);
}

void	ft_lista_circulara(List* clasa_lista)
{
	t_c_list*	circular;
	int			sw_var;

	sw_var = 1;
	circular = ft_copiere_lista_circulara(clasa_lista, 51);
	while (sw_var)
	{
		cout << "	\033[1;32m-circulara Circulara-\033[0m\n";
		cout << "	1.Afisarea circularei" << endl;
		cout << "	2.Adaugare element" << endl;
		cout << "	3.Cautare element" << endl;
		cout << "	4.Stergere element" << endl;
		cout << "	5.Clear & Reset" << endl;
		cout << "	0.Iesire" << endl;
		cin >> sw_var;
		if (sw_var == 1)
			ft_show_circled(circular);
		if (sw_var == 2)
			circular = ft_adauga_in_lista_circulara(circular, 0, 1);
		if (sw_var == 3)
			ft_cautare_elem_circulara(circular);
		if (sw_var == 4)
			circular = ft_sterge_din_lista_circulara(circular);
		if (sw_var == 5)
		{
			cout << "\033[2J\033[1;1H";
			circular = ft_copiere_lista_circulara(clasa_lista, 51);
		}
	}
}