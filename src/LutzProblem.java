import java.io.*;
import java.util.*;

public class LutzProblem {

    private String telephonePath;
    private String dictionaryPath;
    private List<String> numberList;
    private Map<String, ArrayList> wordMap;
    private List<String> mappedResult;

    public LutzProblem(String telephoneFilePath, String dictionaryFilePath) {
        this.telephonePath = telephoneFilePath;
        this.dictionaryPath = dictionaryFilePath;
        wordMap = new TreeMap<String,ArrayList>();
        numberList = new ArrayList<String>();
        mappedResult = new ArrayList<String>();
    }

    /**
     * map
     */
    public List<String> mapToWords() throws Exception{

        if (!loadDictionary() || !loadTelephone()) {
            System.out.println("Some error occurred while loading files.....");
            return null;
        }
        for(String num : numberList) {
            searchMatch(num,num, " ", false);
        }

        return mappedResult;
    }

    /**
     * recursive search for a number
     * populates result list
     */
    private void searchMatch (String number, String num ,String stm, Boolean tdigit) throws Exception {

        Boolean wordFound = false;

        if (num.isEmpty()) {
            if (!stm.isEmpty())
                mappedResult.add(number + ":" + stm); // add to result list
        }
        else {
            for (int i = 2; i <= num.length(); i++) {
                if (wordMap.containsKey(num.substring(0, i))) {
                    wordFound = true;
                    for (int j = 0; j < wordMap.get(num.substring(0, i)).size(); j++)
                        searchMatch(number, num.substring(i), stm + " " + wordMap.get(num.substring(0, i)).get(j), false);
                }
            }
            if (!wordFound && !tdigit)
                searchMatch(number, num.substring(1), stm + " " + num.substring(0,1), true);
        }
    }

    /**
     * Loads telephone numbers from file
     * Setter for number list
     */
    private Boolean loadTelephone() throws Exception{
        // read telephone number
        String num;
        FileReader tr = new FileReader(telephonePath);
        BufferedReader br = new BufferedReader(tr);

        while((num = br.readLine()) != null)
            numberList.add(num);

        br.close();
        return true;
    }

    /**
     * Loads dictionary words from file
     * Setter for word map
     */
    private Boolean loadDictionary() throws Exception{
        // read dictionary
        String word;
        String dWord;
        FileReader dr = new FileReader(dictionaryPath);
        BufferedReader br = new BufferedReader(dr);

        while((word = br.readLine()) != null) {
            dWord = encodeWordsToNumbers(word);
            if (wordMap.containsKey(dWord)){

                wordMap.get(dWord).add(word);
            }
            else{
                ArrayList w = new ArrayList();
                w.add(word);
                wordMap.put(dWord,w);
            }
        }
        br.close();
        return true;
    }

    /**
     * encodes words to numbers
     */
    private String encodeWordsToNumbers(String word){

        String number = "";
        for(char c : word.toLowerCase().toCharArray()){
            number += encode(c);
        }
        return number;
    }

    /**
     * list of mappings
     */
    private int encode(char ch){

        if (ch == 'e')
            return 0;
        else if (ch == 'j' || ch == 'n' || ch == 'q')
            return 1;
        else if (ch == 'r' || ch == 'w' || ch == 'x')
            return 2;
        else if (ch == 'd' || ch == 's' || ch == 'y')
            return 3;
        else if (ch == 'f' || ch == 't')
            return 4;
        else if (ch == 'a' || ch == 'm')
            return 5;
        else if (ch == 'c' || ch == 'i' || ch == 'v')
            return 6;
        else if (ch == 'b' || ch == 'k' || ch == 'u')
            return 7;
        else if (ch == 'l' || ch == 'o' || ch == 'p')
            return 8;
        else if (ch == 'g' || ch == 'h' || ch == 'z')
            return 9;
        else
            return -1;
    }

    /**
     * setters and getters
     */
    public void setTelephoneFilePath(String telephonePath){
        this.telephonePath = telephonePath;
    }

    public void setDictionaryFilePath(String dictionaryPath){
        this.dictionaryPath = dictionaryPath;
    }

    public String getTelephoneFilePath(){
        return telephonePath;
    }

    public String getDictionaryFilePath(){
        return dictionaryPath;
    }
}
