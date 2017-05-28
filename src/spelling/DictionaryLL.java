package spelling;

import java.util.LinkedList;

/**
 * A class that implements the Dictionary interface using a LinkedList
 *
 */
public class DictionaryLL implements Dictionary 
{

	private LinkedList<String> dict = new LinkedList<String>();
	
	
    // TODO: Add a constructor
	public DictionaryLL(){
		
	}


    /** Add this word to the dictionary.  Convert it to lowercase first
     * for the assignment requirements.
     * @param word The word to add
     * @return true if the word was added to the dictionary 
     * (it wasn't already there). */
    public boolean addWord(String word) {
    	// TODO: Implement this method
    	
    	if(!(word==null)){
    	
        if(this.isWord(word)){
        return false;
        }
    	
    	dict.addLast(word.toLowerCase());
        return true;
    	}
    	return false;
    }


    /** Return the number of words in the dictionary */
    public int size()
    {
        // TODO: Implement this method
        return dict.size();
    }

    /** Is this a word according to this dictionary? */
    public boolean isWord(String s) {
        //TODO: Implement this method
    	if(dict.size()==0){
    		return false;
    	}
    	Boolean found=false;
    	for(int i=0; i<dict.size();i++){
    		if(s.equalsIgnoreCase(dict.get(i))){
    			
    			found=true;
    			break;
    		}
    	}
        return found;
    }

    
}
