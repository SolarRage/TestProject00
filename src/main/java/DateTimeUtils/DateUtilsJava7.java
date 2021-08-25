package DateTimeUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static java.util.Calendar.*;

/**
 * Класс работы с датой Java 7-
 *
 * @author Mikhail Yarulin
 * @version 1.1
 */
public class DateUtilsJava7 {


    /**
     * Метод переобразует строку дат в формат Date и создает массив
     * всех указаных дней недели в указонном месяцеб годе.
     *
     * @param day   день недели, полученный из текста
     * @param month месяц, полученный из текста
     * @param year  год, полученный из текста
     * @return возвращает массив дат.
     * @throws ParseException неправильный формат строки.
     */
    public int[] daysOfTheMonth(String day, String month, String year) throws ParseException {
        String stringDate = (day + ", " + month + " " + year);
        DateFormat format = new SimpleDateFormat("EEE, MMMM yyyy", Locale.ENGLISH);
        Date date = format.parse(stringDate);

        List<Integer> daysOfMonth = new ArrayList<>();

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        int currentMonth = calendar.get(MONTH);
        int currentDayOfWeek = calendar.get(DAY_OF_WEEK);

        calendar.set(DAY_OF_MONTH, 1);

        while (calendar.get(MONTH) == currentMonth) {
            if (calendar.get(DAY_OF_WEEK) == currentDayOfWeek) {
                daysOfMonth.add(calendar.get(DAY_OF_MONTH));
            }
            calendar.add(DAY_OF_MONTH, 1);
        }
        return daysOfMonth.stream().mapToInt(Integer::intValue).toArray();
    }
}