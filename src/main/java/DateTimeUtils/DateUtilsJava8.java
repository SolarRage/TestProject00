package DateTimeUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс работы с датой Java 8+
 *
 * @author Mikhail Yarulin
 * @version 1.1
 */
public class DateUtilsJava8 {

    /**
     * @param
     * @return
     */
    public int[] daysOfTheMonth(String day, String month, String year) {
        List<Integer> daysOfMonth = new ArrayList<>();
        String dateText = (day + ", " + month + " " + year);


        return daysOfMonth.stream().mapToInt(Integer::intValue).toArray();
    }
}
