I created abstract classes Item, Room, and NPC - each of them are inherited by several subclasses, this is done to avoid repetition and to loosen coupling. I chose not to implement Abstract Factories because I only wanted one instance of each subclass.

I used Command pattern for my Command class and subclasses.

I used Facade design pattern to start the game. All the client needs to do is create a new instance of GameInstance and run the start() method. This hides the complex bits of the code from the client, and instead provides a simple wrapper that doesn't need to pass in any parameters.

I use the Iterator pattern with my Items class - which essentially is a Map from itemName -> Item object, but this hides the hashmap functions from the coder, and allows them to access it with simple functions and parameters.

I use an Interpreter design pattern for my Parser, whereby I split the user input into main action command and other parameters (such as itemName, location, or character name).

My GameInstance also behaves as a mediator between some classes (thought not true for all classes at the moment).

I wanted to use Observer pattern for reacting based on a game event (Change of object state), however I realized it was more efficient and easier to just update these lazily.