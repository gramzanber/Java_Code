/**
 * @author  Tyrel Tachibana
 * @date    2014-06-13
 * @notes   Object that stores the Knights current position
 */

package com.ttachibana.main;

public class Position
{
    private int x;
    private int y;

    public Position(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public int getX() {return x;}
    public int getY() {return y;}
}
