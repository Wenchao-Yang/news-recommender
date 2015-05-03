package cs410fp;
import java.io.IOException;
import java.util.Arrays;
import rita.*;


public class searchforrelative {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RiWordNet wordnet = new RiWordNet("C:/Program Files (x86)/WordNet/2.1");
		String word = "sport";
		String[] synonyms = wordnet.getAllSynonyms(word, "n");
		
	    System.out.println("Random noun: " + word);
	    if (synonyms != null) {
	        // Sort alphabetically
	        Arrays.sort(synonyms);
	        for (int i = 0; i < synonyms.length; i++) {
	            System.out.println("Synonym " + i + ": " + synonyms[i]);
	        }
	    } else {
	        System.out.println("No synyonyms!");
	    }
		
	}

}
