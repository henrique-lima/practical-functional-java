package exercises.basics.immutable;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

public class ImmutablePerson {

    private final String firstName;
    private String middleName;
    private final String lastName;
    private List<String> nicknames;

    public String getFirstName() {
        return Optional.of(firstName).get();
    }

    public Optional<String> getMiddleName() {
        return Optional.ofNullable(middleName);
    }

    public String getLastName() {
        return Optional.of(lastName).get();
    }

    public Stream<String> nickNames() {
        return nicknames.stream();
    }

    public ImmutablePerson withMiddleName(String middleName)
    {
        this.middleName = middleName;
        return this;
    }

    public ImmutablePerson withNickName(String nickName)
    {
        this.nicknames.add(nickName);
        return this;
    }

    public ImmutablePerson(Builder builder) {
        this.firstName = Objects.requireNonNull(builder.firstName);
        this.lastName = Objects.requireNonNull(builder.lastName);
        this.middleName = builder.middleName;
        this.nicknames = builder.nicknames;
    }

    public static class Builder {

        private String firstName;
        private String middleName;
        private String lastName;
        private List<String> nicknames = new ArrayList<>();

        public Builder withFirstName(String firstName)
        {
            this.firstName = firstName;
            return this;
        }

        public Builder withMiddleName(String middleName)
        {
            this.middleName = middleName;
            return this;
        }

        public Builder withLastName(String lastName)
        {
            this.lastName = lastName;
            return this;
        }

        public Builder withNickName(String nickname)
        {
            this.nicknames.add(nickname);
            return this;
        }

        public ImmutablePerson build()
        {
            return new ImmutablePerson(this);
        }
    }
}
