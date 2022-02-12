package my.first.code;

public class Game {

    public static boolean trafficGreenLight = false;

    public static void printDelim(String var) {  // выводится вариант фильтра
        System.out.println("---------------------------------");
        System.out.println(var);
    }

    public static int moves(int[] speeds) { // расчет количества выбывающих
        int quantityLosers = 0;
        if (trafficGreenLight == false) {
            for (int speed : speeds) {
                if (speed != 0) {
                    quantityLosers++;
                }
            }
        }
        return quantityLosers;
    }

    public static int[] losers(int[] speeds) { // формирование списка скоростей выбывающих
        int quantityLosers = moves(speeds);
        int[] quantitySpeedLosers = new int[quantityLosers];
        int i = 0;
        if (quantityLosers != 0) {
            for (int speed : speeds) {
                if (speed != 0) {
                    quantitySpeedLosers[i] = speed;
                    i++;
                }
            }
        }
        return quantitySpeedLosers;
    }

    public static int[] winners(int[] speeds) { // формирование списка скоростей победителей
        int[] quantitySpeedWinners;
        if (trafficGreenLight == true) {
            quantitySpeedWinners = speeds;
        } else {
            int quantityWinners = 0;
            int i = 0;
            for (int speed : speeds) {
                if (speed == 0) {
                    quantityWinners++;
                    i++;
                }
            }
            quantitySpeedWinners = new int[quantityWinners];
            i = 0;
            if (quantityWinners != 0) {
                for (int speed : speeds) {
                    if (speed == 0) {
                        quantitySpeedWinners[i] = speed;
                        i++;
                    }
                }
            }
        }
        return quantitySpeedWinners;
    }
}