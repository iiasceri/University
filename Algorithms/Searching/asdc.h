#ifndef ASDC_H
# define ASDC_H
# include <iostream>
# include <fstream>
# include <cstdlib>
# include <cstdio>
# include <stdio.h>
using namespace std;

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

class	BST
{
	private:
		struct	node
		{
			int		key;
			node*	left;
			node*	right;
		};
		node*	root;
		void	AddLeafPrivate(int key, node* Ptr);
		node*	ReturnNodePrivate(int key, node* Ptr, int SearchSteps);
		void	AfisareInOrdinePrivate(node* Ptr);

	public:
		int		SearchSteps;
		int		AvgSearchSteps;
		BST();
		node*	CreateLeaf(int key);
		void	AddLeaf(int key);
		node*	ReturnNode(int key);
		void	AfisareInOrdine();
		node*	trash;
};

const int TABLE_SIZE = 128;

/*
 * HashEntry Class Declaration
 */
class HashEntry
{
	public:
		int key;
		string company;
		HashEntry(int key, string company)
		{
			this->key = key;
			this->company = company;
		}
};

class HashMap
{
	private:
		HashEntry **table;
		int pasi;
	public:
		HashMap()
		{
			pasi = 0;
			table = new HashEntry * [TABLE_SIZE];
			for (int i = 0; i< TABLE_SIZE; i++)
			{
				table[i] = NULL;
			}
		}
	int getPasi()
	{
		return pasi;
	}
		/*
		 * Hash Function
		 */
		int		HashFunc(int key)
		{
			return key % TABLE_SIZE;
		}
		/*
		 * Insert Element at a key
		 */
		void	Insert(int key, string company)
		{
			int hash = HashFunc(key);
			while (table[hash] != NULL && table[hash]->key != key)
			{
				hash = HashFunc(hash + 1);
			}
			if (table[hash] != NULL)
				delete table[hash];
			table[hash] = new HashEntry(key, company);
		}
		/*
		 * Search Element at a key
		 */
		string		Search(int key)
		{
			pasi++;
			int  hash = HashFunc(key);
			while (table[hash] != NULL && table[hash]->key != key)
			{
				hash = HashFunc(hash + 1);
			}
			if (table[hash] == NULL)
				return "-1";
			else
				return table[hash]->company;
		}


		void Remove(int key)
		{
			int hash = HashFunc(key);
			while (table[hash] != NULL)
			{
				if (table[hash]->key == key)
					break;
				hash = HashFunc(hash + 1);
			}
			if (table[hash] == NULL)
			{
				cout<<"No Element found at key "<<key<<endl;
				return;
			}
			else
			{
				delete table[hash];
			}
			cout<<"Element Deleted"<<endl;
		}
		~HashMap()
		{
			for (int i = 0; i < TABLE_SIZE; i++)
			{
				if (table[i] != NULL)
					delete table[i];
				delete[] table;
			}
		}
};

typedef	struct	s_pasi
{
	int	nr;
}				t_pasi;

void	ft_citire(List *lista);
void	ft_afisare(List *lista);
void	ft_afisare_elem(List *lista, int i);
void	ft_bubble_sort(List *lista);
int		ft_caut_bin(List *lista);
int		ft_caut_secv(List *lista);
int		fibMonaccianSearch(int arr[], int x, int n);
int		min(int x, int y);
void	swap(int* a, int* b);
int		partition (int arr[], int low, int high);
void	quickSort(int arr[], int low, int high);
void	printArray(int arr[], int n);
void	heapify(int arr[], int n, int i);
void	heapSort(int arr[], int n);
#endif
