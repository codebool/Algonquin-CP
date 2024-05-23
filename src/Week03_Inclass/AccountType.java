/**
 * Student Name: Bo Qu
 * Lab Professor: Travis Lothar Czech
 * Due Date: 2024-05-21
 * Modified: 2024-05-21
 * Description: Lab assignment
 */

package Week03_Inclass;

public enum AccountType {
    SAVINGS("Saving Account"),
    CHECKING("Chequing Account");

    private final String description;

    private AccountType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
