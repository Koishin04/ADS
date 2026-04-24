package src.HashTable_BST;

public class MyTestingClass {
    private int id;
    private String firstName;
    private String lastName;

    public MyTestingClass(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + id;
        if  (firstName != null) {
            for (char c : firstName.toCharArray()) {
                result = 31 * result + c;
            }
        }
        if  (lastName != null) {
            for (char c : lastName.toCharArray()) {
                result = 31 * result + c;
            }
        }
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        MyTestingClass other = (MyTestingClass) obj;
        if (id != other.id) {
            return false;
        }
        if (firstName == null) {
            if (other.firstName != null) {
                return false;
            }
        }
        else if (!firstName.equals(other.firstName)) {
            return false;
        }
        if (lastName == null) {
            if (other.lastName != null) {
                return false;
            }
        }
        else if (!lastName.equals(other.lastName)) {
            return false;
        }
        return true;
    }
}
