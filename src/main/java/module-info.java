module pl.programming{
    requires javafx.controls;
    requires javafx.fxml;


    opens pl.programming to javafx.fxml;
    exports pl.programming;
}