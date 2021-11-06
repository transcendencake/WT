package by.bsuir.lab1.task2;

public class GeometryShape {
    private Point[] points;

    public GeometryShape() {
        points = new Point[]
            {
                new Point(-6, -3),
                new Point(-6, 0),
                new Point(-4, 0),
                new Point(-4, 5),
                new Point(4, 5),
                new Point(4, 0),
                new Point(6, 0),
                new Point(6, -3),
            };
    }

    public boolean isInsideTheShape(Point point) {
        int i;
        int j;
        boolean result = false;
        for (i = 0, j = points.length - 1; i < points.length; j = i++) {
            if ((points[i].y > point.y) != (points[j].y > point.y) &&
                    (point.x < (points[j].x - points[i].x) * (point.y - points[i].y) / (points[j].y-points[i].y) + points[i].x)) {
                result = !result;
            }
        }
        return result;
    }
}
