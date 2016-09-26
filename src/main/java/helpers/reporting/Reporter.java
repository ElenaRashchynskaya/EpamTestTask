package helpers.reporting;

import helpers.Random;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Reporter {

    private static List<Result> details;
    private static final String resultPlaceholder = "<!-- INSERT_RESULTS -->";
    private static final String templatePath = "data\\report_template.html";
    private static final String resultFolder = "tmp\\report\\";

    public Reporter() {
    }

    public static void initialize() {
        details = new ArrayList<Result>();
    }

    public static void pass(String email) {
        report(email, true);
    }

    public static void fail(String email, String reason) {
        report(email, false, reason);
    }

    public static void report(String email, Boolean result) {
        Result r = new Result(email, result);
        details.add(r);
    }

    public static void report(String email, Boolean result, String reason) {
        Result r = new Result(email, result, reason);
        details.add(r);
    }

    public static void writeResults() {
        try {
            String reportIn = new String(Files.readAllBytes(Paths.get(templatePath)));
            for (Result result : details) {
                reportIn = reportIn.replaceFirst(
                        resultPlaceholder,
                        "<tr title='" + (result.date.toString()) + "'>\n<td>" +
                                result.email +
                                "</td>\n<td>" +
                                (result.result ? "Passed" : "Failed") +
                                "</td>\n<td>" +
                                result.reason +
                                "</td>\n</tr>" +
                                resultPlaceholder
                );
            }


            String reportPath = resultFolder + "report_" + Random.getFormatDate() + ".html";
            Files.write(Paths.get(reportPath), reportIn.getBytes(), StandardOpenOption.CREATE);

        } catch (Exception e) {
            System.out.println("Error when writing report file:\n" + e.toString());
        }
    }
}