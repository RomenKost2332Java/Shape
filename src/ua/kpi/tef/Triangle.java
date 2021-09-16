package ua.kpi.tef;

public class Triangle extends Shape {
    private Point firstPoint;
    private Point secondPoint;
    private Point thirdPoint;

    public Triangle(Point firstPoint, Point secondPoint, Point thirdPoint) throws IllegalArgumentException {
        this.firstPoint = firstPoint;
        this.secondPoint = secondPoint;
        this.thirdPoint = thirdPoint;
        checkPoints();
    }

    public Triangle(double x1, double y1, double x2, double y2, double x3, double y3) throws IllegalArgumentException {
        this(new Point(x1, y1), new Point(x2, y2), new Point(x3, y3));
    }

    private void checkPoints() throws IllegalArgumentException{
        double distance1 = distance(firstPoint, secondPoint);
        double distance2 = distance(firstPoint, thirdPoint);
        double distance3 = distance(secondPoint, thirdPoint);
        if (distance1 + distance2 <= distance3
                || distance1 + distance3 <= distance2
                || distance2 + distance3 <= distance1
        ){
            throw new IllegalArgumentException();
        }

    }

    private double distance(Point point1, Point point2){
        return Math.sqrt(
                Math.pow(point1.getX() - point2.getX(), 2)
                + Math.pow(point1.getY() - point2.getY(), 2)
        );
    }

    @Override
    public double square() {
        double distance1 = distance(firstPoint, secondPoint);
        double distance2 = distance(firstPoint, thirdPoint);
        double distance3 = distance(secondPoint, thirdPoint);

        double semiPerimeter = perimeter()/2;

        return Math.sqrt(semiPerimeter
                * (semiPerimeter - distance2)
                * (semiPerimeter - distance3)
                * (semiPerimeter - distance1)
        );
    }

    @Override
    public double perimeter() {
        double distance1 = distance(firstPoint, secondPoint);
        double distance2 = distance(firstPoint, thirdPoint);
        double distance3 = distance(secondPoint, thirdPoint);

        return distance1 + distance2 + distance3;
    }

    @Override
    public void move(double dx, double dy) {
        firstPoint.setX(dx + firstPoint.getX());
        firstPoint.setY(dy + firstPoint.getY());

        secondPoint.setX(dx + secondPoint.getX());
        secondPoint.setY(dy + secondPoint.getY());

        thirdPoint.setX(dx + thirdPoint.getX());
        thirdPoint.setY(dy + thirdPoint.getY());
    }
}
