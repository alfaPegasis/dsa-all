function PriorityQueue() { //removed unused size variable
	this.store = {};	// keys are priorities, values are arrays of elements
	this.count = 0;
	// either keep all the functions inside Priority Queue or outside.
	// only keep properties of object inside constructor and define the Object properties on the prototype function so that its easy to read and follow the code.
	// renamed all the functions to be camel cased only. Do not do like Pop or get_all_priorities
}

/**
 * Returns the total number of values in Priority Queue
 */
PriorityQueue.prototype.length = function() {
	return this.count;
}

/**
 * Adds a new value and priority to the Priority Queue. If the priority exists then it keeps addind values to the array of that priority and increment the counter to keep track of total number of values in Priority Queue
 */
PriorityQueue.prototype.add = function(value, priority){
    if (this.store[priority] == undefined)
			this.store[priority] = []; // thats ok to access object properties like that ..
	this.store[priority].push(value);
	this.count++;
}

/**
 * Removes the last added value from highest priority in the Priority Queue, by default it will get the highest priority
 * or can pass a specific priority to be popped
 */
PriorityQueue.prototype.pop = function(maxKey = Math.max.apply(null,Object.keys(this.store))){
	//save a reference to this in self so that we can use it inside call back functions below and modify hash...
	let self = this; // using let instead of var as it has only function level scope and help prevent any out of score errors in closures and help free up memory as this type of variable does not exist until its initialized.
	let popped =""; // the value that was popped out of queue
	let hasProperty = Object.prototype.hasOwnProperty.call(self.store, maxKey);
	//Check if queue has more than 1 value otherwise return null
	if(self.length()>=1 && hasProperty){
		self.count--;  //updating the value counter and reducing by one.
		if(self.store[maxKey].length>1){
			popped = self.store[maxKey].shift();
			return popped.toString();   
		}
		else if(this.store[maxKey].length==1){ //remove the key along with value
			popped = this.store[maxKey];
			self.store = Object.keys(self.store).reduce(function(obj, key) {
				if (key != maxKey) {           //key you want to remove
					obj[key] = self.store[key];
				}
				return obj;
			}, {});
			return popped.toString();
		}
	}
	return null; // if queue is empty return null as nothing is removed
}

/**
 * Get all priorities 
 */
PriorityQueue.prototype.getAllPriorities = function() { //renamed the function to camel case so that its consistent with others
	return Object.keys(this.store);
}

/**
 *  Iterates through all the queue elements in priority-then-FIFO order
 */
PriorityQueue.prototype.forEach = function(callback) {
	let keys = Object.keys(this.store).sort((a,b)=>b-a); // get keys(priorites) array in sorted order from highest to lowest
	if (callback && typeof callback === 'function') {
		for (let i = 0; i < keys.length; i++) {
			callback(keys[i], i, this);
		}
	}
}

/**
 * Update the priority of a value if exists and return true else return false
 */
PriorityQueue.prototype.changePriority = function(value, newPriority) {
	let foundItem = false;
	let self = this;
	//using only one for..in.. loop which is better for performance as compared to foreach..no need to have 2 foreach 
	for (let priority in self.store){
		let index = self.store[priority].indexOf(value); // Get the index of value from inside the array inside the priority
		if(index>=0){ // if value exists
			if(self.store[priority].length>1){
				self.store[priority].splice(index, 1);  // remove the item  //
				this.count--;
			}
			else if(self.store[priority].length==1){
				self.pop(priority) // we also remove the priority from hash if it onlly had 1 value left to avoid empty priorities
			}
			self.add(value, newPriority);
			return !foundItem; //return true and exit the loop
		}
	}
	return foundItem;
}

var p = new PriorityQueue(5);
console.log("getall priorities: "+p.getAllPriorities())
p.add("gucci",11);
p.add("tx",11)
p.add("chanel",8);
p.add("lv",7);
p.add("nike",6);
p.add("adidas",9);
console.log("getall priorities: "+p.getAllPriorities())
console.log(JSON.stringify(p.store),p.length());
p.changePriority("chanel",12);
p.changePriority("gucci",12);
p.changePriority("tx",6);
console.log(p.length());
console.log(JSON.stringify(p.store),p.length());
