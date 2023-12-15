package steps;

import pageobjects.OrderInfoPage;
import utils.fileservice.FileWriter;
import utils.fileservice.FileWriterImpl;

public class OrderInfoSteps {
    private OrderInfoPage orderInfoPage = new OrderInfoPage();

    public OrderInfoSteps writeOrderIdToFile() {
        String orderId = orderInfoPage.getOrderId();
        FileWriter fileWriter = new FileWriterImpl();
        fileWriter.write(orderId);

        return this;
    }
}
