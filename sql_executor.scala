import java.sql.{Connection, DriverManager, ResultSet}

object sql_executor {
  def main(args: Array[String]) {
   val driver = "org.postgresql.Driver"

    // Change to Your Database Config
    val conn_str = "jdbc:postgresql://192.168.177.145:5432/gpadmin"

    // Load the driver
    //classOf[org.postgresql.Driver]
     Class.forName(driver)
  val prop = new java.util.Properties
 prop.setProperty("user","gpadmin")


    // Setup the connection
    val conn = DriverManager.getConnection(conn_str,prop)
    try {
      // Configure to be Read Only
      val statement = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY)

      // Execute Query
      val rs = statement.executeQuery("select * From test_piani")

      // Iterate Over ResultSet
      while (rs.next) {
        println(rs.getString(1))
      }
    }
    finally {
      conn.close
    }
}
}
