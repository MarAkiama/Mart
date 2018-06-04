package bellmanfordsp;
public class DrawUtilities {

    public static void drawArrow(Coordinate vertex, Coordinate neighborVertex, double padding, double arrowLength) {
        double arrowWidth = padding * 2;

        // Edges pointing up
        if (vertex.yCoordinate < neighborVertex.yCoordinate) {
            if (vertex.xCoordinate < neighborVertex.xCoordinate) {
                // Edge pointing diagonally up and right
                drawArrowLine(vertex.xCoordinate, vertex.yCoordinate + padding,
                        neighborVertex.xCoordinate, neighborVertex.yCoordinate - padding, arrowWidth, arrowLength);
            } else if (vertex.xCoordinate > neighborVertex.xCoordinate) {
                // Edge pointing diagonally up and left
                drawArrowLine(vertex.xCoordinate, vertex.yCoordinate + padding,
                        neighborVertex.xCoordinate, neighborVertex.yCoordinate - padding, arrowWidth, arrowLength);
            } else {
                // Edge pointing up
                drawArrowLine(vertex.xCoordinate, vertex.yCoordinate + padding * 2,
                        neighborVertex.xCoordinate, neighborVertex.yCoordinate - padding, arrowWidth, arrowLength);
            }
        } if (vertex.yCoordinate > neighborVertex.yCoordinate) {
            //Edges pointing down
            if (vertex.xCoordinate < neighborVertex.xCoordinate) {
                // Edge pointing diagonally down and right
                drawArrowLine(vertex.xCoordinate, vertex.yCoordinate - padding * 2,
                        neighborVertex.xCoordinate, neighborVertex.yCoordinate + padding * 4, arrowWidth, arrowLength);
            } else if (vertex.xCoordinate > neighborVertex.xCoordinate) {
                // Edge pointing diagonally down and left
                drawArrowLine(vertex.xCoordinate, vertex.yCoordinate - padding * 2,
                        neighborVertex.xCoordinate, neighborVertex.yCoordinate + padding * 4, arrowWidth, arrowLength);
            } else {
                // Edge pointing down
                drawArrowLine(vertex.xCoordinate, vertex.yCoordinate - padding * 2,
                        neighborVertex.xCoordinate, neighborVertex.yCoordinate + padding * 2, arrowWidth, arrowLength);
            }
        } else if (vertex.yCoordinate == neighborVertex.yCoordinate) {
            // Horizontal edges
            if (vertex.xCoordinate < neighborVertex.xCoordinate) {
                // Edge pointing right
                drawArrowLine(vertex.xCoordinate + padding * 2, vertex.yCoordinate,
                        neighborVertex.xCoordinate - padding * 2, neighborVertex.yCoordinate, arrowWidth, arrowLength);
            } else if (vertex.xCoordinate > neighborVertex.xCoordinate) {
                // Edge pointing left
                drawArrowLine(vertex.xCoordinate - padding * 2, vertex.yCoordinate,
                        neighborVertex.xCoordinate + padding * 2, neighborVertex.yCoordinate, arrowWidth, arrowLength);
            }
        }
    }
    
    private static void drawArrowLine(double x1, double y1, double x2, double y2, double arrowWidth, double arrowHeight) {
        double xDistance = x2 - x1;
        double yDistance = y2 - y1;
        double distance = Math.sqrt(xDistance * xDistance + yDistance * yDistance);

        double xm = distance - arrowWidth;
        double xn = xm;
        double ym = arrowHeight;
        double yn = -arrowHeight;
        double x;

        double sin = yDistance / distance;
        double cos = xDistance / distance;

        x = xm * cos - ym * sin + x1;
        ym = xm * sin + ym * cos + y1;
        xm = x;

        x = xn * cos - yn * sin + x1;
        yn = xn * sin + yn * cos + y1;
        xn = x;

        double[] xPoints = {x2, xm, xn};
        double[] yPoints = {y2, ym, yn};

        StdDraw.line(x1, y1, x2, y2);
        StdDraw.filledPolygon(xPoints, yPoints);
    }

}