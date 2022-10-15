//Name : Akashdeep-k
//Date : 15/10/2022

#include<iostream>
#include<map>
using namespace std;
class Node{
    public :
    int data;
    Node* next;
    Node(){}
    Node(int data){
        this->data = data;
        this->next = NULL;
    }
};
bool get_starting_node(Node* &head){
    if(head==NULL)
    return false;

    else{
        Node* fast = head;
        Node* slow = head;
        while(slow!=NULL && fast!=NULL){
            fast = fast->next;
            if(fast!=NULL)
            fast = fast->next;
            slow = slow->next;
            if(slow == fast){
                slow = head;
                while(slow!=fast){
                    slow = slow->next;
                    fast = fast->next;
                }
                cout<<"Loop starts at : "<<slow->data<<endl;
                return true;
            }
        }
        return false;
    }
}
int main(){
    Node* head;
    //make a linked list and call the function
    return 0;
}
