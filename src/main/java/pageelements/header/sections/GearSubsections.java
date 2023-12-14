package pageelements.header.sections;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum GearSubsections implements MenuSubsections {
    BAGS("Bags"), FITNESS_EQUIPMENT("Fitness Equipment"), WATCHES("Watches");

    private String subsection;

    @Override
    public String getSubsection() {
        return null;
    }
}
