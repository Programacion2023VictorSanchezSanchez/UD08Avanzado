module com.example.ud08avanzado {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.ud08avanzado to javafx.fxml;
    exports com.example.ud08avanzado;
}