#C 346 Project 1
###<i>Purposes</i>
- Implement a Linked List that adheres to the <br>
  ILinkedList\<T> Interface
- Unit test the implementations in the<br>
  MyLinkedList\<T> class
- Create a github repository for the project
##Implementation
#####Data Members:
> T data - the data this node holds<br>
> MyLinkedList\<T> next - the next node



#####Constructors:
The MyLinkedList\<T> class provides three constructors <br>
for creating a list. <br><br> Their respective responsibilites are:
- Initialize an empty list
- Take a single data member to create the first node
- Fill the list with data by passing a Collection\<T> <br>
  object
<br>

#####Methods:
I've implemented all of the methods from the <br>
ILinkedList\<T> interface. These allow us to retrieve <br>
and manipulate the data present in a list.

##Testing
I constructed 20 unit tests to ensure expected behavior <br>
from a range of possibilities. These include testing typical <br>
behavior as well as expected faults. An example of this <br>
would be a client passing too large a value into the <br>
```after(int position)``` method. In this case we would <br>
expect a NullPointerException from trying to dereference <br>
a null node.


