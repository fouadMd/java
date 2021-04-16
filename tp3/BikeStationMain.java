
public class BikeStationMain{

  public static void main(String[] args) {
    int i = Integer.parseInt(args[0]);
    BikeStation station =new BikeStation("timoleon",10);
    Bike v1=new Bike("b001",BikeModel.CLASSICAL);
    Bike v2=new Bike("b002",BikeModel.ELECTRIC);
    station.dropBike(v1);
    station.dropBike(v2);
    Bike bike=station.takeBike(i);
    if (bike == null){
        System.out.println("no Bike available");
      }
    else{
        System.out.println(bike.toString());
        System.out.println(bike.getPrice());
      }
    }
  }
