package ParseStringUtil;


import DateTimeUtils.DateUtilsJava7;
import DateTimeUtils.DateUtilsJava8;

import java.text.ParseException;
import java.util.List;


/**
 * Вспомогательный класс для StringToDatesParser
 *
 * @author Mikhail Yarulin
 * @version 1.1
 */
public class StringToDateParseHelper {


    StringToDatesParser parser = new StringToDatesParser();

    DateUtilsJava7 dateUtils7 = new DateUtilsJava7();
    DateUtilsJava8 dateUtils8 = new DateUtilsJava8();


    /**
     * Метод обрабатывает входящий текст, обращаясь к утилитам Date
     *
     * @param text считаный текст
     * @return результат работы метода в формате StringBuilder
     * @throws ParseException неправильный формат строки.
     */
    public String textToFileDate(String text) throws ParseException {
        StringBuilder resultToFile = new StringBuilder();

        List<ParseStringToDateResult> resultDates = parser.parse(text);

        for (ParseStringToDateResult resultDate : resultDates) {

            resultToFile.append("Using Java 7\n");
            int[] daysOfMonthJava7 = dateUtils7.daysOfTheMonth(resultDate.day(), resultDate.month(), resultDate.year());
            resultToFile.append(getAllDaysForMonth(resultDate, daysOfMonthJava7));

            resultToFile.append("Using Java 8\n");
            int[] daysOfMonthJava8 = dateUtils8.daysOfTheMonth(resultDate.day(), resultDate.month(), resultDate.year());
            resultToFile.append(getAllDaysForMonth(resultDate, daysOfMonthJava8));
        }
        return resultToFile.toString();
    }

    /**
     * Метод вспомогательный
     *
     * @param resultDate  строка с датами.
     * @param daysOfMonth обработтаный масив дат
     * @return результат всех дней
     */
    private String getAllDaysForMonth(ParseStringToDateResult resultDate, int[] daysOfMonth) {
        StringBuilder resultStringBuilder = new StringBuilder();
        for (int dayOfMonth : daysOfMonth) {
            String str = (dayOfMonth + " " + resultDate.getMonth() + " " + resultDate.getYear());
            resultStringBuilder.append(str).append("\n");
        }
        return resultStringBuilder.toString();
    }
}
