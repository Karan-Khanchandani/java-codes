/**
 *
 *  Write a program which tests if two rectangles have a nonempty intersection. If the
intersection is nonempty, return the rectangle formed by their intersection.
 */

 public class Problem_5_11{
     public static class Rectangle{
        int x, y, width, height;
        
        public Rectangle(int x, int y, int width, int height){
            this.x = x;
            this.y = y;
            this.width = width;
            this.height =height;
        }
     }

     public static Rectangle intersectRectangle(Rectangle r1, Rectangle r2){
         if(!isIntersect(r1, r2)){
             return new Rectangle(0, 0, -1, -1);
         }

         return new Rectangle(
             Math.max(r1.x, r2.x), 
             Math.max(r1.y, r2.y), 
             Math.min(r1.x + r1.width, r2.x + r2.width) - Math.max(r1.x, r2.x), 
             Math.min(r1.y + r1.height, r2.y + r2.height) - Math.max(r1.y, r2.y)     
         );
     }

     public static boolean isIntersect(Rectangle R1, Rectangle R2){
        return R1.x <= R2. x + R2.width && R1.x + R1. width >= R2.x
        && R1.y <= R2.y + R2.height && R1.y + R1. height >= R2.y;
     }

     public static void printRect(Rectangle r){
         System.out.println("x = "+ r.x);
         System.out.println("y = "+ r.y);
         System.out.println("width = "+ r.width);
         System.out.println("height = "+ r.height);
     }

     public static void main(String[] args) {
         Rectangle r1 = new Rectangle(2, 4, 6, 11);
         Rectangle r2 = new Rectangle(5, 5, 12, 3);

         printRect(intersectRectangle(r1, r2));
     }
 }