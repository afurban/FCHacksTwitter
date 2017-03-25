import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import twitter4j.*;
import twitter4j.auth.AccessToken;

public class Main{
		

	
	static ManualUser RachelMaddow = new ManualUser("MADDOW", 0.6);
	static ManualUser MSNBC = new ManualUser("msnbc", 0.6);
	static ManualUser DailyKos = new ManualUser("dailykos", 1.0);
	static ManualUser Salon = new ManualUser("salon", 1.0);
	static ManualUser MotherJones = new ManualUser("motherjones", 1.0);
	static ManualUser TheNation = new ManualUser("thenation", 1.0);
	static ManualUser EzraKlein = new ManualUser("ezraklein", 1.0);
	static ManualUser NYT = new ManualUser("nytimes", 0.8);
	static ManualUser AriannaHuff = new ManualUser("ariannahuff", 0.8);
	static ManualUser GlennGreenwald = new ManualUser("ggreenwald", 1.0);
	static ManualUser CharlesBlow = new ManualUser("CharlesMBlow", 0.8);
	static ManualUser DonnaBrazile = new ManualUser("donnabrazile", 0.6);
	static ManualUser TYT = new ManualUser("theyoungturks", 1.0);
	static ManualUser Democrats = new ManualUser("theDemocrats", 0.6);
	static ManualUser NancyPelosi = new ManualUser("nancypelosi", 0.6);
	static ManualUser ElizabethWarren = new ManualUser("elizabethforma", 1.0);
	static ManualUser CoryBooker = new ManualUser("corybooker", 0.6);
	static ManualUser Bernie = new ManualUser("berniesanders", 1.0);
	static ManualUser Breitbart = new ManualUser("BreitbartNews", -1.0);
	static ManualUser FoxNews = new ManualUser("FoxNews", -1.0);
	static ManualUser OReilly = new ManualUser("oreillyfactor", -0.8);
	static ManualUser Hannity = new ManualUser("seanhannity", 1.0);
	static ManualUser DailyCaller = new ManualUser("dailycaller", -1.0);
	static ManualUser MichelleMalkin = new ManualUser("michellemalkin", -1.0);
	static ManualUser WeeklyStandard = new ManualUser("weeklystandard", -1.0);
	static ManualUser WSJ = new ManualUser("wsj", -0.8);
	static ManualUser AnnCoulter = new ManualUser("anncoulter", -1.0);
	static ManualUser GlennBeck = new ManualUser("glennbeck", -0.8);
	static ManualUser Drudge = new ManualUser("Drudge_report", -1.0);
	static ManualUser Limbaugh = new ManualUser("rushlimbaugh", -1.0);
	static ManualUser KellyanneConway = new ManualUser("kellyannepolls", -1.0);
	static ManualUser AlexJones = new ManualUser("realAlexJones", -1.0);
	static ManualUser GOP = new ManualUser("GOP", -1.0);
	static ManualUser Boehner = new ManualUser("SpeakerBoehner", -0.8);
	static ManualUser Ryan = new ManualUser("SpeakerRyan", -1.0);
	static ManualUser Pence = new ManualUser("mike_pence", -1.0);
	static ManualUser Alec = new ManualUser("alececkman", 1.0);
	
	
	public static ArrayList<ManualUser> makeManualDataArray(){
		ArrayList<ManualUser> manualData = new ArrayList<ManualUser>();
		manualData.add(RachelMaddow);
		manualData.add(MSNBC);
		manualData.add(DailyKos);
		manualData.add(Salon);
		manualData.add(MotherJones);
		manualData.add(TheNation);
		manualData.add(EzraKlein);
		manualData.add(NYT);
		manualData.add(AriannaHuff);
		manualData.add(GlennGreenwald);
		manualData.add(CharlesBlow);
		manualData.add(DonnaBrazile);
		manualData.add(TYT);
		manualData.add(Democrats);
		manualData.add(NancyPelosi);
		manualData.add(ElizabethWarren);
		manualData.add(CoryBooker);
		manualData.add(Bernie);
		manualData.add(Breitbart);
		manualData.add(FoxNews);
		manualData.add(OReilly);
		manualData.add(Hannity);
		manualData.add(DailyCaller);
		manualData.add(MichelleMalkin);
		manualData.add(WeeklyStandard);
		manualData.add(WSJ);
		manualData.add(AnnCoulter);
		manualData.add(GlennBeck);
		manualData.add(Drudge);
		manualData.add(Limbaugh);
		manualData.add(KellyanneConway);
		manualData.add(AlexJones);
		manualData.add(GOP);
		manualData.add(Boehner);
		manualData.add(Ryan);
		manualData.add(Pence);
		manualData.add(Alec);
		return manualData;
	}
	
	
	static String userHandle = "potatogazette";
	
