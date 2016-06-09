### SplitJSON NOTES:

For this X__project, camel-jsonpath is used.

No serious work can be done in this area without consulting [**jsonpath documentation**](http://goessner.net/articles/JsonPath/) for jsonpath syntax

### Syntax/Semantics for splitting on camel-jsonpath?

I found two different approaches for writing a jsonpath split. Knowing Camel, there are probably dozens more :). But on the four examples in this x__project I alternated each of the two, to demo each.

Either of these seems to work the same:

 * .split(new JsonPathExpression("$.employees.[*].city"))
 * .split().jsonpath("$.employees.[*].city")
 
 With the longer of the above having the advantage of being able to externalize as a variable, as was done in the actual code.

### Running and Testing

Run with XagTest and explore the results. 

If you want a little bit better understanding, you can log the body of the split message, but that is more about understanding jsonpath than camel split.

The first of the four examples logs the split body to console.

