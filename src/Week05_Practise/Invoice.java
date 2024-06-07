package Week05_Practise;

public class Invoice implements Payable {
    private final String partNumber;
    private final String partDescription;
    private int quantity;
    private double pricePerItem;

    // four-argument constructor
    public Invoice(String part, String description, int count, double price) {
        partNumber = part;
        partDescription = description;
        setQuantity(count);
        setPricePerItem(price);
    }

    // set quantity
    public void setQuantity(int count) {
        quantity = (count < 0) ? 0 : count; // quantity cannot be negative
    }

    // get quantity
    public int getQuantity() {
        return quantity;
    }

    // set price per item
    public void setPricePerItem(double price) {
        pricePerItem = (price < 0.0) ? 0.0 : price; // price per item cannot be negative
    }

    // get price per item
    public double getPricePerItem() {
        return pricePerItem;
    }

    // return String representation of Invoice object
    @Override
    public String toString() {
        return String.format("invoice:\npart number: %s (%s)\nquantity: %d\nprice per item: $%,.2f",
                partNumber, partDescription, getQuantity(), getPricePerItem());
    }

    // method required to carry out contract with interface Payable
    @Override
    public double getPaymentAmount() {
        return getQuantity() * getPricePerItem(); // calculate total cost
    }
}
