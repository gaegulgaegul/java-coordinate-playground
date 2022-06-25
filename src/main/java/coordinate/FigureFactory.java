package coordinate;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FigureFactory implements FigureCreator {

    private static Map<Integer, Class<? extends Figure>> factory = new HashMap<>();

    static {
        factory.put(Line.LINE_POINT_SIZE, Line.class);
        factory.put(Triangle.TRIANGLE_POINT_SIZE, Triangle.class);
        factory.put(Rectangle.RECTANGLE_POINT_SIZE, Rectangle.class);
    }

    @Override
    public Figure create(List<Point> points) {
        Class<? extends Figure> figureClass = factory.get(points.size());
        if (figureClass == null) {
            throw new IllegalArgumentException("유효하지 않은 도형입니다.");
        }

        return newInstance(points, figureClass);

    }

    private Figure newInstance(List<Point> points, Class<? extends Figure> figureClass) {
        try {
            return figureClass.getConstructor(List.class).newInstance(points);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            throw new IllegalArgumentException("List 타입의 매개변수를 가지는 생성자 메서드가 없습니다.");
        } catch (InvocationTargetException | InstantiationException | IllegalAccessException e) {
            throw new IllegalArgumentException("새로운 인스턴스를 생성할 수 없습니다.");
        }
    }
}
