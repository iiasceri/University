#include "asdc.h"
  
struct node
{
    int key;
    struct node *left, *right;
};
  
// A utility function to create a new BST node
struct node *newNode(int item)
{
    struct node *temp =  (struct node *)malloc(sizeof(struct node));
    temp->key = item;
    temp->left = temp->right = NULL;
    return temp;
}
  
// A utility function to do inorder traversal of BST
void inorder(struct node* root)
{
    if (root != NULL)
    {
        inorder(root->left);
        printf("%d \n", root->key);
        inorder(root->right);
    }
}
  
/* A utility function to insert a new node with given key in BST */
struct node* insert(struct node* node, int key)
{
    /* If the tree is empty, return a new node */
    if (node == NULL) return newNode(key);
 
    /* Otherwise, recur down the tree */
    if (key < node->key)
        node->left  = insert(node->left, key);
    else if (key > node->key)
        node->right = insert(node->right, key);   
 
    /* return the (unchanged) node pointer */
    return node;
}

struct node*	ft_copiere_bst(List* clasa_lista, int dimension)
{
	int 			i;
	struct node*	root;

	i = 0;
	root = NULL;
	root = insert(root, clasa_lista[i].rank);
	for (i = 1; i < dimension; i++)
		insert(root, clasa_lista[i].rank);
	return root;
}

struct node * minValueNode(struct node* node)
{
    struct node* current = node;
 
    /* loop down to find the leftmost leaf */
    while (current->left != NULL)
        current = current->left;
 
    return current;
}

struct node* deleteNode(struct node* root, int key)
{
    // base case
    if (root == NULL) return root;
 
    // If the key to be deleted is smaller than the root's key,
    // then it lies in left subtree
    if (key < root->key)
        root->left = deleteNode(root->left, key);
 
    // If the key to be deleted is greater than the root's key,
    // then it lies in right subtree
    else if (key > root->key)
        root->right = deleteNode(root->right, key);
 
    // if key is same as root's key, then This is the node
    // to be deleted
    else
    {
        // node with only one child or no child
        if (root->left == NULL)
        {
            struct node *temp = root->right;
            free(root);
            return temp;
        }
        else if (root->right == NULL)
        {
            struct node *temp = root->left;
            free(root);
            return temp;
        }
 
        // node with two children: Get the inorder successor (smallest
        // in the right subtree)
        struct node* temp = minValueNode(root->right);
 
        // Copy the inorder successor's content to this node
        root->key = temp->key;
 
        // Delete the inorder successor
        root->right = deleteNode(root->right, temp->key);
    }
    return root;
}

void	ft_cautare_bst(struct node* bst, int element)
{
	int flag;
	int i;

	i = 1;
	flag = 1;
	while (bst)
	{
		if (bst->key == element)
		{
			cout << "Elementul " << bst->key;
			cout << " A fost gasit pe nivelul " << i;
			cout << endl;
			flag = 0;
			break;
		}
		if (element > bst->key)
			bst = bst->right;
		if (element < bst->key)
			bst = bst->left;
		i++;
	}
	if (flag)
		cout << "Nope";
}

void printPostorder(struct node* node)
{
     if (node == NULL)
        return;
 
     // first recur on left subtree
     printPostorder(node->left);
 
     // then recur on right subtree
     printPostorder(node->right);
 
     // now deal with the node
     printf("%d\n", node->key);
}

void printPreorder(struct node* node)
{
     if (node == NULL)
          return;
 
     /* first print data of node */
     printf("%d\n", node->key);  
 
     /* then recur on left sutree */
     printPreorder(node->left);  
 
     /* now recur on right subtree */
     printPreorder(node->right);
}

void	ft_bst(List* clasa_lista)
{
	struct node*	bst;
	int				sw_var;

	sw_var = 1;
	bst = ft_copiere_bst(clasa_lista, 51);
	while (sw_var)
	{
		cout << "	\033[1;32m-Meniul Arborelui!-\034[0m\n";
		cout << "	1.Afisarea in ordine" << endl;
		cout << "	2.Adaugare element" << endl;
		cout << "	3.Cautare element" << endl;
		cout << "	4.Stergere element" << endl;
		cout << "	5.Afisare preordine" << endl;
		cout << "	6.Afisare postordine" << endl;
		cout << "	7.Clear & Reset" << endl;
		cout << "	0.Iesire" << endl;
		cin >> sw_var;
		if (sw_var == 1)
			inorder(bst);
		if (sw_var == 2)
		{
			int wise;
			int element;

			wise = 0;
			while (!wise)
			{
				cout << "Ce vreti sa adaugati? = ";
				cin >> element;
				if (element < 1000 && element > 0)
					wise = 1;
			}
			insert(bst, element);
		}
		if (sw_var == 3)
		{
			int wise;
			int element;

			wise = 0;
			while (!wise)
			{
				cout << "Ce vreti sa cautati? = ";
				cin >> element;
				if (element < 1000 && element > 0)
					wise = 1;
			}
			ft_cautare_bst(bst, element);
		}
		if (sw_var == 4)
		{
			int wise;
			int element;

			wise = 0;
			while (!wise)
			{
				cout << "Ce vreti sa stergeti? = ";
				cin >> element;
				if (element < 1000 && element > 0)
					wise = 1;
			}
			deleteNode(bst, element);
		}
		if (sw_var == 5)
		{
			printPreorder(bst);
			cout << endl;
		}
		if (sw_var == 6)
		{
			printPostorder(bst);
			cout << endl;
		}
		if (sw_var == 7)
		{
			bst = ft_copiere_bst(clasa_lista, 51);
			cout << "\033[2J\033[1;1H";
		}
	}
}
