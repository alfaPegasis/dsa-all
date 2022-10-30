    function isSubsetSum(set, n, sum)
    {
        // Base Cases
        if (sum == 0)
            return true;
        if (n == 0)
            return false;
   
        // If last element is greater than sum,
        // then ignore it
        if (set[n - 1] > sum)
            return isSubsetSum(set, n - 1, sum);
   
        /* else, check if sum can be obtained
        by any of the following
        (a) including the last element
        (b) excluding the last element */
        return isSubsetSum(set, n - 1, sum)
          || isSubsetSum(set, n - 1, sum - set[n - 1]);
    }
      
    let set = [ 3, 34, 4, 12, 5, 2 ];
    let sum = 9;
    let n = set.length;
    if (isSubsetSum(set, n, sum) == true)
      document.write("Found a subset with given sum");
    else
      document.write("No subset with given sum");
