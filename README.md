Implementation exercise for datastructures course. Exercise description underneath


## Exercise

Implement a dynamic table of integers that supports the following 4 methods: insertion, deletion, print elements, and reporting the size of the table (both the actual size and the size of the allocated table).  
When an element is inserted and the allocated table is already full, the size of the allocated table should grow by a factor of 2.  
When an element is deleted and the size afterwards is 1/4 of the capacity, the size of the allocated table should be halved.  
The allocated table should always have size at least 1 (ie. when 0 elements are inserted it should still have size 1).

### Input

Each line: Either "I X" meaning insert X in the table (where X is an integer),  
"D" meaning delete the last element in the table,  
"P" meaning print all elements currently in the table,  
"S" meaning print the actual size and the size of the allocated table.

### Output

For each "P" in the input, output a line of all elements in the table separated by a whitespace.  
For each "S" in the input, output a line with two integers separated by whitespace, namely the actual size (the number of elements in the table) and the size of the allocated table (should always be a power of 2).
