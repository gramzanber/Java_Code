/**
 * @author  Tyrel Tachibana
 * @date    2014-06-13
 * @notes   The class that does all the magic
 */

package com.ttachibana.main;

public class Solver
{
    private StringBuilder result = new StringBuilder();

    public String getResult() {return result.toString();}

    public boolean solve(int size)
    {
        KnightBoard board = new KnightBoard(size);
        Position start = new Position(1, 1);
        board.set(start, true);
        board.setKnightPosition(start);
        return solve(board);
    }

    private boolean solve(KnightBoard board)
    {
        if (board.isAllBeenOn()){return true;}
        
        Position[] possibleMoves = board.possibleMoves();
        if (possibleMoves.length == 0) {return false;}
        
        int index = 0;
        for (int i = 0; i < possibleMoves.length; i++)
        {
            int posMoves = board.possibleMoves(possibleMoves[i]).length;
            int indexPosMoves = board.possibleMoves(possibleMoves[index]).length;
            if (posMoves < indexPosMoves || (posMoves == indexPosMoves && board.getDegree(possibleMoves[i]) < board.getDegree(possibleMoves[index]))) {index = i;}
        }
        result.append(board.getCoord(board.getKnightLocation())).append("\n");
        board.setKnightPosition(possibleMoves[index]);
        board.set(possibleMoves[index], true);
        return solve(board);
    }
}
