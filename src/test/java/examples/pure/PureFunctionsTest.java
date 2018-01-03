package examples.pure;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import examples.immutable.ImmutablePerson;

public class PureFunctionsTest {

    @Test
    public void testPureFunction() {
        List<ImmutablePerson> allPeople = new ArrayList<>();
        allPeople.addAll(getTheFlintstones());
        allPeople.addAll(getTheRubbles());
        
        assertThat(allPeople.size()).isEqualTo(6);
        assertThat(allPeople.get(1).getFirstName()).isEqualTo("Wilma");
        assertThat(allPeople.get(4).getFirstName()).isEqualTo("Betty");
    }
    
    private List<ImmutablePerson> getTheFlintstones() {
        List<ImmutablePerson> flintstones = new ArrayList<>();
        
        flintstones.add(ImmutablePerson.of("Fred", "Flintstone"));
        flintstones.add(ImmutablePerson.of("Wilma", "Flintstone"));
        flintstones.add(ImmutablePerson.of("Pebbles", "Flintstone"));

        return flintstones;
    }

    private List<ImmutablePerson> getTheRubbles() {
        List<ImmutablePerson> rubbles = new ArrayList<>();
        
        rubbles.add(ImmutablePerson.of("Barney", "Rubble"));
        rubbles.add(ImmutablePerson.of("Betty", "Rubble"));
        rubbles.add(ImmutablePerson.of("Bamm Bamm", "Rubble"));

        return rubbles;
    }
}