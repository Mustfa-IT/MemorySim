module org.caveman.memorysim {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens org.caveman.memorysim to javafx.fxml;
    exports org.caveman.memorysim;
}