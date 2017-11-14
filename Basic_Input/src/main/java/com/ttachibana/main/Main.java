/**
 * @author  Tyrel Tachibana
 * @date    2017-11-14
 * @notes   Basic input name and output name
 */

package com.ttachibana.main;

public class Main
{
    public static void main(String [] args)
    {
        System.out.print("Name: ");
        String name = new java.util.Scanner(System.in).nextLine();
        System.out.println("Hi " + name);
    }
}
