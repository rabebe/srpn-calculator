import java.util.ArrayList;
import java.util.List;

/*
Stores the values called when r is inputted into SRPN in an array,
and returns the next value in the array each time getNextValue() is called.
 */
public class R_List {
  private List<Integer> array;
  private int i = -1;

  public R_List() {
    // initializes the array with the values
    array = new ArrayList<Integer>();
    addToSrpn();
  }

  public Integer getNextValue() {
    // returns the next value in the array
    i++;
    if (i == 23) {
      i = -1;
    }
    return array.get(i);
  }

  private void addToSrpn() {
    // adds the values to the array
    array.add(1804289383);
    array.add(846930886);
    array.add(1681692777);
    array.add(1714636915);
    array.add(1957747793);
    array.add(424238335);
    array.add(719885386);
    array.add(1649760492);
    array.add(596516649);
    array.add(1189641421);
    array.add(1025202362);
    array.add(1350490027);
    array.add(783368690);
    array.add(1102520059);
    array.add(2044897763);
    array.add(1967513926);
    array.add(1365180540);
    array.add(1540383426);
    array.add(304089172);
    array.add(1303455736);
    array.add(35005211);
    array.add(521595368);
    array.add(1804289383);

  }
}