package ru.job4j.chess.firuges.black;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

/**
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
        if (!isDiagonal(source, dest)) {
            throw new IllegalStateException(String.format("Could not way by diagonal from %s to %s", source, dest));
        }
        int size = 1 + Math.max(source.x, dest.x) - Math.min(source.x, dest.x);
        Cell[] steps = new Cell[size];
        int deltaX = source.x < dest.x ? 1 : -1;
        int deltaY = source.y < dest.y ? 1 : -1;
        int x = source.x;
        int y = source.y;
        for (int i = 0; i < size; i++) {
            steps[i] = Cell.findBy(x, y);
            x += deltaX;
            y += deltaY;
        }
        return steps;
    }
    public boolean isDiagonal(Cell source, Cell dest) {
        boolean result = false;
        int a = Math.max(source.x, dest.x);
        int b = Math.max(source.y, dest.y);
        if (a - (source.x + dest.x - a) == b - (source.y + dest.y - b)) {
            result = true;
        }
        return result;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
