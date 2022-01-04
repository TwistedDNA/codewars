package active.learning.parsing.molecules;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ParseMoleculeTest {

    @Test
    public void testDifferentMolecules() {
        testMolecule(Arrays.asList("H", "O"),
                Arrays.asList(2, 1),
                "H2O",
                "water");

        testMolecule(Arrays.asList("Mg", "H", "O"),
                Arrays.asList(1, 2, 2),
                "Mg(OH)2",
                "magnesium hydroxide");

        testMolecule(Arrays.asList("K", "O", "N", "S"),
                Arrays.asList(4, 14, 2, 4),
                "K4[ON(SO3)2]2",
                "Fremy's salt");
    }

    public void testMolecule(List<String> atoms, List<Integer> nums, String formula, String name) {
        Map<String, Integer> expected = new HashMap<>();
        for (int i = 0; i < atoms.size(); i++) expected.put(atoms.get(i), nums.get(i));

        assertEquals(String.format("Should parse %s: %s", name, formula), expected, ParseMolecule.getAtoms(formula));
    }
    @Test
    public void lastAtomRegexTest_shouldFindLastAtom(){
        String legitFormula = "H2SO4";
        Matcher matcher = Pattern.compile(ParseMolecule.LAST_ATOM_REGEX).matcher(legitFormula);
        // TODO test failing, fix regex
        assertTrue(matcher.find());
        assertEquals("O", matcher.group(1));
        assertEquals("2", matcher.group(2));
    }
}