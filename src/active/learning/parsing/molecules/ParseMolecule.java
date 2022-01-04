package active.learning.parsing.molecules;

import java.util.HashMap;
import java.util.Map;

public class ParseMolecule {

    public static final String LAST_ATOM_REGEX = ".*(A-Z+a-z?)(0-9{1,2})$";

    public static Map<String,Integer> getAtoms(String formula) {
        // Your code here!
        char lastChar = formula.charAt(formula.length() - 1);
        String lastAtom = LAST_ATOM_REGEX;
        return new HashMap<>();
    }
}
