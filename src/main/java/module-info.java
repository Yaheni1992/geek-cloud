module com.geekbrains.cloud_2022_june.geekcloud {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.geekbrains.cloud_2022_june.geekcloud to javafx.fxml;
    exports com.geekbrains.cloud_2022_june.geekcloud;
}