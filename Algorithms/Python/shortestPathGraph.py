# shortest path algorithm graph

import sys
import math
import heapq

class Graph:
    def __init__(self, nodes):
        self.nodes = nodes
        self.edges = {}
        self.distances = {}

    def addEdge(self, fromNode, toNode, distance):
        self.edges.setdefault(fromNode, []).append(toNode)
        self.edges.setdefault(toNode, []).append(fromNode)
        self.distances[(fromNode, toNode)] = distance

    def dijkstra(self, initial):
        visited = {initial: 0}
        path = {}

        nodes = set(self.nodes)

        while nodes:
            minNode = None
            for node in nodes:
                if node in visited:
                    if minNode is None:
                        minNode = node
                    elif visited[node] < visited[minNode]:
                        minNode = node

            if minNode is None:
                break

            nodes.remove(minNode)
            currentWeight = visited[minNode]

            for edge in self.edges[minNode]:
                try:
                    weight = currentWeight + self.distances[(minNode, edge)]
                except KeyError:
                    continue
                if edge not in visited or weight < visited[edge]:
                    visited[edge] = weight
                    path[edge] = minNode

        return visited, path

    def shortestPath(self, initial, end):
        visited, paths = self.dijkstra(initial)
        fullPath = [end]
        while end != initial:
            end = paths[end]
            fullPath.append(end)
        fullPath.reverse()
        return visited[end], fullPath

def main():
    nodes = set()
    edges = []
    distances = {}

    with open(sys.argv[1]) as f:
        for line in f:
            line = line.strip()
            if line:
                fromNode, toNode, distance = line.split()
                nodes.add(fromNode)
                nodes.add(toNode)
                edges.append((fromNode, toNode))
                distances[(fromNode, toNode)] = int(distance)

    g = Graph(nodes)
    for edge in edges:
        g.addEdge(*edge, distances[edge])

    print(g.shortestPath(sys.argv[2], sys.argv[3]))

if __name__ == '__main__':
    main()

# Output

# $ python3 shortestPathGraph.py graph.txt A D

# (9, ['A', 'B', 'D'])

# $ python3 shortestPathGraph.py graph.txt A C

# (14, ['A', 'B', 'D', 'C'])

# $ python3 shortestPathGraph.py graph.txt A E

# (20, ['A', 'B', 'D', 'C', 'E'])

# $ python3 shortestPathGraph.py graph.txt A F

# (20, ['A', 'B', 'D', 'C', 'E', 'F'])

# $ python3 shortestPathGraph.py graph.txt A G

# (20, ['A', 'B', 'D', 'C', 'E', 'F', 'G'])
