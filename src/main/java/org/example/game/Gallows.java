package org.example.game;

public final class Gallows {
    private final String[] gallows = {
            "    .-----",
            "    |",
            "    O",
            "   /|\\",
            "   / \\"
    };

    public void drawWithRope(final int partCount) {
        final int includeZeroIndex = 1;
        draw(partCount + includeZeroIndex);
    }

    private void draw(final int partCount) {
        System.out.println("Состояние виселицы: \n");

        for (int i = 0; i < partCount; i++) {
            System.out.println(gallows[i]);
        }
    }
}
