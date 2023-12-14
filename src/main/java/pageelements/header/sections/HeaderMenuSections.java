package pageelements.header.sections;

import lombok.AllArgsConstructor;

import java.util.Collections;
import java.util.List;

@AllArgsConstructor
public enum HeaderMenuSections {
    WHATS_NEW("What's New"){
        @Override
        public MenuSubsections getSubsections() {
            return MockSubsections.BAGS;
        }
    },
    WOMEN("Women"){
        @Override
        public MenuSubsections getSubsections() {
            return Collections.emptyList();
        }
    },
    MEN("Men") {
        @Override
        public MenuSubsections getSubsections() {
            return Collections.emptyList();
        }
    },
    GEAR("Gear") {
        @Override
        public List<String> getSubSections() {
            return List.of("Bags", "Fitness Equipment", "Watches");
        }
    },
    TRAINING("Training"){
        @Override
        public MenuSubsections getSubsections() {
            return Collections.emptyList();
        }
    },
    SALE("Sale") {
        @Override
        public MenuSubsections getSubsections() {
            return Collections.emptyList();
        }
    };

    private String sectionName;

    public abstract String getName();

    public abstract MenuSubsections getSubsections();
}
