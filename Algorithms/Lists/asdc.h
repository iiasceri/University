#ifndef ASDC_H
# define ASDC_H
# include <iostream>
# include <fstream>
# include <cstdlib>
# include <cstdio>
# include <stdio.h>
# include<stdlib.h>
using namespace std;

typedef	struct	s_list
{
	int				dim;
	int				key;
	struct	s_list	*next;
}				t_list;

typedef	struct	d_list
{
	int				dim;
	int				key;
	struct	d_list	*next;
	struct	d_list	*prev;
}				t_d_list;

typedef	struct	c_list
{
	int				dim;
	int				key;
	struct	c_list	*next;
}				t_c_list;

class	List
{
	public:
		int 	rank;
		string	company;
		string	recommendation;
		string	approve;
		string	revenue;
		string	growth;
		List()
		{
			rank = 0;
			company = "-";
			recommendation = "-";
			approve = "-";
			revenue = "-";
			growth = "-";
		}
};

void	ft_citire(List* lista);
void	ft_afisare(List* lista, int dim);
void	ft_afisare_elem(List* lista, int i);
void	ft_lista_simpla(List* lista);
void	ft_lista_dubla(List* lista);
void	ft_lista_circulara(List* clasa_lista);
void	ft_stive(List* clasa_lista);
void	ft_show_stack(t_list*	stiva);
void	ft_coada(List* clasa_lista);
void	ft_show_me_that_nice_list(t_list *tmp);
void	ft_bst(List* clasa_lista);
#endif
