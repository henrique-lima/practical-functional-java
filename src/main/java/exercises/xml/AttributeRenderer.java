package exercises.xml;

import xml.model.Attribute;
import xml.model.Attributes;

import java.util.stream.Collectors;

public class AttributeRenderer {
    public String renderAttribute(Attribute attribute) {
        // TODO - render a single attribute: name="value"
        return new StringBuilder(attribute.name()).append("=\"")
                .append(attribute.value()).append("\"")
                .toString();
    }
    
    public String renderAttributes(Attributes attributes) {
        // TODO...attributes in alphabetical order separated with a single space
        return attributes.attributes()
                .sorted().map(this::renderAttribute)
                .collect(Collectors.joining(" "));
    }
}
