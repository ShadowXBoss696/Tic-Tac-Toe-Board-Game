package org.shadowx.tictactoe.board;

/**
 * Enumeration representing the possible marks on a Tic-Tac-Toe tile.
 * Each tile can be marked as either {@link #X}, {@link #O}, or {@link #BLANK}.
 */
public enum TileMark {

    /**
     * Represents an empty tile.
     */
    BLANK(" "),

    /**
     * Represents a tile marked with the 'X'.
     */
    X("X"),

    /**
     * Represents a tile marked with the 'O'.
     */
    O("O");

    private final String displayValue;

    /**
     * Constructs a TileMark with the specified display value.
     *
     * @param displayValue The string representation of the mark (e.g., "X", "O", " ").
     */
    private TileMark(String displayValue) {
        this.displayValue = displayValue;
    }

    /**
     * Returns the display value of the mark.
     *
     * @return The display value of the mark.
     */
    public String getDisplayValue() {
        return displayValue;
    }

    /**
     * Returns the display value of the mark.
     *
     * @return The display value of the mark.
     */
    @Override
    public String toString() {
        return getDisplayValue();
    }
}
