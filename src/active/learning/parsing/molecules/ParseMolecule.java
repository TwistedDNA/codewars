package active.learning.parsing.molecules;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParseMolecule {

    public static final String LAST_ATOM_REGEX = ".*([A-Z]+[a-z]?)([0-9]{1,2})$";

    public static Map<String,Integer> getAtoms(String formula) {
        Map<String, Integer> atoms = new HashMap<>();
        // TODO change to ordered map, and get rid of list below
        List<String> reverseOrderedAtoms = new ArrayList<>();

        Matcher lastAtom = Pattern.compile(LAST_ATOM_REGEX).matcher(formula);
        if(lastAtom.find()){
            // find last atom
            String element = lastAtom.group(1);
            if(isValidElement(element)){
                String multiplierAsString = lastAtom.group(2);
                Integer multiplier = Optional.of(Integer.parseInt(multiplierAsString)).orElse(1);
                reverseOrderedAtoms.add(element);

                atoms.putIfAbsent(element, multiplier);
                atoms.computeIfPresent(element, (key, value) -> Integer.sum(value, multiplier));

                int lastAtomLength = Integer.sum(Optional.of(multiplierAsString).map(String::length).orElse(0), element.length());
                String truncatedFormula = formula.substring(0, formula.length() - lastAtomLength);
                // TODO implement recursion on truncated formula
            }
        } else {
            // look for braces
            // TODO find pair of braces (and potentially multiplier)
            // TODO recursively call this method
            // TODO multiply braces result by multiplier
        }
        char lastChar = formula.charAt(formula.length() - 1);
        return new HashMap<>();
    }

    private static boolean isValidElement(String element){
        // TODO implement elements library
        if(element == null){
            return false;
        }
        return true;
    }
}
