package yandex_leetcode.src.main.java.livecoding.special;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Reflection {
    public static void main(String[] args) {
        int[][] points0 = new int[][]{ //true
                {1,1},
                {-1,1},
                {0,0}
        };
        int[][] points1 = new int[][]{ //true
                {1,1},
                {-1,1},
                {0,0},
                {2,0},
                {-2,0},

        };
        int[][] points2 = new int[][]{ //false
                {1,1},
                {-1,1},
                {0,0},
                {2,0},
                {-2,0},
                {-1,-1}
        };
        System.out.println(isReflection(points0));
        System.out.println(isReflection(points1));
        System.out.println(isReflection(points2));
    }

    // points -> {0,0}, {1,1}, {-1,1} {2,0} false

    // строим вертикальную линию для проверки отображения точек относительно оси Y
    public static boolean isReflection(int[][] points) {
        if (points == null) {
            return false;
        }
        int xMin = Integer.MAX_VALUE;
        int xMax = Integer.MIN_VALUE;

        Set<List<Integer>> listSet = new HashSet<>();
        for (int[] point : points) { //обновим макс и мин из всех точек
          xMin = Math.min(xMin, point[0]);
          xMax = Math.max(xMax, point[0]);
          listSet.add(List.of(point[0], point[1])); //добавили точку в формате (x,y)
        }
        int sum = xMin - xMax; //для нахождения отображенных точек
        for (int[] point : points) { //лупой проверяем симметрия
            int reflect = sum - point[0]; //вычисляем x коорд. отраженной точки
           if (!listSet.contains(List.of(reflect, point[1]))) { //пров. есть ли отраженная точка с тем же Y
               return false;
           }
        }
        return true;
    }
}
