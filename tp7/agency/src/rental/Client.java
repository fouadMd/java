package rental;

/** represent clients of a rental agency, the names are supposed to be
 * unique then two Client objects with same name are considered equals
*/ 
public class Client {

    private String name;
    private int age;

    /** create a client with given name and age, two different clients
     * have different names by assumption (no verification)
     * @param name name of the client
     * @param age age of the client
    */
    public Client(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /** @return the client's name
      */
    public String getName() {
        return this.name;
    }

    /**@return the client's age
    */
    public int getAge() {
        return this.age;
    }

    /** two clients are equal to each other if they have the same name
     *
     * @see java.lang.Object#equals(java.lang.Object)
     */
    public boolean equals(Object o){
      if (o instanceof Client){
        Client other = (Client) o;
        return other.name.equals(this.name);
      }
      else return false;
    }

    /** produces a hashcode for a Client, the hashcode is equal to the hashcode of the name
     * @return the hashcode of the client
     */
    public int hashCode(){
      return this.name.hashCode();
    }

}
