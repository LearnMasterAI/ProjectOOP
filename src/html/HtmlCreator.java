package html;

public class HtmlCreator {

    private StringBuilder stringBuilder;
    private Tag tag;
    private String padding;

    public HtmlCreator(Tag tag) {
        this.tag = tag;
        stringBuilder = new StringBuilder();
        padding = manyTab(tag.getLevel());
    }

    public StringBuilder toHtmlText() {
        createOpenTag();
        createBodyTag();
        createCloseTag();
        return stringBuilder;
    }

    private void createOpenTag() {
        stringBuilder.append(padding + "<" + tag.name);
        for (String key : tag.listAttribute.keySet()) {
            stringBuilder.append(" " + key + "=" + "\"" + tag.listAttribute.get(key) + "\"");
        }
        stringBuilder.append(">");
    }

    private void createBodyTag() {
        if (tag.getInnerHtml() != null) stringBuilder.append("\n\t" + padding + tag.getInnerHtml());
        for (HtmlElement key : tag.listSubElement) {
            stringBuilder.append("\n");
            Tag tag = (Tag) key;
            tag.setLevel(this.tag.getLevel() + 1);
            stringBuilder.append(new HtmlCreator((Tag) key).toHtmlText());
        }
    }

    private void createCloseTag() {
        stringBuilder.append("\n" + padding + "</" + tag.name + ">");
    }

    private String manyTab(int level) {
        return new String(new char[level]).replace("\0", "\t");
    }
}
