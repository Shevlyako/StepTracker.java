import java.util.Scanner;

class StepTracker {
    Scanner scanner = new Scanner(System.in);
    MonthData[] monthToData = new MonthData[12];
    int goalByStepsPerDay = 10000;

    StepTracker(Scanner scan) { //Создаем конструктор
        scanner = scan;

        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }

    void addNewNumberStepsPerDay() { // Метод добавляющий шаги в нужный день
        System.out.println("Введите номер месяца");
        int mounth = scanner.nextInt();
        if (mounth < 1 || mounth > 12) {
            System.out.println("Месяц должен быть больше 0 и меньше 12");
            return;
        }

        System.out.println("Введите день от 1 до 30 (включительно)");
        int day = scanner.nextInt();
        if (day < 1 || day > 30) {
            System.out.println("День должен быть больше 0 и меньше 30");
            return;
        }

        System.out.println("Введите количество шагов");
        int step = scanner.nextInt();
        if (step < 1) {
            System.out.println("Колличество шагов должно быть больше 0");
            return;
        }

        MonthData monthData = monthToData[mounth - 1];
        monthData.days[day - 1] = step;
        System.out.println("Вы добавили: " + monthData.days[day - 1] + " шагов. В " + day + "-й день. Месяца " + mounth);
    }

    void changeStepGoal() { // Метод изменяющий цель шагов
        System.out.println("Введите новую цель шагов");
        int newGoalByStepsPerDay = scanner.nextInt();
        if (newGoalByStepsPerDay < 1) {
            System.out.println("Цель шагов должна быть больше 0");
            return;
        } else {
            goalByStepsPerDay = newGoalByStepsPerDay;
            System.out.println("Ваша новая цель шагов:" + goalByStepsPerDay);
        }
    }

    void printStatistic() { // Метод печатающий статистику
        System.out.println("Введите месяц за который хотите получить статистику");
        int statMounth = scanner.nextInt();
        if (statMounth < 1 || statMounth > 12) {
            System.out.println("Месяц должен быть больше 0 и меньше 12");
            return;
        }
        monthToData[statMounth - 1].printDaysAndStepsFromMonth();
        System.out.println("Сумма пройденных шагов за месяц: " + monthToData[statMounth - 1].sumStepsFromMonth());
        System.out.println("Максимальное колличество шагов пройденной в данном месяце: "
                + monthToData[statMounth - 1].maxSteps());
        System.out.println("Среднее колличество шагов пройденное в этом месяце: "
                + monthToData[statMounth - 1].averageStepsFromMounth());
        System.out.println("Колличество километров пройденное в этом месяце: "
                + Converter.convertToKm(monthToData[statMounth - 1].sumStepsFromMonth()));
        System.out.println("Колличество каллорий сожженых в этом месяце: "
                + Converter.convertStepsToKilocalories(monthToData[statMounth - 1].sumStepsFromMonth()));
        System.out.println("Лучшая серия дней в которых вы прошли большее или равное норме колличество шагов: "
                + monthToData[statMounth - 1].bestSeries(goalByStepsPerDay));
    }
}

