#include "asdc.h"
 
/* structure of a stack node */
struct sNode
{
    int data;
    struct sNode *next;
};
 
/* Function to push an item to stack*/
void push(struct sNode** top_ref, int new_data);
 
/* Function to pop an item from stack*/
int pop(struct sNode** top_ref);
 
/* structure of queue having two stacks */
typedef	struct	s_queue
{
    struct sNode *stack1;
    struct sNode *stack2;
}				t_queue;
 
/* Function to enqueue an item to queue */
void enQueue(t_queue *q, int x)
{
    push(&q->stack1, x);
}
 
/* Function to dequeue an item from queue */
int deQueue(t_queue *q)
{
    int x;
    /* If both stacks are empty then error */
    if(q->stack1 == NULL && q->stack2 == NULL)
    {
        printf("Q is empty");
        getchar();
        exit(0);
    }
 
/* Move elements from satck1 to stack 2 only if
stack2 is empty */
if(q->stack2 == NULL)
{
    while(q->stack1 != NULL)
    {
        x = pop(&q->stack1);
        push(&q->stack2, x);
         
    }
}
 
x = pop(&q->stack2);
return x;
}
 
/* Function to push an item to stack*/
void push(struct sNode** top_ref, int new_data)
{
    /* allocate node */
    struct sNode* new_node =
        (struct sNode*) malloc(sizeof(struct sNode));
        if(new_node == NULL)
        {
            printf("Stack overflow \n");
            getchar();
            exit(0);
             
        }
 
/* put in the data */
new_node->data = new_data;
 
/* link the old list off the new node */
new_node->next = (*top_ref);
 
/* move the head to point to the new node */
(*top_ref) = new_node;
}
 
/* Function to pop an item from stack*/
int pop(struct sNode** top_ref)
{
    int res;
    struct sNode *top;
     
    /*If stack is empty then error */
    if(*top_ref == NULL)
    {
        printf("Stack overflow \n");
        getchar();
        exit(0);
         
    }
    else
    {
        top = *top_ref;
        res = top->data;
        *top_ref = top->next;
        free(top);
        return res;
         
    }
}

t_queue*	ft_copiere_coada(List* clasa_lista, int dimension)
{
	t_queue*	q;
	
	q = new t_queue;
	q->stack1 = NULL;
	q->stack2 = NULL;
	for (int i = 0; i < dimension; i++)
		enQueue(q, clasa_lista[i].rank);
	return q;
}

void	ft_coada(List* clasa_lista)
{
	t_queue*	coada;
	int			sw_var;

	sw_var = 1;
	coada = ft_copiere_coada(clasa_lista, 51);
	while (sw_var)
	{
		cout << "	\033[1;32m-Iata coada!-\033[0m\n";
		cout << "	1.Afisarea" << endl;
		cout << "	2.Ad" << endl;
		cout << "	3.Cautare" << endl;
		cout << "	4.Clear & Reset" << endl;
		cout << "	0.Iesire" << endl;
		cin >> sw_var;
		if (sw_var == 1)
		{
			int i = 1;
			while (coada)
				cout << "Elementul nr." << i++ << " = " << deQueue(coada) << endl;
		}
		if (sw_var == 2)
		{
			int element;
			int wise;

			wise = 0;
			while(!wise)
			{
				cout << "Ce doriti sa adaugati = ";
				cin >> element;
				if (element < 1000 && element > 0)
					wise = 1;
			}
			enQueue(coada, element);
		}
		if (sw_var == 3)
		{
			int element;
			int wise;
			int current;
			int i = 1;
			int flag;

			wise = 0;
			while(!wise)
			{
				cout << "Ce doriti sa cautati = ";
				cin >> element;
				if (element < 1000 && element > 0)
					wise = 1;
			}
			flag = 1;
			while (coada && flag)
			{
				current = deQueue(coada);
				if (current == element)
				{
					cout << "Elementul = " << current << " a fost gasit" << endl <<" Pe pozitia = " << i << endl;
					flag = 0;
				}
				i++;
			}
			if (flag == 1)
				cout << "Elementul nu a fost gasit!\n";
		}
		if (sw_var == 4)
		{
			cout << "\033[2J\033[1;1H";
		}
	}
}
