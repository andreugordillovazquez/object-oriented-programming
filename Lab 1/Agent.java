/**
 *
 * @author andreugordillovazquez, mireiacalerojimenez
 */

// The attributes of the Agent class are declared.
public class Agent { 
    private Vec2D pos;
    private Vec2D dir;
    private Vec2D obj;
    private double speed, maxspeed;
    private double radius;
    private double weight;
    private int id;
    
    // In the constructor, we initialize the parameters needed to create an agent.
    public Agent(Vec2D p, Vec2D o, double rad, int i){
        pos = p;        
        obj = o;
        radius = rad;
        id = i;
        speed = 1.0;            // The default speed is 1 pixel per second.
        weight = radius;        // The weight is proportional to the radius.
        maxspeed = radius;      // The maximum speed is proportional to the radius.
        dir = getDirToObj();
    }
    
    // Setter method for setting the position of an agent and saving it.
    public void setPos(Vec2D p){
        this.pos = p;
    }
    
    // Setter method for setting the agent direction and saving it.
    public void setDir(Vec2D dir){
        this.dir = dir;
    }
    
    // Setter method for setting an agent's goal and saving it.
    public void setObj(Vec2D o){
        this.obj = o;
    }
    
    // Getter method that returns the position of an agent.
    public Vec2D getPos(){
        return pos;
    }
    
    // Getter method that returns the direction of an agent.
    public Vec2D getDir(){
        return dir;
    }
         
    // Getter method that returns the goal of an agent.
    public Vec2D getObj(){
        return obj;
    }

    // Getter method that returns the radius of an agent.
    public double getRadius(){
        return radius;
    }
    
    // Getter method that returns the direction to the target with respect to the current position.
    public Vec2D getDirToObj(){
        Vec2D v = new Vec2D(obj.getX(), obj.getY());
        v.minus(pos);
        v.normalize();
        return v;
    }
    
    // Update method that updates the position of the agent based on speed and direction.
    public void update(){
        double x, y;
        x = dir.getX();
        y = dir.getY();
        x *= speed;
        y *= speed;
        Vec2D v1 = new Vec2D(x,y);
        pos.sum(v1);
    }
    
    // ObjReached method that returns true if the agent has reached the target, and false if it has not.
    public boolean objReached(){
        boolean t = true;
        boolean f = false;
        if (pos.dist(obj) <= 10){
            return t;
        }
        else{
            return f;
        }
    }
   
    // ToString method that returns the position, goal, and agent id.
    public String toString(){
        return "(" + id + " " + pos.toString() + " " + obj.toString() + ")";
    }
}
