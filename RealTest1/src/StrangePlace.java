public class StrangePlace {
    private char[][] map;

    public StrangePlace(char[][] map) {
        this.map = map;
    }

    // calculate the distance from (r1, c1) to (r2, c2)
    private int distance(int r1, int c1, int r2, int c2) {
        return Math.abs(r1 - r2) + Math.abs(c1 - c2);
    }

    public int distance2Exit() {
        int youR, youC, exitR, exitC;
        youR = youC = exitR = exitC = -1;
        int rows = map.length;
        int cols = map[0].length;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (map[r][c] == 'Y') {
                    youR = r;
                    youC = c;
                }
                if (map[r][c] == 'X') {
                    exitR = r;
                    exitC = c;
                }
            }
        }
        return distance(youR, youC, exitR, exitC);
    }

    public boolean canEscape() {
        int yourDistance = distance2Exit();
        // calcualte the distance of all monster

        // first, get the location of the Exit
        int exitR, exitC;
        exitR = exitC = -1;
        int rows = map.length;
        int cols = map[0].length;
        outer:
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (map[r][c] == 'X') {
                    exitR = r;
                    exitC = c;
                    break outer;
                }
            }
        }

        // find all monsters and compare
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (map[r][c] == 'M') {
                    int d = distance(r, c, exitR, exitC);
                    if (d <= yourDistance) {
                        return false;
                    }
                }
            }
        }

        // no monster can catch you
        return true;
    }

    public int minSpeed2Escape() {
        // you can escape normally?
        if (canEscape()) {
            return 1;
        }

        int yourDistance = distance2Exit();

        // to win, you need to escape the nearest monster
        // first, get the location of the Exit
        int exitR, exitC;
        exitR = exitC = -1;
        int rows = map.length;
        int cols = map[0].length;
        outer:
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (map[r][c] == 'X') {
                    exitR = r;
                    exitC = c;
                    break outer;
                }
            }
        }

        // find the shortest distance of the monsters
        int shortestDistance = Integer.MAX_VALUE;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (map[r][c] == 'M') {
                    int d = distance(r, c, exitR, exitC);
                    if (d <= shortestDistance) {
                        shortestDistance = d;
                    }
                }
            }
        }
        return yourDistance / shortestDistance + 1;
    }

    public static void main(String[] args) {
        StrangePlace place = new StrangePlace(
                new char[][] {
                        {'.', 'Y', '.', '.'},
                        {'.', '.', '.', '.'},
                        {'M', '.', 'X', '.'},
                        {'.', '.', '.', 'M'}
                }
        );
        System.out.printf("Distance: %d\n", place.distance2Exit());
        System.out.printf("Can escape: %b\n", place.canEscape());
        System.out.printf("Min speed to escape: %d\n", place.minSpeed2Escape());

        StrangePlace place2 = new StrangePlace(
                new char[][] {
                        {'.', 'Y', '.', '.'},
                        {'.', '.', 'M', '.'},
                        {'M', '.', 'X', '.'},
                        {'.', '.', '.', 'M'}
                }
        );
        System.out.printf("Distance: %d\n", place2.distance2Exit());
        System.out.printf("Can escape: %b\n", place2.canEscape());
        System.out.printf("Min speed to escape: %d\n", place2.minSpeed2Escape());
    }
}