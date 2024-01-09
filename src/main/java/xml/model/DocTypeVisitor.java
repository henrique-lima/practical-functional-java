package xml.model;

//doesn't it violate principle I of SOLID?
public interface DocTypeVisitor<R> {
    R visit(PublicDocType doctype);
    R visit(SystemDocType doctype);
}
