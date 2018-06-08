#include "asdc.h"

t_list* push_stiva(t_list* given, int value){
	t_list* nou = new t_list;
	nou->key = value;
	nou->next = given;
	return nou;
}
 
t_list* pop_stiva(t_list* given, int *value)
{
	t_list* t;
	if (given)
	{
		*value = given->key;
		t = given;
		given = given->next;
		delete t;
		return given;
	}
	return given;
}

void	ft_show_stack(t_list*	stiva)
{
	t_list* tmp;
	int		i;

	i = 0;
	tmp = stiva;
	while (tmp->key < 1000 && tmp->key > 0)
	{
		cout << "Elementul Nr." << ++i;
		cout << " este = " << tmp->key << endl;
		tmp = tmp->next;
	}
	cout << "\n	Frumos nu ?" << endl;
}

t_list*	ft_copiere_stiva(List* clasa_lista, int dimension)
{
	t_list*	result;
	t_list*	head;
	result = new t_list;

	for (int i = 0; i < dimension; i++)
		result = push_stiva(result, clasa_lista[i].rank);
	return (result);
}

void	ft_cautare_in_stiva(t_list*	stiva)
{
	int	cheia;
	int	i;

	cout << "Dati ce cautati: ";
	cin >> cheia;
	i = 1;
	while (stiva->key < 1000 && stiva->key > 0)
	{
		if (stiva->key == cheia)
		{
			cout << "Elementul a fost gasit!\n";
			cout << "Cheia = " << stiva->key;
			cout << "\nPozitia = " << i << endl;
		}
		i++;
		stiva = stiva->next;
	}
}

void	ft_stive(List* clasa_lista)
{
	int		sw_var;
	int		top;
	t_list*	stiva;

	sw_var = 1;
	top = 182;
	stiva = ft_copiere_stiva(clasa_lista, 51);
	while (sw_var)
	{
		cout << "	\033[1;32m-Stivulita-\033[0m\n";
		cout << "	1.Afisarea stivei" << endl;
		cout << "	2.Push" << endl;
		cout << "	3.Cautare" << endl;
		cout << "	4.Pop" << endl;
		cout << "	5.Clear & Reset" << endl;
		cout << "	0.Iesire" << endl;
		cin >> sw_var;
		if (sw_var == 1)
			ft_show_stack(stiva);
		if (sw_var == 2)
		{
			int val;
			int sw_var;

			sw_var = 1;
			while (sw_var)
			{
				cout << "Dati numaru care doriti sa il adaugati:";
				cin >> val;
				if (val > 0)
					sw_var = 0;
			}
			stiva = push_stiva(stiva, val);
			top = val;
		}
		if (sw_var == 3)
			ft_cautare_in_stiva(stiva);
		if (sw_var == 4)
			stiva = pop_stiva(stiva, &top);
		if (sw_var == 5)
		{
			cout << "\033[2J\033[1;1H";
			stiva = ft_copiere_stiva(clasa_lista, 51);
		}
	}
}
