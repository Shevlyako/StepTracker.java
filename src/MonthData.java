public class MonthData {
    int[] days = new int[30];

    public void printDaysAndStepsFromMonth() { //Печать шагов за каждый день
        for (int i = 0; i < days.length; i++) {
            System.out.println((i + 1) + " День: " + days[i]);
        }
    }

    public int sumStepsFromMonth() { //Возврат суммы шагов за месяц
        int sumStep = 0;
        for (int i = 0; i < days.length; i++) {
            sumStep += days[i];
        }
        return sumStep;
    }

    public int maxSteps() { // Возврат максимального колличество шагов за день
        int maxStep = 0;
        for (int i = 0; i < days.length; i++) {
            if (days[i] > maxStep) {
                maxStep = days[i];
            }
        }
        return maxStep;
    }

    public int bestSeries(int goalByStepsPerDay) { // возврат лучшей серии больше нормы
        int currentSeries = 0;
        int finalSeries = 0;
        for (int i = 0; i < days.length; i++) {
            if (days[i] >= goalByStepsPerDay) {
                currentSeries++;
            } else if (currentSeries > finalSeries) {
                finalSeries = currentSeries;
                currentSeries = 0;
            } else {
                currentSeries = 0;
            }
        }
        return finalSeries;
    }

    public int averageStepsFromMounth(){ //Возврат среднего колличества шагов в месяце
        return sumStepsFromMonth()/ days.length;
    }
}
