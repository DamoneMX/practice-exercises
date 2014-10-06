Solution to ** coding challenge
I am using an underlying linked list to store my ranges,
I decided to go with a linked list due to the insertions and lookup cost
When inserting a new range, insertion will be O(1), however the lookup for the place
to insert may be O(n), that is why I have separated the function: lookupInsertPosition
Given more time, I would implement a Binary Search Tree that could act as an index that points
to the nodes in the list,  thus reducing the insert time to O(logN), 
given time constraints this would have been very hard to implement.

So, by using my linked list I have achieved the following time costs for the operations:
AddRange -> O(n) time complexity
QueryRange -> O(n)
DeleteRange -> O(n)

The approaches that came to my mind where in the following order:
1. Using an array to hold the ranges, but this implementation is extremely inneficient as 
there's the added cost of resizing constantly. And there's nothing to be gained as you still have
to lookup the insert position.
2. A BST which holds the ranges, however the implementation is very hard within the given time
frame.
3. My final solution which is using a linked list, the ideal case would be to have a BST as an
index pointing to the Nodes in the linked list. As mentioned previously this would speed up
looking up for the insert position and after the insert position is found then it's a simple
linked list insertion.

Solution 
-> Forgot to test for error conditions in time, just thought about it after solution was sent already


My method to test is in RangeModule.java 

-> Conditions: 2 hour challenge
