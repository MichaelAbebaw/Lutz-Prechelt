import java.util.List;
/**
 * Lutz Prechel
 */
public class Driver {

    /** main call     */
    public static void main ( String [] args) throws Exception {
        String tp =  args[0]; // telephone file path
        String pp = args[1]; // dictionary file path

        LutzProblem problem1 = new LutzProblem(tp,pp);
        List<String> result = problem1.mapToWords();
        for(String s : result)
            System.out.println(s);
    }
}
