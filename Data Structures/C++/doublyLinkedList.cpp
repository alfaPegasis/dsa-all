


//include this file in your code to use its features and enjoy.

// Doubly linked list functions.

// structure.
 class node {
public:
	int data;
	node* prev;
	node* next;
	node(int val){
		data = val;
		next = NULL;
		prev = NULL;
	}
};
//display.
void display(node* &head){
	node* temp =head;

	while(temp!=NULL){
		std::cout<<temp->data<<" ";
		temp=temp->next;
	}
	std::cout<<std::endl;
}
//insertion at head
void iah(node* &head,int val){
	node* n=new node(val);
	n->next = head;
	if(head!=NULL){
		head->prev=n;
	}
	head=n;
}
//insertion at tail
void iat(node* &head,int val){
	if(head==NULL){
		iah(head,val);
		return;
	}
	node* n=new node(val);
	node* temp = head;
	while(temp->next != NULL){
		temp = temp -> next;
	}
	temp -> next = n;
	n->prev=temp;
}



//delete at head   O(1)
void dah(node* &head){
	node* todelete=head;
	head = head->next;
	head -> prev = NULL;
	delete todelete;
}

//deletion  //O(n) because node is searched first.
void deletion(node* &head,int pos){
	if(pos==1){
		dah(head);
	return ;
	}
	node* temp =head;
	int count =1;
	while(temp!=NULL && count!=pos){
		temp = temp->next;
		count++;
	}
	temp->prev->next=temp->next;
	if(temp->next!=NULL){
		temp->next->prev=temp->prev;
	}
	delete temp;
}


//search same as linked list     //O(n) where n is number of nodes in list.
bool search(node* head,int key){
	node* temp = head;
	while(temp!= NULL){
		if(temp ->data ==key){
			return true;
		}
	temp = temp->next;}
	return false;

}
