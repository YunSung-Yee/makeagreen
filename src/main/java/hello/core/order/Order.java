package hello.core.order;

public class Order {

    private Long memberId;
    private String itemName;
    private int itemPrice;
    private int discountprice;

    public Order(Long memberId, String itemName, int itemprice, int discountprice) {
        this.memberId = memberId;
        this.itemName = itemName;
        this.itemPrice = itemprice;
        this.discountprice = discountprice;
    }

    public int calculatePrice(){
        return itemPrice - discountprice;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getItemprice() {
        return itemPrice;
    }

    public void setItemprice(int itemprice) {
        this.itemPrice = itemprice;
    }

    public int getDiscountprice() {
        return discountprice;
    }

    public void setDiscountprice(int discountprice) {
        this.discountprice = discountprice;
    }

    @Override
    public String toString() {
        return "Order{" +
                "memberId=" + memberId +
                ", itemName='" + itemName + '\'' +
                ", itemPrice=" + itemPrice +
                ", discountprice=" + discountprice +
                '}';
    }
}
