package org.multibit.txt;



/*
 * Txt Records
 *----------------------------------------
 * This class fetches a txt records with-in a dns zone
 * Author - Ed E*.
 * 
 * 
 * 
 * 
 */


public class txtrecords {
	
	
	
	
	
	public static String getTxtRecord(String hostName) {
  
		//Check to see if user has entered a '.' 
	    //for this is inclination that they are entering .com, .org , etc..
	    if(hostName.contains("."))
	    {
	    	//Convert string to lowercase for compatibility with DNS Zone 
	    	hostName = hostName.toLowerCase();
	    	
		    // Get the first TXT record
		    java.util.Hashtable<String, String> env = new java.util.Hashtable<String, String>();
		    env.put("java.naming.factory.initial", "com.sun.jndi.dns.DnsContextFactory");
	
		    try {
		        javax.naming.directory.DirContext dirContext
		            = new javax.naming.directory.InitialDirContext(env);
		        javax.naming.directory.Attributes attrs
		            = dirContext.getAttributes(hostName, new String[] { "TXT" });
		        javax.naming.directory.Attribute attr
		            = attrs.get("TXT");
	
		        String txtRecord = "";
	
		        if(attr != null) {
		            txtRecord = attr.get().toString();
		        }
	
		        return txtRecord; //Return the txtrecord.
	
		    } catch (javax.naming.NamingException e) {
	
		        e.printStackTrace();
		        return ""; //No address at the address, return nothing
		    }
	    
	    }//end if(address.contains("."))
	    else 
	    {
	    	
	    	return hostName; //No '.' within hostName, return what they submited.
	    	
	    	
	    }
	    
	}
	
	
	
	
	
	

}
