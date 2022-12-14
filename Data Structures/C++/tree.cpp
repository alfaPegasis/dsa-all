#include &lt;iostream&gt;
using namespace std;
 
//declaration for new tree node
struct node  { 
int data; 
struct node *left; 
struct node *right; 
}; 
   
//allocates new node 
struct node* newNode(int data) { 
  // declare and allocate new node  
  struct node* node = new struct node(); 
   
  node-&gt;data = data;    // Assign data to this node
   
  // Initialize left and right children as NULL 
node-&gt;left = NULL; 
node-&gt;right = NULL; 
return(node); 
} 
   
int main() { 
  /*create root node*/
struct node *rootNode = newNode(10);  
cout&lt;&lt;"General tree created is as follows:"&lt;&lt;endl;
cout&lt;&lt;"\t\t\t "&lt;&lt;rootNode-&gt;data&lt;&lt;endl;
cout&lt;&lt;"\t\t\t "&lt;&lt;"/ "&lt;&lt;"\\"&lt;&lt;endl; rootNode-&gt;left        = newNode(20); 
rootNode-&gt;right       = newNode(30); 
cout&lt;&lt;"\t\t\t"&lt;&lt;rootNode-&gt;left-&gt;data&lt;&lt;"  "&lt;&lt;rootNode-&gt;right-&gt;data;
cout&lt;&lt;endl; rootNode-&gt;left-&gt;left  = newNode(40); 
cout&lt;&lt;"\t\t\t"&lt;&lt;"/"&lt;&lt;endl;
cout&lt;&lt;"\t\t      "&lt;&lt;rootNode-&gt;left-&gt;left-&gt;data;
    
return 0; 
}
