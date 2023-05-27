package practiceProblems;
    import java.awt.*;
import java.util.Objects;
    public class LineComparisonCode {
        class point{
            private int x;
            private int y;
            public point(int x, int y) {
                this.x = x;
                this.y = y;
            }
            public int getX() {
                return x;
            }
            public int getY() {
                return y;
            }
            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Point point = (Point) o;
                return x == point.x &&
                        y == point.y;
            }
            @Override
            public int hashCode() {
                return Objects.hash(x, y);
            }
        }
        class Line {
            private Point point1;
            private Point point2;
            public Line(Point point1, Point point2) {
                this.point1 = point1;
                this.point2 = point2;
            }
            public double length() {
                int xDiff = (int) (point2.getX() - point1.getX());
                int yDiff = (int) (point2.getY() - point1.getY());
                return Math.sqrt(xDiff * xDiff + yDiff * yDiff);
            }
            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Line line = (Line) o;
                return point1.equals(line.point1) &&
                        point2.equals(line.point2);
            }
            @Override
            public int hashCode() {
                return Objects.hash(point1, point2);
            }
        }
        public class Main {
            public void main(String[] args) {
                Point point1 = new Point(1, 2);
                Point point2 = new Point(4, 5);
                Line line1 = new Line(point1, point2);
                System.out.println("Length of line1 is: " + line1.length());

                Point point3 = new Point(1, 2);
                Point point4 = new Point(4, 5);
                Line line2 = new Line(point3, point4);
                System.out.println("Are line1 and line2 equal: " + line1.equals(line2));

                Point point5 = new Point(1, 2);
                Point point6 = new Point(6, 7);
                Line line3 = new Line(point5, point6);
                int compareResult = Double.compare(line1.length(), line3.length());
                if (compareResult == 0) {
                    System.out.println("Line1 and Line3 have the same length");
                } else if (compareResult < 0) {
                    System.out.println("Line1 is shorter than Line3");
                } else {
                    System.out.println("Line1 is longer than Line3");
                }
            }
        }
    }