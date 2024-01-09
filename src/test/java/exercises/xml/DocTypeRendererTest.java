package exercises.xml;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Ignore;
import org.junit.Test;

import xml.model.PublicDocType;
import xml.model.SystemDocType;

@Ignore
public class DocTypeRendererTest {
    
    private static final String DTD_NAME = "-//Example//EN";
    private static final String DTD_LOCATION = "example.dtd";

    @Test
    public void testPublicDocType() {
        PublicDocType docType = new PublicDocType.Builder()
                .withDtdName(DTD_NAME)
                .withDtdLocation(DTD_LOCATION)
                .build();
        
        String dcType = docType.accept(new DocTypeRenderer());
        //TODO: error here!
        assertThat(dcType).isEqualTo("PUBLIC \"" + DTD_NAME + "\" \"" + DTD_LOCATION + "\"");
    }

    @Test
    public void testSystemDocType() {
        SystemDocType docType = SystemDocType.of(DTD_LOCATION);
        
        String dcType = docType.accept(new DocTypeRenderer());
        assertThat(dcType).isEqualTo("SYSTEM \"" + DTD_LOCATION + "\"");
    }
}
