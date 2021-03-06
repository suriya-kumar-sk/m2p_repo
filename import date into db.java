public class M2PImport {

    XSSFRow row;
    Users user = new Users();

    public static void main(String[] args) throws IOException {

        String fileName = "/home/Users.xlsx";
        M2PImport import = new M2PImport();
        import .readFile(fileName);
    }

    public void readFile(String fileName) throws FileNotFoundException, IOException {
        FileInputStream fis;
        try {

            fis = new FileInputStream(fileName);
            XSSFWorkbook workbookRead = new XSSFWorkbook(fis);
            XSSFSheet spreadsheetRead = workbookRead.getSheetAt(0);

            Iterator< Row> rowIterator = spreadsheetRead.iterator();
            while (rowIterator.hasNext()) {
                row = (XSSFRow) rowIterator.next();             

                user.sno = Integer.parseInt(row.getCell(0).getStringCellValue());

		if(validateName(row.getCell(1).getStringCellValue())){
                	user.name = row.getCell(1).getStringCellValue();
		   }
                if(validateDate(row.getCell(2).getStringCellValue())){
			user.dob = row.getCell(2).getStringCellValue();
		   }
                if(validateMobile(row.getCell(3).getStringCellValue())){
                 user.mobile = encrypt(row.getCell(3).getStringCellValue());
		   }

                InsertRowInDB(user.sno, user.name, user.dob, user.mobile);
            }
       

            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

   private String encrypt(String password){
        // Generate Salt. The generated value can be stored in DB. 
        String salt = PasswordUtils.getSalt(30);
        
        // Protect user's password. The generated value can be stored in DB.
        String mySecurePassword = PasswordUtils.generateSecurePassword(password, salt);
        
   }
  private boolean validateName(String name){
        if(StringUtils.isNotBlank(name) && name.length >3 && name.matches("^[a-zA-Z0-9]*$") && name.split(" ").length==1){

	return true;
	}
		return false;
        
   }

  private boolean validateDate(String name){
 		SimpleDateFormat sdfrmt = new SimpleDateFormat("MM/dd/yyyy");
		Date date = sdfrmt.parse(strDate); 
        if(date.getYear() < 1901){

	return false;
	}
		return true;
        
   }
  private boolean validateMobile(String mobile){
        if(mobile.matches("[0-9]+") && mobile.length==10){

	return true;
	}
		return false;
        
   }
    public void InsertRowInDB(...) {
        try {

           //Insert query
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
