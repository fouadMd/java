/**
 *
 * @author Medjahed Fouad/Ainouch Tarik
 *
 */
public class BikeMain{

  public static void main(String[] args) {
    Bike v1=new Bike("b001",BikeModel.CLASSICAL);
    Bike v2=new Bike("b002",BikeModel.ELECTRIC);
    System.out.println(v1.equals(v2));
    System.out.println(v1.toString());
    System.out.println(v1.getPrice());
    }
}
