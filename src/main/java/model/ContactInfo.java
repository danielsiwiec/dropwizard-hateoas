package model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@EqualsAndHashCode
@RequiredArgsConstructor
public class ContactInfo {

    private final String address;
    private final String email;

    public ContactInfo() {
        address = null;
        email = null;
    }
}
