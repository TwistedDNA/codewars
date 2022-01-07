package active.learning.parsing.molecules;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParseMolecule {

    public static final String LAST_ATOM_REGEX = ".*([A-Z]+[a-z]?)([0-9]{0,2})$";
    public static final String ROUND_BRACES_REGEX = "(.*?)\\({1}(.*)\\){1}([0-9]{0,2})$";

    public static Map<String, Integer> getAtoms(String formula) {
        Map<String, Integer> atoms = new LinkedHashMap<>();

        Matcher lastAtom = Pattern.compile(LAST_ATOM_REGEX).matcher(formula);
        if (lastAtom.find()) {
            // find last atom
            String element = lastAtom.group(1);
            if (isValidElement(element)) {
                String multiplierAsString = lastAtom.group(2);
                Integer multiplier = multiplierAsString.isEmpty() ? 1 : Integer.parseInt(multiplierAsString);
                atoms.computeIfPresent(element, (key, value) -> Integer.sum(value, multiplier));
                atoms.putIfAbsent(element, multiplier);

                int lastAtomLength = Integer.sum(Optional.of(multiplierAsString).map(String::length).orElse(0), element.length());
                String truncatedFormula = formula.substring(0, formula.length() - lastAtomLength);

                Map<String, Integer> atomsFromRecursion = getAtoms(truncatedFormula);

                atomsFromRecursion.forEach((atom, times) -> {
                    atoms.computeIfPresent(atom, (key, value) -> Integer.sum(value, times));
                    atoms.putIfAbsent(atom, times);
                });
            }
        } else {
            // TODO add other braces regex
            // TODO deduplicate code
            Matcher roundBraces = Pattern.compile(ROUND_BRACES_REGEX).matcher(formula);
            if (roundBraces.find()) {
                //recursively process expression inside braces
                String multiplierAsString = roundBraces.group(3);
                Integer bracesMultiplier = multiplierAsString.isEmpty() ? 1 : Integer.parseInt(multiplierAsString);
                Map<String, Integer> atomsFromRecursion = getAtoms(roundBraces.group(2));
                atomsFromRecursion.forEach((atom, times) -> {
                    int howManyAtoms = bracesMultiplier * times;
                    atoms.computeIfPresent(atom, (key, value) -> Integer.sum(value, howManyAtoms));
                    atoms.putIfAbsent(atom, howManyAtoms);
                });
                atomsFromRecursion = getAtoms(roundBraces.group(1));
                // recursively process expression outside of braces
                atomsFromRecursion.forEach((atom, times) -> {
                    atoms.computeIfPresent(atom, (key, value) -> Integer.sum(value, times));
                    atoms.putIfAbsent(atom, times);
                });
            }
        }
        return atoms;
    }

    private static boolean isValidElement(String element) {
        // TODO implement elements library
        if (element == null) {
            throw new IllegalArgumentException();
        }
        return true;
    }
}
