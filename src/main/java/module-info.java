module hibernate.example {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.hibernate.orm.core;
    requires static lombok;
    requires jakarta.persistence;
    requires java.naming;

    opens org.example to javafx.fxml;
    opens org.example.entities;
    opens org.example.repository;
    exports org.example;
    exports org.example.javafxController;
    opens org.example.javafxController to javafx.fxml;
}