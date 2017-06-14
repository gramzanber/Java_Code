/**
 * @author  Tyrel Tachibana
 * @date    2014-06-13
 * @notes   The chessboard that will be used to move the Knights around, can 
 *          be expanded to support the Queen's tour.
 */

package com.ttachibana.main;

import java.util.LinkedList;
import java.util.List;

public class KnightBoard
{
    private static final int[][] posMoves = { { 2, 1 }, { 2, -1 }, { -2, 1 }, { -2, -1 }, { 1, 2 }, { 1, -2 }, { -1, 2 }, { -1, -2 } };
    private int size;
    private boolean[][] beenOn;
    private Position knightPosition = new Position(1, 1);

    private int[][] degree;

    public KnightBoard(int size)
    {
        this.size = size;
        beenOn = new boolean[size][size];
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++)
                beenOn[i][j] = false;
        setDegree();
    }

    private void setDegree()
    {
        degree = new int[size][size];
        for (int i = 0; i < size; i++)
        {
            for (int j = 0; j < size; j++)
            {
                if ((i == 0 && j == 0) || (i == 0 && j == size - 1)
                        || (i == size - 1 && j == size - 1)
                        || (i == size - 1 && j == 0))
                    degree[i][j] = 2;
                else if ((i == 1 && j == 0) || (i == 1 && j == size - 1)
                        || (i == size - 2 && j == size - 1)
                        || (i == size - 2 && j == 0) || (i == 0 && j == 1)
                        || (i == 0 && j == size - 2)
                        || (i == size - 1 && j == size - 2)
                        || (i == size - 1 && j == 1))
                    degree[i][j] = 3;
                else if ((i == 1 && j == 1) || (i == 1 && j == size - 2)
                        || (i == size - 2 && j == size - 2)
                        || (i == size - 2 && j == 1)
                        || (i == 0 && (j >= 2 && j < 6))
                        || ((i >= 2 && i < 6) && j == 0)
                        || (i == size - 1 && (j >= 2 && j < 6))
                        || ((i >= 2 && i < 6) && j == size - 1))
                    degree[i][j] = 4;
                else if ((i == 1 && (j >= 2 && j < 6))
                        || ((i >= 2 && i < 6) && j == 1)
                        || (i == size - 2 && (j >= 2 && j < 6))
                        || ((i >= 2 && i < 6) && j == size - 2))
                    degree[i][j] = 6;
                else
                    degree[i][j] = 8;
            }
        }
    }

    public int getDegree(Position pos) {return degree[pos.getX() - 1][pos.getY() - 1];}
    public int getSize() {return size;}
    public void set(Position p, boolean beenOn) {this.beenOn[p.getX() - 1][p.getY() - 1] = beenOn;}
    public boolean get(Position p) {return this.beenOn[p.getX() - 1][p.getY() - 1];}
    public void setKnightPosition(Position p) {this.knightPosition = p;}
    public Position getKnightLocation() {return knightPosition;}
    public boolean isAllBeenOn()
    {
        for (boolean[] bool : beenOn)
            for (boolean wasOn : bool)
                if (!wasOn)
                    return false;
        
        return true;
    }

    public String getCoord(Position p) {return "N-" + toChar(p.getX()) + p.getY();}
    
    private String toChar(int x)
    {
        String result = "";
        while(true)
            if (x > 26)
            {
                result += (char) ((x % 26) + 64);
                x /= 26;
            }
            else
            {
                result += (char) (x + 64);
                return result;
            }
    }

    public Position[] possibleMoves()
    {
        List<Position> result = new LinkedList<>();
        for (int[] posMove : posMoves)
        {
            int x = knightPosition.getX() + posMove[0];
            int y = knightPosition.getY() + posMove[1];
            if (x > 0 && y > 0 && x <= size && y <= size)
            {
                Position possiblePos = new Position(x, y);
                if (!get(possiblePos)) {result.add(possiblePos);}
            }
        }
        return result.toArray(new Position[result.size()]);
    }

    public Position[] possibleMoves(Position position)
    {
        List<Position> result = new LinkedList<>();
        for (int[] posMove : posMoves)
        {
            int x = position.getX() + posMove[0];
            int y = position.getY() + posMove[1];
            if (x > 0 && y > 0 && x <= size && y <= size)
            {
                Position possiblePos = new Position(x, y);
                if (!get(possiblePos)) {result.add(possiblePos);}
            }
        }
        return result.toArray(new Position[result.size()]);
    }
}
