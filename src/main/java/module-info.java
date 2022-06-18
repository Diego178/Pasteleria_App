module com.proyecto.pasteleria {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires java.sql;
    requires javafx.graphics;
    requires javafx.base;
    requires mysql.connector.java;

    /*requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;*/

    opens com.proyecto.pasteleria.Modelos to javafx.base;
    opens com.proyecto.pasteleria to javafx.fxml;
    exports com.proyecto.pasteleria;
    exports com.proyecto.pasteleria.Login;
    opens com.proyecto.pasteleria.Login to javafx.fxml;
    exports com.proyecto.pasteleria.Menu;
    opens com.proyecto.pasteleria.Menu to javafx.fxml;
    exports com.proyecto.pasteleria.AgregarPastel;
    opens com.proyecto.pasteleria.AgregarPastel to javafx.fxml;
    exports com.proyecto.pasteleria.Venta;
    opens com.proyecto.pasteleria.Venta to javafx.fxml;
    exports com.proyecto.pasteleria.AgregarDireccion;
    opens com.proyecto.pasteleria.AgregarDireccion to javafx.fxml;
    exports com.proyecto.pasteleria.Conexion;
    opens com.proyecto.pasteleria.Conexion to javafx.fxml;

}
