import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.sql2o.*;

public class Client {

  private String name;
  private int id;
  private int stylistId;
  private String details;

  public Client(String name, int stylistId) {
    this.name = name;
    this.stylistId = stylistId;
    this.details =  "none entered";
  }

  public String getName() {
    return name;
  }

  public int getStylistId() {
    return stylistId;
  }

  public int getId() {
    return id;
  }

  public String getDetails() {
    return details;
  }

  public static List<Client> all() {
    String sql = "SELECT id, name, stylistid, details FROM clients";
    try(Connection con = DB.sql2o.open()) {
     return con.createQuery(sql).executeAndFetch(Client.class);
    }
  }

  @Override
  public boolean equals(Object otherClient){
    if (!(otherClient instanceof Client)) {
      return false;
    } else {
      Client newClient = (Client) otherClient;
      return this.getName().equals(newClient.getName()) &&
             this.getId() == newClient.getId() &&
             this.getStylistId() == newClient.getStylistId();
    }
  }

  public void save() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "INSERT INTO clients(name, stylistid, details) VALUES (:name, :stylistid, :details)";
      this.id = (int) con.createQuery(sql, true)
        .addParameter("name", this.name)
        .addParameter("stylistid", this.stylistId)
        .addParameter("details", this.details)
        .executeUpdate()
        .getKey();
    }
  }

  public static Client find(int id) {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM clients where id=:id";
      Client client = con.createQuery(sql)
        .addParameter("id", id)
        .executeAndFetchFirst(Client.class);
      return client;
    }
  }

  public void update(String details) {
    try(Connection con = DB.sql2o.open()) {
    String sql = "UPDATE clients SET details = :details WHERE id = :id";
    con.createQuery(sql)
      .addParameter("details", details)
      .addParameter("id", id)
      .executeUpdate();
    }
  }

  public void delete() {
    try(Connection con = DB.sql2o.open()) {
    String sql = "DELETE FROM clients WHERE id = :id;";
    con.createQuery(sql)
      .addParameter("id", id)
      .executeUpdate();
    }
  }

}
