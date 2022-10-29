Class Vertex:
  
    def __init__(self, key):
        self.id = key
        self.connectedTo = {}
        
    def addNeighbor(self, nbr, weight = 0):
        self.connectedTo[nbr] = weight
        
    def __str__(self):
        return f"{str(self.id)} connected to: {str([x.id for x in
                  self.connectedTo])}"
      
    def getConnections(self):
        retun self.connectedTo.keys()
        
    def getId(self):
        return self.id
      
    def getWeight(self, nbr):
        return self.connectedTo.get(nbr)
      
class Graph:
  
    def __init__(self):
        self.vertList = {}
        self.numVertices = 0
        
    def addVertex(self, key):
        """
        Add a vertex to the Graph network with the id of key
        Time complexity is O(1) as we are only adding a single
        new vertex which does not affect any other vertex
        """
        
        #add 1 to the number of vertices attribute
        self.numVertices += 1
        
        #instantiate a new Vertex class
        newVertex = Vertex(key)
        
        #add the vertex with the key to the vertList dictionary
        self.vertList[key] = newVertex
        
        #return the NewVertex created
        return newVertex  
      
    def getVertex(self, key):
        """
        If vertex with key is in Graph then return the Vertex
        Time complexity is O(1) as we are simply checking whether
        the key exists or not in a dictionary and returning it
        """
        
        #use the get method to return the Vertex if it exists
        #otherwise it will return None
        return self.vertList.get(key)
      
    def __contains__(self, key):
        """
        Check whether vertex with key is in the Graph
        Time complexity is O(1) as we are simply checking whether 
        the key is in in the dictrionary or not
        """
        
        #returns True or False depending if in list
        return key in self.vertList
      
    def addEdge(self, f, t, weight = 0):
        """
        Add an edge to connect two vertices of t and f with weight
        assuming directed graph
        
        Time complexity of O(1) as adding vertices if they don't 
        exist and then add neighbor
        """
        
        #add vertices if they do not exist
        if f not in self.vertList:
            nv = self.addVertex(f)
        if t not in self.vertList:
            nv = self.addVertex(t)
            
        #then add Neighbor from f to t with weight
        self.vertList[f].addNeighbor(self.vertList[t], weight)
        
    def getVertices(self):
        """
        Return all the vertices in the graph
        Time complexity is O(1) as we simply return all the keys
        in the vertList dictionary
        """
       
        return self.vertList.keys()
      
    def getCount(self):
        """
        Return a count of all vertices in the Graph
       
        Time complexity O(1) because we just return the count
        attribute
        """
        return self.numVertices
