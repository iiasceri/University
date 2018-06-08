#include "asdc.h"

BST::BST()
{
	root = NULL;
	SearchSteps = 0;
	AvgSearchSteps = 0;
}

BST::node*	BST:: CreateLeaf(int key)
{
	node* n = new node;
	n->key = key;
	n->left = NULL;
	n->right = NULL;
	return (n);
}

void	BST::AddLeaf(int key)
{
	AddLeafPrivate(key, root);
}

void	BST::AddLeafPrivate(int key, node* Ptr)
{
	if (root == NULL)
		root = CreateLeaf(key);
	else if (key < Ptr->key)
		if (Ptr->left != NULL)
			AddLeafPrivate(key, Ptr->left);
		else
			Ptr->left = CreateLeaf(key);
	else if (key > Ptr->key)
		if (Ptr->right != NULL)
			AddLeafPrivate(key, Ptr->right);
		else
			Ptr->right = CreateLeaf(key);
	else
		cout << "Cheia " << key << " deja a fost adaugata\n";
}

void	BST::AfisareInOrdinePrivate(node* Ptr)
{
	if (root != NULL)
		if (Ptr->left != NULL)
			AfisareInOrdinePrivate(Ptr->left);
		cout << Ptr->key << " ";
		if (Ptr->right != NULL)
			AfisareInOrdinePrivate(Ptr->right);
}

void	BST::AfisareInOrdine()
{
	AfisareInOrdinePrivate(root);
}

BST::node*	BST::ReturnNodePrivate(int key, node* Ptr, int SearchSteps)
{
	SearchSteps++;
	if (Ptr != NULL)
	{
		if (Ptr->key == key)
		{
			cout << "Cheia cautata a fost gasit in: ";
			cout << SearchSteps << " iteratii (nivel)\n";
			return Ptr;
		}
		else if (key < Ptr->key)
			return (ReturnNodePrivate(key, Ptr->left, SearchSteps));
		else if (key > Ptr->key)
			return (ReturnNodePrivate(key, Ptr->right, SearchSteps));
	}
	else
		return (NULL);
}

BST::node*	BST::ReturnNode(int key)
{
	return (ReturnNodePrivate(key, root, SearchSteps));
}