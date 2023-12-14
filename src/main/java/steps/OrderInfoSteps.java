package steps;

import pageelements.OrderInfoPageElement;

public class OrderInfoSteps {
    private OrderInfoPageElement orderInfoPageElement = new OrderInfoPageElement();

    public OrderInfoSteps writeOrderIdToFile() {
        String orderId = orderInfoPageElement.getOrderId();

        return this;
    }
}
