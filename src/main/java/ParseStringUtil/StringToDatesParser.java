package ParseStringUtil;


import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.regex.Pattern.CASE_INSENSITIVE;

/**
 * Класс получает из строки дату.
 *
 * @author Mikhail Yarulin
 * @version 1.1
 */
public class StringToDatesParser {

    private static final String PATTERN_DAY = "(sun(?:day)?|mon(?:day)?|tue(?:sday)?|wed(?:nesday)?|thu(?:rsday)?|fri(?:day)?|sat(?:urday)?)";
    private static final String PATTERN_MONTH = "(Jan(?:uary)?|Feb(?:ruary)?|Mar(?:ch)?|Apr(?:il)?|May|June?|July?|Aug(?:ust)?|Sep(?:tember)?|Oct(?:ober)?|Nov(?:ember)?|Dec(?:ember)?)";
    private static final String PATTERN_YEAR = "(?:19|20)[0-9]{2}";

    /**
     * Метод получает List с всеми считаными датами.
     *
     * @param text считаный текст
     * @return List с всеми считаными датами
     */
    public List<ParseStringToDateResult> parse(String text) {
        List<ParseStringToDateResult> resultList = new ArrayList<>();

        List<String> years = getYearFromString(text);
        List<String> months = getMonthFromString(text);
        List<String> days = getDayFromString(text);

        for (int i = 0; i < years.size(); i++) {
            resultList.add(new ParseStringToDateResult(years.get(i), months.get(i), days.get(i)));
        }
        return resultList;
    }

    /**
     * Метод получает день недели через регулярное выражение
     *
     * @param text считаный текст
     * @return коллекцию с получеными датами
     */
    private ArrayList<String> getDayFromString(String text) {
        ArrayList<String> days = new ArrayList<>();
        Pattern pattern = Pattern.compile(PATTERN_DAY, CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            days.add(matcher.group());
        }
        return days;
    }

    /**
     * Метод получает месяц, записанный в текстовом формате, через регулярное выражение
     *
     * @param text считаный текст
     * @return коллекцию с получеными датами
     */
    private ArrayList<String> getMonthFromString(String text) {
        ArrayList<String> month = new ArrayList<>();
        Pattern pattern = Pattern.compile(PATTERN_MONTH, CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            month.add(matcher.group());
        }
        return month;
    }

    /**
     * Метод получает год, записанный в цифровом формате, через регулярное выражение
     *
     * @param text считаный текст
     * @return коллекцию с получеными датами
     */
    private ArrayList<String> getYearFromString(String text) {
        ArrayList<String> year = new ArrayList<>();
        Pattern pattern = Pattern.compile(PATTERN_YEAR);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            year.add(matcher.group());
        }
        return year;
    }
}

