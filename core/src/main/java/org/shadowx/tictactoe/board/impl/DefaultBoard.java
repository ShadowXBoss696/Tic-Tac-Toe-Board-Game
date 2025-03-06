package org.shadowx.tictactoe.board.impl;

import org.shadowx.tictactoe.board.Board;
import org.shadowx.tictactoe.exception.InvalidMoveException;
import org.shadowx.tictactoe.board.TileMark;

/**
 * Represents the most standard Tic-Tac-Toe game board implementation.
 * This class provides a concrete implementation of the {@link Board} interface,
 * managing the state of the game board and providing methods to interact with it.
 */
public class DefaultBoard implements Board {

    private final int boardSize;
    private final TileMark[][] board;

    /**
     * Constructs a new DefaultBoard with the specified board size.
     *
     * @param boardSize The size of the board (e.g., 3 for a 3x3 board).
     * @throws IllegalArgumentException if the boardSize is not valid (less than 1).
     */
    public DefaultBoard(int boardSize) {
        this.boardSize = boardSize;
        this.board = new TileMark[boardSize][boardSize];
        initializeBoard();
    }

    /**
     * Initializes the board by setting all tiles to BLANK.
     */
    private void initializeBoard() {
        for (int row = 0; row < boardSize; row++) {
            for (int col = 0; col < boardSize; col++) {
                board[row][col] = TileMark.BLANK;
            }
        }
    }

    /** {@inheritDoc} */
    @Override
    public int size() {
        return boardSize;
    }

    /** {@inheritDoc} */
    @Override
    public TileMark getMarkAt(int row, int col) {
        validateCoordinates(row, col);
        return board[row][col];
    }

    /** {@inheritDoc} */
    @Override
    public boolean updateMarkAt(int row, int col, TileMark mark) {
        validateCoordinates(row, col);

        if (board[row][col] != TileMark.BLANK) {
            throw new InvalidMoveException("Tile already occupied at: (" + row + ", " + col + ")");
        }

        board[row][col] = mark;
        return true;
    }

    /**
     * Validates if the coordinates are within the bounds of the board.
     *
     * @param row The row index (0-based).
     * @param col The column index (0-based).
     * @throws IllegalArgumentException If the row or column is out of bounds.
     */
    private void validateCoordinates(int row, int col) {
        if (row < 0 || row >= boardSize || col < 0 || col >= boardSize) {
            throw new IllegalArgumentException("Invalid coordinates: (" + row + ", " + col + ")");
        }
    }
}
