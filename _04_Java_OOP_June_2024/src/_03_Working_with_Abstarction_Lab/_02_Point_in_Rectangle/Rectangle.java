package _03_Working_with_Abstarction_Lab._02_Point_in_Rectangle;

public class Rectangle {

    private final Point pointBottomLeft;
    private final Point pointTopRight;

    public Rectangle(Point pointBottomLeft, Point pointTopRight) {
        this.pointBottomLeft = pointBottomLeft;
        this.pointTopRight = pointTopRight;
    }

    public boolean contains(Point point) {

        return point.x() >= pointBottomLeft.x() && point.x() <= pointTopRight.x() &&
                point.y() >= pointBottomLeft.y() && point.y() <= pointTopRight.y();
    }

}
