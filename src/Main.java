import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Добро пожаловать вы попали в ваш фитнес-трекер!");

        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker(scanner);
        int exit = 1;

        while (exit == 1) {
            printMenu();
            int actionNumber = scanner.nextInt();
            scanner.nextLine();

            switch (actionNumber) {
                case 1:
                    stepTracker.addNewNumberStepsPerDay(); //Добавляем пройденные шаги за день
                    break;
                case 2:
                    stepTracker.changeStepGoal(); //Изменяем норму шагов
                    break;
                case 3:
                    stepTracker.printStatistic(); //Печатаем статистику за месяц
                    break;
                case 0:
                    System.out.println("Программа завершена");
                    exit = 0;
                    scanner.close();
                    break;
                default:
                    System.out.println("Неизвестная команда.");
                    break;
            }
        }
    }

    public static void printMenu() {
        System.out.println("Выберете номер нужного действие:");
        System.out.println("1. Ввести количество шагов за определённый день");
        System.out.println("2. Изменить цель по количеству шагов в день");
        System.out.println("3. Напечатать статистику за определённый месяц");
        System.out.println("0. Выйти из приложения");
    }
}
