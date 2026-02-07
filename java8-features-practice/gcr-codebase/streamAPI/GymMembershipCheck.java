package gcr_codebase.streamapi;

import java.util.*;
import java.time.*;

class GymMember{
	//name, membershipdate
	String name;
    LocalDate expiryDate;

    GymMember(String name, LocalDate expiryDate) {
        this.name = name;
        this.expiryDate = expiryDate;
    }
}

public class GymMembershipCheck {
    public static void main(String[] args) {

        List<GymMember> members = List.of(
            new GymMember("Manish", LocalDate.now().plusDays(10)),
            new GymMember("Pawan", LocalDate.now().plusDays(40)),
            new GymMember("Bhuvnesh", LocalDate.now().plusDays(25)),
            new GymMember("Amit", LocalDate.now().minusDays(5))
        );

        LocalDate today = LocalDate.now();
        LocalDate next30Days = today.plusDays(30);

        members.stream()
               .filter(m ->
                   !m.expiryDate.isBefore(today) &&
                    m.expiryDate.isBefore(next30Days)
               )
               .forEach(m ->
                   System.out.println(m.name + "'s membership expires on " + m.expiryDate)
               );
    }
}
