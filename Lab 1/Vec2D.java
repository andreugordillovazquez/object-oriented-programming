/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author martisanchez
 */
public class Vec2D {
   private double x; 
   private double y;
   
   Vec2D(){ x = y = 0.0; }
   Vec2D(double x_, double y_) { x = x_; y = y_; }
   void setX( double x_ ) { x = x_;}
   void setY( double y_ ) { y = y_;}
   double getX() { return x;}
   double getY() { return y;}   
   
   void sum(Vec2D v) { x += v.getX(); y += v.getY(); }
   void minus(Vec2D v) { x -= v.getX(); y -= v.getY(); }
   
   double dist(Vec2D v) { 
       return Math.sqrt((x - v.getX())*(x - v.getX()) + (y - v.getY())*(y - v.getY())); 
   }
   
   void normalize() {
       double length = Math.sqrt(x*x + y*y);
       x = x / length;
       y = y / length;
   }
   
   
   void rotate( double angle ) {
       double old_x = x, old_y = y;
       x = old_x * Math.cos( angle ) - old_y * Math.sin( angle );
       y = old_x * Math.sin( angle ) - old_y * Math.cos( angle );
   }

   double angle( Vec2D v ) {
       return Math.atan2( v.getY(), v.getX() ) - Math.atan2( y , x );
   }
   
   void rotateInDirectionOf( Vec2D v ) {
       x += (v.x-x) / 50.0;
       y += (v.y-y) / 50.0;

   }
   
   public String toString() {
       return "(" + x + " " + y + ")";
   }
}