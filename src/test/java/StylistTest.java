import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;
import java.util.Arrays;

public class StylistTest {

  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void category_instantiatesCorrectly_true() {
    Stylist testStylist = new Stylist("Zelda");
    assertEquals(true, testStylist instanceof Stylist);
  }

  @Test
  public void getName_categoryInstantiatesWithName_Zelda() {
    Stylist testStylist = new Stylist("Zelda");
    assertEquals("Zelda", testStylist.getName());
  }

 @Test
 public void all_returnsAllInstancesOfStylist_true() {
   Stylist firstStylist = new Stylist("Zelda");
   firstStylist.save();
   Stylist secondStylist = new Stylist("Linda");
   secondStylist.save();
   assertEquals(true, Stylist.all().get(0).equals(firstStylist));
   assertEquals(true, Stylist.all().get(1).equals(secondStylist));
 }

 @Test
 public void getId_stylistsInstantiateWithAnId_1() {
   Stylist testStylist = new Stylist("Zelda");
   testStylist.save();
   assertTrue(testStylist.getId() > 0);
 }

 @Test
 public void find_returnsStylistWithSameId_secondStylist() {
   Stylist firstStylist = new Stylist("Zelda");
   firstStylist.save();
   Stylist secondStylist = new Stylist("Linda");
   secondStylist.save();
   assertEquals(Stylist.find(secondStylist.getId()), secondStylist);
 }

  @Test
  public void equals_returnsTrueIfNamesAretheSame() {
    Stylist firstStylist = new Stylist("Zelda");
    Stylist secondStylist = new Stylist("Zelda");
    assertTrue(firstStylist.equals(secondStylist));
  }

  @Test
  public void save_savesIntoDatabase_true() {
    Stylist myStylist = new Stylist("Zelda");
    myStylist.save();
    assertTrue(Stylist.all().get(0).equals(myStylist));
  }

  @Test
  public void save_assignsIdToObject() {
    Stylist myStylist = new Stylist("Zelda");
    myStylist.save();
    Stylist savedStylist = Stylist.all().get(0);
    assertEquals(myStylist.getId(), savedStylist.getId());
  }

  @Test
  public void getClients_retrievesALlClientsFromDatabase_clientsList() {
    Stylist myStylist = new Stylist("Bob");
    myStylist.save();
    Client firstClient = new Client("Mary", myStylist.getId());
    firstClient.save();
    Client secondClient = new Client("Sue", myStylist.getId());
    secondClient.save();
    Client[] clients = new Client[] { firstClient, secondClient };
    assertTrue(myStylist.getClients().containsAll(Arrays.asList(clients)));
  }

  @Test
  public void update_updatesStylistDetails_true() {
    Stylist myStylist = new Stylist("Ted");
    myStylist.save();
    myStylist.update("Worked here 5 years");
    assertEquals("Worked here 5 years", Stylist.find(myStylist.getId()).getDetails());
  }

  @Test
  public void delete_deletesStylist_true() {
    Stylist myStylist = new Stylist("Ted");
    myStylist.save();
    int myStylistId = myStylist.getId();
    myStylist.delete();
    assertEquals(null, Stylist.find(myStylistId));
  }
}
