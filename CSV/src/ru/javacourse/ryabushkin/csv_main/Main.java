package ru.javacourse.ryabushkin.csv_main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static StringBuilder scanFileData(String path) throws FileNotFoundException {
        StringBuilder strings = new StringBuilder();
        String bufferLine;

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            while ((bufferLine = reader.readLine()) != null) {
                strings.append(bufferLine).append(System.lineSeparator());
            }
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return strings;
    }

    public static void main(String[] args) throws FileNotFoundException {
        String path = "C:\\Users\\poshelwon\\IdeaProjects\\JavaOopCourse2022\\CSV\\src\\ru\\javacourse\\csv";

        StringBuilder inputStrings = scanFileData(path);

        String separator = ",";
        String quote = "\"";
       // String specialSymbol1 = "<";
       // String specialSymbol2 = ">";
       // String specialSymbol3 = "&";
        String specialSymbol4 = "\"\"";
        String specialSymbol5 = "\r\n";
        boolean quotes = false;

        StringBuilder outputStrings = new StringBuilder();

        outputStrings.append("<table><tr><td>");

        while (!inputStrings.isEmpty()) {
            if (inputStrings.indexOf(quote) < inputStrings.indexOf(separator) || inputStrings.indexOf(separator) == -1) {
                if (inputStrings.indexOf(quote) != inputStrings.indexOf(specialSymbol4) && !quotes) {
                    if (inputStrings.substring(0, inputStrings.indexOf(quote)).contains(specialSymbol5)) {
                        inputStrings.replace(inputStrings.indexOf(specialSymbol5), inputStrings.indexOf(specialSymbol5) + 2
                                , "</td></tr><tr>");
                    }

                    quotes = true;

                    inputStrings.delete(0, inputStrings.indexOf(quote) + 1);
                } else if (inputStrings.indexOf(quote) != inputStrings.indexOf(specialSymbol4) && quotes) {
                    if (inputStrings.substring(0, inputStrings.indexOf(quote)).contains(specialSymbol5)) {
                        inputStrings.replace(inputStrings.indexOf(specialSymbol5), inputStrings.indexOf(specialSymbol5) + 2
                                , "<br/>");
                    }
                    quotes = false;

                    outputStrings.append(inputStrings.substring(0, inputStrings.indexOf(quote)));
                    inputStrings.delete(0, inputStrings.indexOf(quote) + 1);
                } else {
                    outputStrings.append(inputStrings.substring(0, inputStrings.indexOf(quote) + 1));
                    inputStrings.delete(0, inputStrings.indexOf(specialSymbol4) + 2);
                }
            } else if (!quotes && inputStrings.substring(0).contains(separator)){
                if (inputStrings.substring(0, inputStrings.indexOf(separator)).contains(specialSymbol5)) {
                    inputStrings.replace(inputStrings.indexOf(specialSymbol5), inputStrings.indexOf(specialSymbol5) + 2
                            , "</td></tr><tr><td>");
                }

                outputStrings.append(inputStrings.substring(0, inputStrings.indexOf(separator))).append("</td><td>");
                inputStrings.delete(0, inputStrings.indexOf(separator) + 1);
            } else if (inputStrings.indexOf(quote) != inputStrings.indexOf(specialSymbol4) && quotes) {
                if (inputStrings.substring(0, inputStrings.indexOf(quote)).contains(specialSymbol5)) {
                    inputStrings.replace(inputStrings.indexOf(specialSymbol5), inputStrings.indexOf(specialSymbol5) + 2
                            , "<br/>");
                }

                quotes = false;

                outputStrings.append(inputStrings.substring(0, inputStrings.indexOf(quote)));
                inputStrings.delete(0, inputStrings.indexOf(quote) + 1);
            }
        }

        outputStrings.append("</td></tr></table>");

        System.out.println(outputStrings);
    }
}