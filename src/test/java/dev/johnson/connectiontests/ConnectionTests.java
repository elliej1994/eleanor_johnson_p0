package dev.johnson.connectiontests;

import dev.johnson.utilities.ConnectionUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Connection;

public class ConnectionTests {

    @Test
     public void can_connect(){
        Connection conn = ConnectionUtil.createConnection();
        Assertions.assertNotNull(conn);
    }
}

