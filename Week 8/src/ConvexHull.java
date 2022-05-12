
import java.awt.geom.*;
import java.util.ArrayList;

public class ConvexHull {
    public static void main(String[] args) {
        // The first 4 points are the convex hull
        double[] px = new double[]{0, 100, 0, 100, 25, 30, 44, 67, 89};
        double[] py = new double[]{0, 100, 100, 0, 77, 62, 90, 33, 28};

        // initialization
        int n = px.length;
        Point2D[] points = new Point2D[n];
        for (int i = 0; i < n; i++) {
            points[i] = new Point2D.Double(px[i], py[i]);
        }

        // brute force convex hull algorithm
        // assumption: there are no 3 points on the same line
        ArrayList<Line2D> convexHull = new ArrayList<Line2D>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                // create a line from point i -> j
                Line2D line = new Line2D.Double(points[i], points[j]);

                // check if all other points are on one side of the newly formed line
                boolean oneSide = true;
                boolean firstPoint = true;
                int sign = 0;
                for (int k = 0; k < n; k++) {
                    if (k == i || k == j) {
                        continue;
                    }
                    if (firstPoint) {
                        sign = line.relativeCCW(points[k]);
                        firstPoint = false;
                    } else {
                        int newSign = line.relativeCCW(points[k]);
                        if (newSign * sign < 0) {
                            oneSide = false;
                            break;
                        }
                    }
                }
                if (oneSide) {
                    convexHull.add(line);
                }
            }
        }

        // Output
        for (Line2D line2d : convexHull) {
            System.out.printf("\nLine (%f, %f) - (%f, %f) is on the convex",
                    line2d.getX1(), line2d.getY1(), line2d.getX2(), line2d.getY2());
        }
    }
}