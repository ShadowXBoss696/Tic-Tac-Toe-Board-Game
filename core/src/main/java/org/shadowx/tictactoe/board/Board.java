package org.shadowx.tictactoe.board;

import org.shadowx.tictactoe.exception.InvalidMoveException;

/**
 * Represents the Tic-Tac-Toe game board.
 * Provides methods to interact with the board's tiles and their marks.
 */
public interface Board {

    /**
     * Retrieves the tile mark at the specified row and column.
     *
     * @param row The row index (0-based).
     * @param col The column index (0-based).
     * @return The {@link TileMark} at the specified position.
     * @throws IllegalArgumentException If the row or column is out of bounds.
     */
    TileMark getMarkAt(int row, int col);

    /**
     * Updates the tile mark at the specified row and column if the tile is blank.
     *
     * @param row The row index (0-based).
     * @param col The column index (0-based).
     * @param mark The mark to be placed on the tile.
     * @return true if the tile was updated, false if tile was already occupied.
     * @throws IllegalArgumentException If the row or column is out of bounds.
     * @throws InvalidMoveException If the tile is already occupied.
     */
    boolean updateMarkAt(int row, int col, TileMark mark);

    /**
     * Gets the size (number of rows/columns) of the board.
     *
     * @return The size of the board (e.g., 3 for a 3x3 board).
     */
    int size();

    /**
     * Checks if the board is full (no more empty tiles).
     *
     * @return {@code true} if the board is full, {@code false} otherwise.
     */
    default boolean isBoardFull() {
        int boardSize = size();
        for (int row = 0; row < boardSize; row++) {
            for (int col = 0; col < boardSize; col++) {
                if (getMarkAt(row, col) == TileMark.BLANK) {
                    return false; // Found an empty tile, board is not full
                }
            }
        }
        return true; // No empty tiles found, board is full
    }

    /**
     * Prints the current state of the board to the console.
     * This is a default method, so implementing classes do not need to provide an implementation.
     * The output format will be a grid-like representation of the board,
     * with each tile showing its current mark (X, O, or a blank space).
     */
    default void printBoard() {
        int boardSize = size();
        for (int row = 0; row < boardSize; row++) {
            for (int col = 0; col < boardSize; col++) {
                System.out.print("[" + getMarkAt(row, col).getDisplayValue() + "]");
            }
            System.out.println();
        }
    }
}
