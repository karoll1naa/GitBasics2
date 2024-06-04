package org.example;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        String inputFile = args[0];
        String outputFile = args[1];
        String format = "Html";

        for (int i = 2; i < args.length; i++) {
            if (args[i].equals("--format")) {
                format = args[i + 1].toLowerCase();
                break;
            }
        }

        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        StringBuilder content = new StringBuilder();
        String line;
        boolean inPreformatted = false;

        if (format.equals("Html")) {
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("```")) {
                    if (inPreformatted) {
                        content.append("</pre>");
                        inPreformatted = false;
                    } else {
                        content.append("<pre>");
                        inPreformatted = true;
                    }
                } else if (line.trim().isEmpty()) {
                    if (!inPreformatted && !content.toString().endsWith("</p>")) {
                        content.append("</p><p>");
                    }
                } else {
                    if (!inPreformatted && !content.toString().endsWith("<p>")) {
                        content.append("<p>");
                    }
                    String convertedLine = convertMarkdownToHtml(line, inPreformatted);
                    content.append(convertedLine);
                }
            }
            if (inPreformatted) {
                content.append("</pre>");
            } else if (!content.toString().endsWith("</p>")) {
                content.append("</p>");
            }

        } else if (format.equals("Ansi")) {
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("```")) {
                    if (inPreformatted) {
                        inPreformatted = false;
                    } else {
                        inPreformatted = true;
                    }
                } else if (!inPreformatted && !line.trim().isEmpty()) {
                    String convertedLine = convertMarkdownToAnsi(line, false);
                    content.append(convertedLine);
                } else if (inPreformatted) {
                    content.append(line).append("\n");
                }
            }
        }


        String Result = content.toString().replaceAll("\n", "");

        if (outputFile.equals("-")) {
            System.out.print(Result);
        } else {
            try (FileWriter writer = new FileWriter(outputFile)) {
                writer.write(Result);
            }
            System.out.println("The format text was written.");
        }

    }

    public static String convertMarkdownToHtml(String markdown, boolean inPreformatted) {
        if (inPreformatted) {
            return markdown;
        }
        markdown = convertBoldAndItalicToHtml(markdown);
        markdown = convertMonospacedToHtml(markdown);
        return markdown;
    }

    private static String convertBoldAndItalicToHtml(String markdown) {
        markdown = markdown.replaceAll("\\*\\*(.+?)\\*\\*", "<b>$1</b>");
        markdown = markdown.replaceAll("_(.+?)_", "<i>$1</i>");
        return markdown;
    }

    private static String convertMonospacedToHtml(String markdown) {
        return markdown.replaceAll("`(.+?)`", "<tt>$1</tt>");
    }

    private static String convertBoldAndItalicToAnsi(String markdown) {
        markdown = markdown.replaceAll("\\*\\*(.+?)\\*\\*", "\u001B[1m$1\u001B[22m");
        markdown = markdown.replaceAll("_(.+?)_", "\u001B[3m$1\u001B[23m");
        return markdown;
    }

    private static String convertMonospacedToAnsi(String markdown) {
        return markdown.replaceAll("`(.+?)`", "\u001B[7m$1\u001B[27m");
    }

    public static String convertMarkdownToAnsi(String markdown, boolean inPreformatted) {
        if (inPreformatted) {
            return markdown;
        }
        markdown = convertBoldAndItalicToAnsi(markdown);
        markdown = convertMonospacedToAnsi(markdown);
        return markdown;
    }
}