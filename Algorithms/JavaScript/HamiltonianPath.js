var N = 5;
 
// Function to check whether there
// exists a Hamiltonian Path or not
function Hamiltonian_path( adj, N)
{
    var dp = Array.from(Array(N), ()=> Array(1 << N).fill(0));
 
 
    // Set all dp[i][(1 << i)] to
    // true
    for (var i = 0; i < N; i++)
        dp[i][(1 << i)] = true;
 
    // Iterate over each subset
    // of nodes
    for (var i = 0; i < (1 << N); i++) {
 
        for (var j = 0; j < N; j++) {
 
            // If the jth nodes is included
            // in the current subset
            if (i & (1 << j)) {
 
                // Find K, neighbour of j
                // also present in the
                // current subset
                for (var k = 0; k < N; k++) {
 
                    if (i & (1 << k)
                        && adj[k][j]
                        && j != k
                        && dp[k][i ^ (1 << j)]) {
 
                        // Update dp[j][i]
                        // to true
                        dp[j][i] = true;
                        break;
                    }
                }
            }
        }
    }
 
    // Traverse the vertices
    for (var i = 0; i < N; i++) {
 
        // Hamiltonian Path exists
        if (dp[i][(1 << N) - 1])
            return true;
    }
 
    // Otherwise, return false
    return false;
}
 
// Driver Code
// Input
var adj = [ [ 0, 1, 1, 1, 0 ],
                             [ 1, 0, 1, 0, 1 ],
                             [ 1, 1, 0, 1, 1 ],
                             [ 1, 0, 1, 0, 0 ] ];
var N = adj.length;
// Function Call
if (Hamiltonian_path(adj, N))
    document.write( "YES");
else
    document.write( "NO");
