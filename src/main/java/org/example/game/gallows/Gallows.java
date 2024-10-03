package org.example.game.gallows;

public final class Gallows {
    private final GallowsPictures gallowsPictures;

    public Gallows() {
        this.gallowsPictures = new GallowsPictures();
    }

    public void draw(final int stateNumber) {
        System.out.println("Состояние виселицы: \n");
        String[] state = gallowsPictures.get(stateNumber);

        for (String part : state) {
            System.out.println(part);
        }
    }
}

