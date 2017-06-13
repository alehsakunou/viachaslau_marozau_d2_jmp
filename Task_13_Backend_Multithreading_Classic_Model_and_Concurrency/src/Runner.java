import com.epam.jmp.lambdas.beans.MirrorPoint;
import com.epam.jmp.lambdas.beans.Point;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Runner
{
    public static void main(String... args)
    {
        final int elementNum = 10;
        List<Point> points = generatePoints(elementNum);
        points.stream()
            .forEach(System.out::println);
        Function<Point, MirrorPoint> mapToMirrorPoint = e -> new MirrorPoint(e);
        List<MirrorPoint> mirrorPoints = points.stream()
            .map(mapToMirrorPoint)
            .filter(e -> e.getX() >= 3)
            .filter(e -> e.getY() >= 3)
            .distinct().collect(Collectors.toList());
        System.out.println();
        mirrorPoints.stream()
            .forEach(System.out::println);
        System.out.println();
        System.out.println(mirrorPoints.stream().mapToInt(e -> e.getX() + e.getY()).sum());
        System.out.println();
        System.out.println(mirrorPoints.stream().mapToInt(e -> e.getX() * e.getY()).reduce((s1, s2) -> s1 * s2).getAsInt());

        Stream.of((int a, int b) -> {1,2};);
    }

    private static List<Point> generatePoints(int elementNum)
    {
        List<Point> points = new ArrayList<>(elementNum);
        for (int i = 0; i < elementNum; i++)
        {
            points.add(generatePoint());
        }
        IntStream.range(0,3).forEach(a -> System.out.println("С Днём Рождения user " + a + " (party) "));
        return points;
    }

    private static Point generatePoint()
    {
        int x = (int) (100 * Math.random());
        int y = (int) (100 * Math.random());
        return new Point(x, y);
    }
}
