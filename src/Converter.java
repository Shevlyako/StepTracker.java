public class Converter {

    private Converter(){

    }

    static int convertToKm(int steps) { //Преобразуем колличество шагов в километры
        return (steps * 75) / 100000;
    }

    static int convertStepsToKilocalories(int steps) { //Преобразуем колличество шагов в Ккалории
        return (steps * 50) / 1000;
    }
}
