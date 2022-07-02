
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
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
    
    public int getW(){return width;}
    //Mètode getter que retorna l'amplada de la finestra.
    
    public int getH(){return height;}
    //Mètode getter que retorna l'alçada de la finestra.
    
    public int getNumAgents(){return numAgents;}
    //Mètode getter que retorna el nombre d'agents visibles a la finestra.
    
    public Agent getAgent(int i){return agents[i];}
    //Mètode getter que retorna un agent de la llista en funció de l'index passat per paràmetre.
    
    public Vec2D randomPointInsideWorld(){
        /**
         * Mètode que retorna un vector aleatori dins de la finestra
         */
        double x = screenMargin + Math.random() * (width-screenMargin);
        double y = screenMargin + Math.random() * (height-screenMargin);
        Vec2D p = new Vec2D(x,y);
        return p;
    }
    
    public void update(){
        /**
         * Mètode que actualitza a cada pas cada agent de la simulació
         */
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
    
    public void run (int s){
        /**
         * Mètode run que executa s cops la funció update()
         */
        for (int i=0; i<s; i++){
            update();
        }
    }
}
