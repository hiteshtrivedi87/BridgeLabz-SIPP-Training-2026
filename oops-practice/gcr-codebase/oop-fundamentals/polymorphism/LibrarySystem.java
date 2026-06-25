class LibraryMember {
    String memberName;
    String memberId;

    public LibraryMember(String memberName, String memberId) {
        this.memberName = memberName;
        this.memberId = memberId;
    }

    public double calculateFine(int overdueDays) {
        return 0.0;
    }

    public void printDetails() {
        System.out.print("ID: " + memberId + " | Name: " + memberName);
    }
}

class StudentMember extends LibraryMember {
    public StudentMember(String memberName, String memberId) { super(memberName, memberId); }

    @Override
    public double calculateFine(int overdueDays) {
        return overdueDays * 0.50;
    }
    
    @Override
    public void printDetails() {
        super.printDetails();
        System.out.println(" | Type: Student");
    }
}

class FacultyMember extends LibraryMember {
    public FacultyMember(String memberName, String memberId) { super(memberName, memberId); }

    @Override
    public double calculateFine(int overdueDays) {
        return overdueDays * 0.10;
    }

    @Override
    public void printDetails() {
        super.printDetails();
        System.out.println(" | Type: Faculty");
    }
}

class GuestMember extends LibraryMember {
    public GuestMember(String memberName, String memberId) { super(memberName, memberId); }

    @Override
    public double calculateFine(int overdueDays) {
        return overdueDays * 2.00;
    }

    @Override
    public void printDetails() {
        super.printDetails();
        System.out.println(" | Type: Guest");
    }
}

public class LibrarySystem {

    public static void findMemberById(LibraryMember[] members, String searchId) {
        boolean found = false;
        System.out.println("\n--- Searching for Member ID: " + searchId + " ---");
        
        for (LibraryMember m : members) {
            if (m.memberId.equalsIgnoreCase(searchId)) {
                System.out.print("Found Record -> ");
                m.printDetails();
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Member with ID " + searchId + " not found.");
        }
    }

    public static void main(String[] args) {
        LibraryMember[] members = {
            new StudentMember("John Doe", "S101"),
            new FacultyMember("Dr. Smith", "F202"),
            new GuestMember("Jane Miller", "G303")
        };

        int daysOverdue = 5;
        System.out.println("--- Library Roster & Estimated Fines (5 Days Overdue) ---");
        for (LibraryMember m : members) {
            m.printDetails();
            System.out.printf("Calculated Fine: $%.2f%n", m.calculateFine(daysOverdue));
            System.out.println("----------------------------------------------");
        }

        findMemberById(members, "F202");
        findMemberById(members, "NONEXISTENT_ID");
    }
}