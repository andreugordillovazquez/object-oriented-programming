21414 - Object Oriented Programming
Andreu Gordillo Vázquez and Mireia Calero Jimenez

# Lab 1 documentation - Implementing a class in Java

**1. An introduction describing the problem. For example, what should the program do? What classes do you need to define? What methods should you implement for these classes?**

In this practice it has been asked to implement the solution to a simulation, where agents, driven by basic trigonometric calculations, move through a space delimited by a window of 800x600 to reach a certain goal, set randomly by the requested code. Once the goal has been reached, the program must determine another goal at random.
To perform this simulation, we used 4 classes mainly:

- **MyWorldWindow** is the main class of the program, and where the basic parameters of the window are initialized, and where the colors that the agents and the objectives will have are determined.
- **Vec2D** is the class where we have the methods that make possible the treatment of vectors throughout the program, as it allows us to create them, perform mathematical operations between them, how to add and subtract them, and other computations that will help us to perform the simulation correctly.
- **Agent** is the class where we find the methods designed to control the action of the agents located in the simulation, such as the getters and setters in the class, and other methods that help to operate with the agent inside the window.
- **World** is the class that controls everything that happens up to the simulation, from the size of the window to determining a random point inside the window, including the getters that help us get the attributes of the class from outside of the same.

Once all the classes in the program have been explained, we will give detailed explanations about each of these methods.

- **public class MyWorldWindow**
  - **public MyWorldWindow():** It is the constructor of the class. Within this method, we initialize the components, call the World() class constructor, and set the window sizes with the World() class getters.
  - **public void paint (Graphics g):** This method allows us to paint agents and targets red and black, respectively, apart from running the run() method from the World() class.
  - **private void jButtonActionPerformed(...):** This method restarts the screen each time the Step button is pressed, allowing a different simulation to be displayed each time we press the button.

- **public class Vec2D**
  - **Vec2D():** It is the constructor of the class Vec2D, that creates a vector initialized with x = y = 0.
  - **Vec2D(double x_, double y_):** This method allows you to include the two numbers passed as a parameter and turn them into a two-dimensional vector.
  - **void setX(double x_):** This setter method sets the value passed by parameter as the x value of a vector.
  - **void setY(double y_):** This setter method sets the value passed by parameter as the y value of a vector.
  - **double getX():** This getter method returns the x value of a given vector.
  - **double getY():** This getter method returns the y value of a given vector.
  - **void sum(Vec2D v):** This method sums two components component by component.
  - **void minus(Vec2D v):** This method subtracts two component-by-component vectors.
  - **double dist(Vec2D v):** This method computes the distance between two points located in the simulation.
  - **void normalize():** This method normalizes a given vector.
  - **void rotate(double angle):** This method rotates the past angle to set a given vector.
  - **void rotateInDirectionOf(Vec2D v):** This method rotates a vector in a certain direction.
  - **public String toString():** This method returns a vector in the form of a string.

- **public class Agent**
  - **public Agent(Vec2D p, Vec2D or, double rad, int i):** Is the constructor of the Agent class. It initializes several variables: position, goal, radius, id, speed, weight, top speed, and direction.
  - **public void setPos(Vec2D p):** This setter method sets the position of a given agent.
  - **public void setDir(Vec2D d):** This setter method sets the direction of a given agent.
  - **public void setObj(Vec2D or):** This setter method sets the target of a given agent.
  - **public Vec2D getPos():** This getter method returns the position of a given agent.
  - **public Vec2D getDir():** This getter method returns the address of a given agent.
  - **public Vec2D getObj():** This getter method returns the target of a given agent.
  - **public Vec2D getRadius():** This getter method returns the radius of a given agent.
  - **public Vec2D getDirToObj():** This getter method returns the direction to the target based on the current position.
  - **public void update():** This method updates the agent's position based on speed and direction.
  - **public boolean objReached():** This method returns the boolean value true if the distance between the target and the Agent is less than 10, on the contrary, it returns the boolean value false.
  - **public String toString():** This method returns the id, position, and target of the Agent as a string.

- **public class World**
  - **public World():** It is the constructor of the World class. Initializes the values for the height and width of the window, the number of agents we will see in the simulation, the margin of the window, and the list of agents.
  - **public int getW():** Getter method that returns the width of the window.
  - **public int getH():** Getter method that returns the height of the window.
  - **public int getNumAgents():** Getter method that returns the number of agents visible in the window.
  - **public Agent getAgent(int i):** Getter method that returns an agent from the list based on the index passed as a parameter.
  - **public Vec2D randomPointInsideWorld():** Method that returns a random vector inside the window, except in the margins.
  - **public void update():** Method that updates each agent in the simulation at each step.
  - **public void run(int s):** Run method that runs the update () function s times.

Thanks to these classes and methods, the correct and expected implementation of the proposed problem has been possible.

**2. A description of the possible workarounds that were discussed, and a description of the solution chosen and the reason for choosing that solution over others. It is also a good idea to mention the theoretical concepts related to object-oriented programming that were applied as part of the solution.**

The solution provided in our _.java_ files is the only solution that was discussed, as we believe it was the right one, and for this reason, we focused on properly developing the methods for it. We find that the chosen solution is correct since we have a class for each basic concept of the program, that is to say, we have a class by agent (**class Agent**), a class by the vector (**class Vect2D**), a class by the world (**class World**) and a class for the window where the program is developed (**class MyWorldWindow**). In this way we can develop the methods of each class separately in order to achieve the final result.
Regarding the theoretical concepts taught in theory classes, we used the following:
- Classes
- Attributes
- Methods, where we can find Builders, Getters and Setters
- Objects
- Encapsulation, using a level of visibility, private (by attributes) and public (by methods).

**3. A conclusion that describes how well the solution has worked in practice, i.e. has the tests shown that the classes are implemented correctly? You can also mention any difficulties during implementation, as well as any questions you may have had.**

In conclusion, we found that this practice was of little complexity, as one could follow the script process easily and in a fairly understandable way. Although we have had some doubts during the program process, but we have been able to solve it by consulting the java documentation or with the theories of the subject. The tests proposed by the script have worked well for us, and in this way we have been able to better understand the code. We've also added tests ourselves to see if the program did what we thought it would, to keep track of the code at all times. We didn't encounter any problems calling classes or creating objects. Nor has we had any difficulty calling methods, or using them.
The only problem we had during programming was when creating and adding agents to the list and the exception appeared: NullPointerException. This problem originated because we were referring to the list of agents without adding them correctly. That way, the space saved by the list would be null and void. However, we ended up finding the error and correcting it.
