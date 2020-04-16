package html;

public interface HtmlElement {
    HtmlElement setSubElement(HtmlElement htmlElement);
    HtmlElement setAttribute(String nameAttribute, String value);
    HtmlElement setInnerHtml(String innerHtml);
}
