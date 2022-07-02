/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author andreugordillovazquez, mireiacalerojimenez
 */
public class Agent { //Es declaren els atributs de la classe Agent
    private Vec2D pos;
    private Vec2D dir;
    private Vec2D obj;
    private double speed, maxspeed;
    private double radius;
    private double weight;
    private int id;
    
    public Agent(Vec2D p, Vec2D o, double rad, int i){
        /**
         * En el constructor, inicialitzem els paràmetres necessaris per a crear un agent
         */
        pos = p;        
        obj = o;
        radius = rad;
        id = i;
        speed = 1.0;        //La velocitat per defecte és 1 píxel per segon
        weight = radius;    //El pes és proporcional al radi
        maxspeed = radius;  //La velocitat màxima és proporcional al radi
        dir = getDirToObj();
    }
    
    public void setPos(Vec2D p){this.pos = p;}
    //Mètode setter per a establir la posició d'un agent i guardar-la.
    
    public void setDir(Vec2D dir){this.dir = dir;}
    //Mètode setter per a establir la direcció d'un agent i guardar-la.
    
    public void setObj(Vec2D o){this.obj = o;}
    //Mètode setter per a establir l'objectiu d'un agent i guardar-lo.
     
    
    public Vec2D getPos(){return pos;}
    //Mètode getter que retorna la direcció d'un agent.
    
    public Vec2D getDir(){return dir;}
    //Mètode getter que retorna la direcció d'un agent.
         
    
    public Vec2D getObj(){return obj;}
    //Mètode getter que retorna l'objectiu d'un agent.
    
    public double getRadius(){return radius;}
    //Mètode getter que retorna el radi d'un agent.
    
    public Vec2D getDirToObj(){
        /**Mètode getter que retorna
         * la direcció fins a l'objectiu respecte a la posició acual..
         */
        Vec2D v = new Vec2D(obj.getX(), obj.getY());
        v.minus(pos);
        v.normalize();
        return v;
    }
    
    public void update(){
        /**Mètode update que actualitza
         * la posició de l'agent en funció de la velocitar i la direcció.
         */
        double x, y;
        x = dir.getX();
        y = dir.getY();
        x *= speed;
        y *= speed;
        Vec2D v1 = new Vec2D(x,y);
        pos.sum(v1);
    }
    
    public boolean objReached(){
        /**Mètode objReached que retorna 
         *true si l'agent ha arribat a l'objectiu, i false si no hi ha arribat. 
         */
        boolean t = true;
        boolean f = false;
        if (pos.dist(obj) <= 10){
            return t;
        }
        else{
            return f;
        }
    }
   
    public String toString(){
        /**Mètode toString que retorna la posició, l'objectiu
         * i l'id de l'agent.
         */
        return "(" + id + " " + pos.toString() + " " + obj.toString() + ")";
    }
}

