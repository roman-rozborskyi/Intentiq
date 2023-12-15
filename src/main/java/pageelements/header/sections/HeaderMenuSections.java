package pageelements.header.sections;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum HeaderMenuSections {
    WHATS_NEW("What's New"), WOMEN("Women"), MEN("Men"),
    GEAR("Gear"), TRAINING("Training"), SALE("Sale");

    private String name;
}
