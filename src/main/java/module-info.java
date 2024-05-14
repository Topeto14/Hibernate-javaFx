module hibernate.example {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.hibernate.orm.core;
    requires static lombok;
    requires jakarta.persistence;
    requires java.naming;

    opens org.example to javafx.fxml;
    opens org.example.entities;
    exports org.example;
    exports org.example.controllers;
    opens org.example.controllers to javafx.fxml;
}