module com.example.ford {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.ford to javafx.fxml;
    exports com.example.ford;
}