package html;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Tag implements HtmlElement {
    private int level = 0;

    private String innerHtml;

    protected String name;
    protected List<HtmlElement> listSubElement;
    protected HashMap<String, String> listAttribute;

    public Tag(String name) {
        this.name = name;
        listSubElement = new ArrayList<>();
        listAttribute = new HashMap<>();
    }

    @Override
    public HtmlElement setSubElement(HtmlElement htmlElement) {
        listSubElement.add(htmlElement);
        return this;
    }

    @Override
    public HtmlElement setAttribute(String nameAttribute, String value) {
        listAttribute.put(nameAttribute, value);
        return this;
    }

    @Override
    public HtmlElement setInnerHtml(String innerHtml) {
        this.innerHtml = innerHtml;
        return this;
    }

    public String getInnerHtml() {
        return innerHtml;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }
}
