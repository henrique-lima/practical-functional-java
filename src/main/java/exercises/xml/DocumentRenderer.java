package exercises.xml;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import xml.model.DocTypeVisitor;
import xml.model.Document;

import javax.print.Doc;

public class DocumentRenderer {

    public String render(Document document) {
        // TODO - return the full document with a proper XML header, doctype, and rendered root element
        //return document.docType().get().dtdLocation();
        return Stream.of(renderXmlHeader(), renderDocType(document), renderRootElement(document)).reduce(Stream::concat).orElseGet(Stream::empty)
                .collect(Collectors.joining(""));
    }

    private Stream<String> renderXmlHeader() {
        return Stream.of("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
    }

    private Stream<String> renderDocType(Document document) {
        return Stream.of("<!DOCTYPE " + document.rootElement().name() + " "
                + (document.docType().isPresent() ? document.docType().get().accept(new DocTypeRenderer()) + ">\n" : ">\n"));
    }

    private Stream<String> renderRootElement(Document document) {
        return document.rootElement().accept(new ElementRenderer());
//        return Stream.of(Stream.of("<" + document.rootElement().name() + " "),
//                Stream.of(new AttributeRenderer().renderAttributes(document.rootElement().attributes().get())), Stream.of("/>"))
//                .reduce(Stream::concat).orElseGet(Stream::empty);
    }
}
