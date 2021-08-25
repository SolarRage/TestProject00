package ParseStringUtil;


/**
 * Неизменяемый класс. Только геттеры.
 *
 * @author Mikhail Yarulin
 * @version 1.1
 */
public record ParseStringToDateResult(String year, String month, String day) {

    public String getYear() {
        return year;
    }

    public String getMonth() {
        return month;
    }

    public String getDay() {
        return day;
    }
}
