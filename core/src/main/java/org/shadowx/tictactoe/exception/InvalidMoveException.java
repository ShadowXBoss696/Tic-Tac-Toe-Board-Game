package org.shadowx.tictactoe.exception;

/**
 * Exception thrown when an invalid move is attempted in the Tic-Tac-Toe game.
 * This typically occurs when a player tries to mark a tile that is already occupied.
 */
public class InvalidMoveException extends RuntimeException {

    /**
     * Constructs an InvalidMoveException with the specified detail message.
     *
     * @param message The detail message.
     */
    public InvalidMoveException(String message) {
        super(message);
    }
}
