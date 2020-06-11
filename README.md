**Coding Challage Train Problem.**


**Trains**

Commuter railroad service for the towns in Kiwiland. 

**Problem Statement**

The local commuter railroad services a number of towns in Kiwiland.  Because of monetary concerns, all of the tracks are 'one-way.'  That is, a route from Kaitaia to Invercargill does not imply the existence of a route from Invercargill to Kaitaia.  In fact, even if both of these routes do happen to exist, they are distinct and are not necessarily the same distance!

The purpose of this problem is to help the railroad provide its customers with information about the routes.  In particular, you will compute the distance along a certain route, the number of different routes between two towns, and the shortest route between two towns.

**Input**  
> A directed graph where a node represents a town and an edge represents a route between two towns.  The weighting of the edge represents the distance between the two towns.  A given route will never appear more than once, and for a given route, the starting and ending town will not be the same town. 

> The towns are named using the first few letters of the alphabet from `A` to `E`.  A route between two towns (`A` to `B`) with a distance of `5` is represented as `AB5`. A directed graph is represented by a list of routes, with each route as a separate line.

**Available Actions**
-  Compute the distance along a certain route. If no such route exists, output 'NO SUCH ROUTE'. Otherwise, follow the route as given; do not make any extra stops!
- Compute the number of different routes between two towns.
-  Compute the shortest route between two towns.

**Example Input & Output**

Below follows an example with input data, actions performed and expected output result.

**Sample Input:**
```
AB5
BC4
CD8
DC8
DE6
AD5
CE2
EB3
AE7
```

**Actions:**
```
The distance of the route A-B-C.
The distance of the route A-D.
The distance of the route A-D-C.
The distance of the route A-E-B-C-D.
The distance of the route A-E-D.
The number of trips starting at C and ending at C with a maximum of 3 stops.  In the sample data below, there are two such trips: C-D-C (2 stops). and C-E-B-C (3 stops).
The number of trips starting at A and ending at C with exactly 4 stops.  In the sample data below, there are three such trips: A to C (via B,C,D); A to C (via D,C,D); and A to C (via D,E,B).
The length of the shortest route (in terms of distance to travel) from A to C.
The length of the shortest route (in terms of distance to travel) from B to B.
The number of different routes from C to C with a distance of less than 30.  In the sample data, the trips are: CDC, CEBC, CEBCDC, CDCEBC, CDEBC, CEBCEBC, CEBCEBCEBC.
```

**Expected Output:**
```
Output #1: 9
Output #2: 5
Output #3: 13
Output #4: 22
Output #5: NO SUCH ROUTE
Output #6: 2
Output #7: 3
Output #8: 9
Output #9: 9
Output #10: 7
```


Sample data for a *graph* and *commands* can be found [here](https://github.com/lucaslouca/Trains/tree/master/src/test/resources).
