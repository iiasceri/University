#ifndef ASDC_H
# define ASDC_H
# include <iostream>
# include <fstream>
# include <cstdlib>
# include <cstdio>
# include <stdio.h>
using namespace std;

class	Swapasi
{
public:
	static int pasi;
	static int swapuri;
};

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

void	ft_citire(List *lista);
void	ft_afisare(List *lista);
void	ft_afisare_elem(List *lista, int i);
void	ft_bubble_sort(List *lista);
int		min(int x, int y);
int		partition (int arr[], int low, int high);
void	quickSort(int arr[], int low, int high);
void	printArray(int arr[], int n);
void	heapify(int arr[], int n, int i);
void	heapSort(int arr[], int n);
void	mergeSort(int arr[], int l, int r);
void	merge(int arr[], int l, int m, int r);
void	insertionSort(int arr[], int n);
void	swap(int *xp, int *yp);
void	selectionSort(int arr[], int n);
int		shellSort(int arr[], int n);
void	ft_change_str(List *lista, int i);
#endif
