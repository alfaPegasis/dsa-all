#include<iostream>
using namespace std;
template <class t>
class stack 
{
    t a[5],top;
    public:
    stack()
    {
        top=-1;
    }
    t isempty();
    t isfull();
    t push(t p);
    t pop();
    void display();
    };
template <class t>
t stack<t>::isempty()
{
    if(top==-1)
    return 1;
    else
    return 0;
}
template <class t>
t stack<t>::isfull()
{
    if(top==4)
    return 1;
    else
    return 0;
}
template <class t>
t stack<t>::push(t p)
{
    if(isfull())
    return 0;
    else
    {
    top++;
    a[top]=p;
    return p;
    }
}
template <class t>
t stack<t>::pop()
{  
    int temp;
    if(isempty())
    return 0;
    else
    {
    temp=a[top];
    top--;
    return temp;
    }
}
template <class t>
void stack<t>::display()
{
    cout<<"stack elements are"<<endl;
    for(int i=top;i>=0;i--)
    cout<<a[i]<<"\t";
    cout<<endl;
}
int main()
{
    stack<int> s;
    int t,m,ch;
    do{
        cout<<"1.push\n2.pop\n3.display\n4.exit"<<endl;
        cout<<"enter choice";
        cin>>ch;
        switch(ch)
        {
            case 1: cout<<"enter the element to be pushed";
                    cin>>m;
                    t=s.push(m);
                    if(t==0)
                    cout<<"STACK IS FULL"<<endl;
                    else
                    cout<<t<<"is inserted"<<endl;
                    break;
            case 2: t=s.pop();
                    if(t==0)
                    cout<<"STACK IS EMPTY"<<endl;
                    else
                    cout<<t<<"is popped out"<<endl;
                    break;
            case 3: s.display();
                    break;
            case 4: exit(0);
            default: cout<<"invalid choice"<<endl;
                
        }
    }while(ch!=0);
}
