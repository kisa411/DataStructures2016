package lab09;

/**
 * A class for maintaining positions. 
 * A Position is a two-value pair giving row and column
 *
 * @author kimberly tabtiang, duane bailey
 */
public class Position {

    /**
     * coordinates of this position
     */
    protected int row, col;

    /**
     * constructor
     * @param r row
     * @param c column
     */
    public Position(int r, int c) {
        row = r;
        col = c;
    }

    /**
     * access method for col
     * @return column
     */
    public int col() {
        return col;
    }

    /**
     * access method for row
     * @return row
     */
    public int row() // post: returns row/vertical of position
    {
        return row;
    }

    /**
     * @return Position above this one
     */
    public Position north() {
        return new Position(row - 1, col);
    }

    /**
     * @return Position below this one
     */
    public Position south() {
        return new Position(row + 1, col);
    }

    /**
     * @return Position to right of this one
     */
    public Position east() {
        return new Position(row, col + 1);
    }

    /**
     * @return Position to left of this one
     */
    public Position west() {
        return new Position(row, col - 1);
    }

    /**
     * Check if this position is the same as some other one
     * @param other some other Position
     * @return true if objects represent same position
     */
    @Override
    public boolean equals(Object other) // post: 
    {
        Position that = (Position) other;
        return ((this.row == that.row)
                && (this.col == that.col));
    }

    /**
     * @return string representation of Position
     */
    @Override
    public String toString() 
    {
        return "[" + row + "][" + col + "]";
    }
}
