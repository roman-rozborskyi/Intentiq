package pageelements.dropdowns;

public interface Dropdown {
    Dropdown open();
    Dropdown select(String value);
    Dropdown openAndSelect(String value);
}
