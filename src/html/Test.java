package html;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Test {

    public static void main(String[] args) {
        Tag htmlTag = new Tag("html");
        htmlTag.setAttribute("lang", "vi");

        Tag header = new Tag("header");
        htmlTag.setSubElement(header).setSubElement(new Tag("body"));

        Tag meta = new Tag("title");

        meta.setInnerHtml("Đây là web test");

        header.setSubElement(meta);


        HtmlCreator htmlCreator = new HtmlCreator(htmlTag);
        System.out.println(htmlCreator.toHtmlText());

        File file = new File("HtmlFolder//myhtml.html");
        System.out.println(file.getAbsoluteFile());
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write(htmlCreator.toHtmlText().toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
