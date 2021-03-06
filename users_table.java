@Document(collection = Users.COLLECTION_NAME)
public class Users {
    public static final String COLLECTION_NAME = "users";
  
  @Id
  private Integer sno;

  private String name;

  private String email;

  private LocalDate invoiceDate; 

  private Long mobile; 

// getter and setter
}
