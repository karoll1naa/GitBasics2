package Tests;

import org.example.Main;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HTMLtest {

    @Test
    public void testConvertToHtml_BoldText() {
        String expectedHtmlText = "<b>This is bold text</b>";
        String markdownText = "**This is bold text**";
        assertEquals(expectedHtmlText, Main.convertMarkdownToHtml(markdownText, false));
    }

    @Test
    public void testConvertToHtml_ItalicText() {
        String markdownText = "_This is italic text_";
        String expectedHtmlText = "<i>This is italic text</i>";
        assertEquals(expectedHtmlText, Main.convertMarkdownToHtml(markdownText, false));
    }
}