// Source code is decompiled from a .class file using FernFlower decompiler (from Intellij IDEA).
import java.util.Scanner;

public class coffeecounter {
   public coffeecounter() {
   }

   public static void main(String[] var0) {
      Scanner var1 = new Scanner(System.in);
      System.out.println("====== Welcome to Ravi's Coffee Counter ======");
      System.out.println("Available Menu: Espresso, Latte, Cappuccino, Americano");
      System.out.println("Type 'exit' at the coffee prompt to close the counter.\n");

      while(true) {
         System.out.print("Enter coffee type (or 'exit' to quit): ");
         String var2 = var1.next().trim().toLowerCase();
         if (var2.equals("exit")) {
            System.out.println("Closing the counter. Have a great day, Ravi!");
            var1.close();
            return;
         }

         double var3 = (double)0.0F;
         boolean var5 = true;
         switch (var2) {
            case "espresso":
               var3 = (double)150.0F;
               break;
            case "latte":
               var3 = (double)200.0F;
               break;
            case "cappuccino":
               var3 = (double)220.0F;
               break;
            case "americano":
               var3 = (double)180.0F;
               break;
            default:
               System.out.println("Invalid coffee type! Please choose from the menu.\n");
               var5 = false;
         }

         if (var5) {
            System.out.print("Enter quantity: ");
            int var6 = var1.nextInt();
            if (var6 <= 0) {
               System.out.println("Quantity must be greater than 0.\n");
            } else {
               double var13 = var3 * (double)var6;
               double var9 = var13 * 0.18; 
               double var11 = var13 + var9;
               System.out.println("----- Receipt -----");
               System.out.println("Coffee: " + var2);
               System.out.println("Quantity: " + var6);
               System.out.println("Subtotal: " + var13);
               System.out.println("GST: " + var9);
               System.out.println("Total Bill: " + var11);
               System.out.println("-------------------");
            }
         }
      }
   }
}
