@Controller // This means that this class is a Controller
@Path(path="/demo") 
public class MainController {
  @Autowired 
  private M2PRepository repository;

  @POST
  @Path("/validate")
  public String validateFile (File file) {
    String filename = file.getName();
    String extension = filename.substring(filename.lastIndexOf(".") + 1, filename.length());

    String excel = "xls";
    if (!extension.equals(excel)){
       JOptionPane.showMessageDialog(null, "Choose an excel file!");

    }
    else {
        String filepath = file.getAbsolutePath();
        JOptionPane.showMessageDialog(null, filepath);
        String upload = UploadPoData.initialize(null, filepath);

         if ("OK".equals(upload)) {
     JOptionPane.showMessageDialog(null,"Upload Successful!");
    }
    }
  }

  @POST
  @Path("/import")
  public void import( File file) {

    // Class implementation of Import;
  }

  @GET
  @Path("/getUsers")
  public List<Users> getUsers() {

    // repository.getAllUsers();
  }

}
