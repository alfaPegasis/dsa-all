const getAllSubsets = (set)=>{
    return set.reduce(
      (subsets, value) => subsets.concat(
       subsets.map(set => [value,...set])
      ),
      [[]]
    );
}

const subsetSum = (set)=>{
    const subsets = getAllSubsets(set);
    let exists = false;
    subsets.forEach(v=>{
        if(v.length>0){
            let sum = 0;
            v.forEach(v2=>{
                sum+=v2
            })
            if(sum===0) exists = true
        }
    })
    return exists
}