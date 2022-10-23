
#include <bits/stdc++.h>
using namespace std;

//to add an edge in graph
void AddEdgee(vector<int> adj[], int u, int v)
{
	adj[u].push_back(v);
	adj[v].push_back(u);
}

//To display the graph
void printGraph(vector<int> adj[], int V)
{
	for (int v = 0; v < V; ++v) {
		for (auto x : adj[v])
			cout << "-> " << x;
		printf("\n");
	}
}

int main()
{
	int V = 5;
	vector<int> adj[V];
	addEdge(adj, 0, 1);
	addEdge(adj, 0, 4);
	addEdge(adj, 1, 2);
	addEdge(adj, 1, 3);
	addEdge(adj, 1, 4);
	addEdge(adj, 2, 3);
	addEdge(adj, 3, 4);
	printGraph(adj, V);
	return 0;
}
