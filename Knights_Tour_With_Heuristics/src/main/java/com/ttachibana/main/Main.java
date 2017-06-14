/**
 * @author  Tyrel Tachibana
 * @date    2014-06-13
 * @notes   Doing the Knights Tour using a greedy Heuristics and Recursion
 */

package com.ttachibana.main;

import java.util.Scanner;
import javax.swing.JOptionPane;

public class Main
{
    public static void main(String[] args)
    {
        try
        {
            Solver knights_tour = new Solver();
            long time = System.nanoTime();
            // Size of the board 8 = 8x8, 50 = 50x50, etc
            System.out.println("Size of the board 8 = 8x8, 50 = 50x50, etc");
            System.out.print("Please insert the size of the board: ");
            knights_tour.solve(Integer.parseInt(new Scanner(System.in).nextLine()));
            System.out.println(knights_tour.getResult() + "\nTime used to solve: " + (System.nanoTime() - time) + " nanoseconds\n");
        }
        catch(Exception main_exception){new Thread(){@Override public void run(){JOptionPane.showMessageDialog(null, "Error: " + main_exception.getMessage());}}.start();}
    }
}
