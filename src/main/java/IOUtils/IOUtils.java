package IOUtils;

import java.io.*;
import java.nio.file.FileSystemAlreadyExistsException;

/**
 * Класс чтения и записи файлов технологией Java IO
 *
 * @author Mikhail Yarulin
 * @version 1.1
 */

public class IOUtils {

    /**
     * Метод считывает текстовый файл технологией IO.
     *
     * @param fileName файл, который считываем
     * @return возвращаем результат считаного текста StringBilder.
     */
    public String readFromInputStream(String fileName) {
        StringBuilder resultStringBuilder = new StringBuilder();

        try (InputStream inputStream = new FileInputStream(fileName);
             BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = br.readLine()) != null) {
                resultStringBuilder.append(line).append("\n");
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return resultStringBuilder.toString();
    }

    /**
     * Метод записывает текст в файл.
     *
     * @param fileAbsolutePath Файл, в который записываем
     * @param text             Текст для записи
     */
    public void writeToFile(String fileAbsolutePath, String text) {
        File f = new File(fileAbsolutePath);
        //Если файл с таким именем уже существует, пробрасывает исключение
        if (f.exists()) {
            throw new FileSystemAlreadyExistsException();
        }//записывайм в файл через try with res
        try (FileWriter out = new FileWriter(f)) {
            out.write(text);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}



