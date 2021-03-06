import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;

public class ClientTest {

  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void Client_instantiatesCorrectly_true() {
    Client myClient = new Client("Ted", 1);
    assertEquals(true, myClient instanceof Client);
  }

  @Test
 public void Client_instantiatesWithName_String() {
   Client myClient = new Client("Ted", 1);
   assertEquals("Ted", myClient.getName());
 }

 @Test
 public void all_returnsAllInstancesOfClient_true() {
   Client firstClient = new Client("Ted", 1);
   firstClient.save();
   Client secondClient = new Client("Jeff", 1);
   secondClient.save();
   assertEquals(true, Client.all().get(0).equals(firstClient));
   assertEquals(true, Client.all().get(1).equals(secondClient));
 }

 @Test
 public void clear_emptiesAllClientsFromArrayList_0() {
   Client myClient = new Client("Ted", 1);
   assertEquals(Client.all().size(), 0);
 }

 @Test
 public void getId_clientsInstantiateWithAnID_1() {
   Client myClient = new Client("Ted", 1);
   myClient.save();
   assertTrue(myClient.getId() > 0);
 }

 @Test
 public void find_returnsClientWithSameId_secondClient() {
   Client firstClient = new Client("Ted", 1);
   firstClient.save();
   Client secondClient = new Client("Buy groceries", 1);
   secondClient.save();
   assertEquals(Client.find(secondClient.getId()), secondClient);
 }

 @Test
 public void equals_returnsTrueIfNamesAretheSame() {
   Client firstClient = new Client("Ted", 1);
   Client secondClient = new Client("Ted", 1);
   assertTrue(firstClient.equals(secondClient));
 }

 @Test
 public void save_returnsTrueIfNamesAretheSame() {
   Client myClient = new Client("Ted", 1);
   myClient.save();
   assertTrue(Client.all().get(0).equals(myClient));
 }

 @Test
 public void save_assignsIdToObject() {
   Client myClient = new Client("Ted", 1);
   myClient.save();
   Client savedClient = Client.all().get(0);
   assertEquals(myClient.getId(), savedClient.getId());
 }

@Test
 public void save_savesStylistIdIntoDB_true() {
   Stylist myStylist = new Stylist("Jim");
   myStylist.save();
   Client myClient = new Client("Ted", myStylist.getId());
   myClient.save();
   Client savedClient = Client.find(myClient.getId());
   assertEquals(savedClient.getStylistId(), myStylist.getId());
 }

 @Test
 public void update_updatesClientName_true() {
   Client myClient = new Client("Ted", 1);
   myClient.save();
   myClient.update("Regular customer");
   assertEquals("Regular customer", Client.find(myClient.getId()).getDetails());
 }

 @Test
 public void delete_deletesClient_true() {
   Client myClient = new Client("Ted", 1);
   myClient.save();
   int myClientId = myClient.getId();
   myClient.delete();
   assertEquals(null, Client.find(myClientId));
 }
}
