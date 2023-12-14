package pageelements.header.sections;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum MockSubsections implements MenuSubsections {
    BAGS("MOCK");

    private String subsection;

    @Override
    public String getSubsection() {
        return null;
    }
}
