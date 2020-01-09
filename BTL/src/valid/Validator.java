package valid;

public class Validator {
	public static String admins[] = {"ntxcong", "hvcuong", "tdmanh"};
	public Validator() {
		
	}
	public boolean isNumberic(String str) { 
		  try {  
		    Double.parseDouble(str);  
		    return true;
		  } catch(NumberFormatException e){  
		    return false;  
		  }  
		}
	public boolean validateForm(String username,String receiver, String phone, String address, String ccNumber) {
		if (username.equals(""))
			return false;
		if (receiver.equals(""))
			return false;
		if (phone.equals(""))
			return false;
		if (address.equals(""))
			return false;
		if (ccNumber.equals(""))
			return false;

		return true;
	}

	public static boolean isAdmin(String username){
		for(String s:admins){
			if(s.equals(username))
				return true;
		}
		return false;
	}
}
