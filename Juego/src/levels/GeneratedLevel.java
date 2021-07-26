package levels;

import java.util.Random;

public class GeneratedLevel extends Level {
    private static final Random random = new Random();

    public GeneratedLevel(int width, int height) {
        super(width, height);
    }

    @Override
    protected void generateLevel() {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                tiles[x + y * width] = random.nextInt(2);
            }
        }
    }
}
