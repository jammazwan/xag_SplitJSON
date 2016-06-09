There are so many approaches to splitting a message body that I found it helpful to break it into different projects.

### Common to all x__Split___ Projects

There are often many different ways to split even just one kind of body. This is where Camel's "does everything to anything" approach can be a bit confusing to the newbie. You may eventually want to learn 20 great approaches, but right now you just want one specific approach that's going work for your use case.

So each Split___ example project has to show, and/or cross reference, working code that makes each of the relevant approaches work, quickly and without a bunch of cruft.

**All Split___ example projects** were inspired by a grep of **'.split('** on **'*Test.java'** in the actual **camel-core** code base - hundreds of examples. A good place to start, if you want a more in depth exploration of anything, not just '.split('.

You will probably want to read [**this doc on Camel's site**](http://camel.apache.org/splitter.html) before doing much with splits. It took me a week to find it, and ended up being one of the best sources.

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

