package exercises.xml;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import xml.model.*;

public class ElementRenderer implements ElementVisitor<Stream<String>> {

    @Override
    public Stream<String> visit(TextElement element) {
        // TODO... return a Stream with just the content of the element
        System.out.println("visiting text element");
        return Stream.of(element.content());
    }

    @Override
    public Stream<String> visit(XmlElement element) {
        // TODO - return a stream with just the element and attributes: <foo name="fred"/>
        //return Stream.of()
        System.out.println("visiting xml element");
        return this.renderXmlElement(element, true);
    }

    //double dispatch!
    @Override
    public Stream<String> visit(XmlElementWithChildren element) {
        // TODO - return a stream with the open tag and attributes, rendered children (indented 2 spaces)
        // and the closing tag
        return Stream.of(this.renderXmlElement(element, element.children().count() == 0),
                element.children().map(elem -> " " + elem.accept(this).collect(Collectors.joining("\n"))),
                Stream.of(" </" + element.name() + ">")).reduce(Stream::concat).orElseGet(Stream::empty);
    }

    private Stream<String> renderXmlElement(XmlElement element, boolean empty) {
        return Stream.of("<" + element.name()
                + (element.attributes().isPresent() ? " " : "")
                + new AttributeRenderer().renderAttributes(element.attributes().orElse(Attributes.of()))
                + (empty ? "/" : "") + ">");
    }
}
