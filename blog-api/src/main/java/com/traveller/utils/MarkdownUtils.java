package com.traveller.utils;

import org.commonmark.node.Node;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;

/**
 * @author traveller
 * @date 2024/04/18
 * 后端将markdown转化位html
 */
public class MarkdownUtils {

    public static String ParseMarkdown(String markdown) {
        Parser parser = Parser.builder().build();
        Node document = parser.parse(markdown);
        HtmlRenderer renderer = HtmlRenderer.builder().build();
        String htmltext = renderer.render(document);// "<p>This is <em>Markdown</em></p>\n"
        return htmltext;
    }
}
