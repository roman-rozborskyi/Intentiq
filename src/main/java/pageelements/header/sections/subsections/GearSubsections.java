package pageelements.header.sections.subsections;

import lombok.AllArgsConstructor;
import pageelements.header.HeaderMenuSubsections;

@AllArgsConstructor
public enum GearSubsections implements HeaderMenuSubsections {
    BAGS("Bags"), FITNESS_EQUIPMENT("Fitness Equipment"), WATCHES("Watches");

    private String subsection;

    @Override
    public String getSubsection() {
        return subsection;
    }
}