	public static void run() throws TwitterException, IOException{
		
		InputStreamReader reader = new InputStreamReader(System.in);
		BufferedReader input = new BufferedReader(reader);
		
		System.out.println("ENTER YOUR TWITTER HANDLE, HERE: ");
		userHandle = input.readLine();
		
		System.out.println("Phase 1/3 Complete...");
		
	    final Twitter twitter = new TwitterFactory().getInstance();

	    twitter.setOAuthConsumer("nnFbAsgR5EDQYaabmIXBDAhQ4", "w34FyJ71TDXKkXVgmYEB35OBxlKhyW3YpCGeW5LYsEzzjfJ47C");
	    AccessToken accessToken = new AccessToken("836394171426549760-Brhx5qKr48sw8aIsxb8tFZ75awIeefW",
	    		"q2yi1RdHltfE5i6E4SNoPRGrYjIf0p8EHmhyuQo6lMPCO");	
	    twitter.setOAuthAccessToken(accessToken);

		
		ArrayList<ManualUser> manualData = makeManualDataArray();
		
		
	
	    User user = twitter.showUser(userHandle);
	   // System.out.println(user.getId());
	
	    
    	int  countpotato = 0;
	    
	    for(ManualUser i : manualData){
	    	countpotato++;
	    //	System.out.println(countpotato);
		    User manualUser2 = twitter.showUser(i.username);
		    i.user_id = manualUser2.getId();
		   // System.out.println(i.user_id);
	    }
	    
	     IDs ids = twitter.getFriendsIDs(userHandle, 5000);
	    
	     for (long id : ids.getIDs()) {
             //System.out.println(id);
             User user5 = twitter.showUser(id);
             //System.out.println(user5.getName());
         }
	     
			System.out.println("Phase 2/3 Complete...");

	    
			double sum = 0;
			double count = 0;
			double totalcount = 0;
	     
	     User u1 = null ;
	      long cursor = -1;
	      IDs ids4;
	      //System.out.println("Listing followers's ids.");
	      do {
	              ids4 = twitter.getFriendsIDs(userHandle, cursor);
	          for (long id : ids4.getIDs()) {
	        	  totalcount++;
	             // System.out.println(id);
	              User potbob = twitter.showUser(id);
	            //  System.out.println("NAME?");
	             // System.out.println(potbob.getName());
	              
	              for(ManualUser i : manualData){
	            	  if (i.user_id == id){
	            			//System.out.println("MATCH!");
	    					sum = sum + i.ideologyScore;
	    					count++;
	            	  }
	              }
	          }
	      } while ((cursor = ids4.getNextCursor()) != 0);
	     
	      
			System.out.println("Phase 3/3 Complete...");

	     
	     //list of people they're following
		//GET FRIENDS
		

		//System.out.println(sum);
		//System.out.println(count);

		double average = sum/count;
		
		System.out.println("Ideology Score");
		System.out.println(average);
		
		//System.out.println("HI");

		// TODO Auto-generated method stub
	}


	public static void main(String[] args) throws TwitterException, IOException{
	run();
	}

}
