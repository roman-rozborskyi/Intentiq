package utils.drivermanager;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dtos.ShippingDataDirector;
import dtos.ShippingDataDto;
import dtos.ShippingDataHttpRequest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v120.network.Network;
import org.openqa.selenium.devtools.v120.network.model.Request;
import org.openqa.selenium.devtools.v120.network.model.RequestWillBeSent;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

public class DevToolsServiceChrome implements DevToolsService{
    private DevTools devTools;

    {
        DriverManager driverManager = DriverManager.getInstance();
        WebDriver webDriver  = driverManager.getDriver();
        ChromeDriver driver = (ChromeDriver) webDriver;
        devTools = driver.getDevTools();
    }

    public void createSession() {
        devTools.createSession();
    }

    public void stopSession() {
        devTools.close();
    }

    public ShippingDataDto requestToShippingData() {
        AtomicReference<ShippingDataDto> shippingDataDto = new AtomicReference<>();
        devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
        devTools.addListener(Network.requestWillBeSent(), requestConsumer -> {
            if(isShippingInformationRequest(requestConsumer)) {
                Request request = requestConsumer.getRequest();
                String sentData = request.getPostData().orElseThrow(() -> new RuntimeException("Impossible to get request from the HTTP"));
                Gson gson = new GsonBuilder().create();
                ShippingDataHttpRequest p = gson.fromJson(sentData, ShippingDataHttpRequest.class);

                ShippingDataDto shippingDataDto1 = new ShippingDataDirector().getInstance(p);
                shippingDataDto.set(shippingDataDto1);
            }
        });
        return shippingDataDto.get();
    }

    private boolean isShippingInformationRequest(RequestWillBeSent request) {
        return request.getRequest().getUrl().endsWith("shipping-information");
    }
}
