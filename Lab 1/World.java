
import java.util.ArrayList;

/**
 * @author andreugordillovazquez, mireiacalerojimenez
 */

public class World {
    private int width;
    private int height;
    private int screenMargin;
    private int numAgents;
    private Agent[] agents;
    
    public World(){
        this.width = 800;
        this.height = 600;
        this.numAgents = 10;
        this.screenMargin = 30;
        int N = 10;
        agents = new Agent[N];
        for (int i=0;i<N;i++){
            double randRad = 5 + Math.random() * (screenMargin/2);
            agents[i] = new Agent(randomPointInsideWorld() ,randomPointInsideWorld() ,randRad, i);
        }
    }
    
    // Getter method that returns the width of the window.
    public int getW(){
        return width;
    }
    
    // Getter method that returns the height of the window.
    public int getH(){
        return height;
    }

    // Getter method that returns the number of visible agents in the window.
    public int getNumAgents(){
        return numAgents;
    }
    
    // Getter method that returns the agent in the ith position in the list.
    public Agent getAgent(int i){
        return agents[i];
    }
    
    // Method that returns a random vector inside the window.
    public Vec2D randomPointInsideWorld(){
        double x = screenMargin + Math.random() * (width-screenMargin);
        double y = screenMargin + Math.random() * (height-screenMargin);
        Vec2D p = new Vec2D(x,y);
        return p;
    }
    
    // Method that updates at each step each agent of the simulation
    public void update(){
        Agent a;
        Vec2D d;
        for (int i = 0; i<numAgents; i++){
            a = getAgent(i);
            a.update();
            d = agents[i].getDir();
            d.rotateInDirectionOf(agents[i].getDirToObj());
            if (a.objReached()){
                a.setObj(randomPointInsideWorld());
            }
        }
    }
    
    // Run method that executes s times the update() function.
    public void run (int s){
        for (int i=0; i<s; i++){
            update();
        }
    }
}
