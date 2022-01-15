package active.learning.parsing.molecules;

import org.junit.Ignore;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.*;

public class ParseMoleculeTest {

    @Test
    public void shouldDecomposeWater(){
        testMolecule(Arrays.asList("H", "O"),
                Arrays.asList(2, 1),
                "H2O",
                "water");
    }

    @Test
    public void shouldDecomposeMagnesiumHydroxide(){
        testMolecule(Arrays.asList("Mg", "H", "O"),
                Arrays.asList(1, 2, 2),
                "Mg(OH)2",
                "magnesium hydroxide");
    }

    @Test
    public void shouldDecomposeFermySalt() {
        testMolecule(Arrays.asList("K", "O", "N", "S"),
                Arrays.asList(4, 14, 2, 4),
                "K4[ON(SO3)2]2",
                "Fremy's salt");
    }

    @Test
    @Ignore
    public void shouldThrowExceptionOnInvalidElement(){
        String formula = "Ag2Li3Ub6";
        assertThrows(IllegalArgumentException.class, () -> ParseMolecule.getAtoms(formula));
    }

    public void testMolecule(List<String> atoms, List<Integer> nums, String formula, String name) {
        Map<String, Integer> expected = new HashMap<>();
        for (int i = 0; i < atoms.size(); i++) expected.put(atoms.get(i), nums.get(i));

        assertEquals(String.format("Should parse %s: %s", name, formula), expected, ParseMolecule.getAtoms(formula));
    }

    @Test
    public void lastAtomRegexTest_shouldFindLastAtom(){
        String legitFormula = "H2O";
        Matcher matcher = Pattern.compile(ParseMolecule.LAST_ATOM_REGEX).matcher(legitFormula);
        assertTrue(matcher.find());
        assertEquals("O", matcher.group(1));
        assertTrue(matcher.group(2).isEmpty());
    }
    @Test
    public void lastAtomRegexTest_shouldFindLastAtomWithMultiplier(){
        String legitFormula = "H2SO4";
        Matcher matcher = Pattern.compile(ParseMolecule.LAST_ATOM_REGEX).matcher(legitFormula);
        assertTrue(matcher.find());
        assertEquals("O", matcher.group(1));
        assertEquals("4", matcher.group(2));
    }

    @Test
    public void lastAtomRegexTest_shouldNotFindLastAtomIfInBrackets(){
        String legitFormula = "Mg(OH)2";
        boolean foundAtom = Pattern.compile(ParseMolecule.LAST_ATOM_REGEX).matcher(legitFormula).find();
        assertFalse(foundAtom);
    }

    @Test
    public void racesRegexTest_shouldTakeOuterBraces(){
        String legitFormula = "K4(ON(SO3)2)2";
        String expectedOutsideBrackets = "K4";
        String expectedInsideBrackets = "ON(SO3)2";
        String expectedMultiplier = "2";

        Matcher matcher = Pattern.compile(ParseMolecule.BRACKETS_REGEX).matcher(legitFormula);

        assertTrue(matcher.find());
        assertEquals(expectedOutsideBrackets, matcher.group(1));
        assertEquals(expectedInsideBrackets, matcher.group(2));
        assertEquals(expectedMultiplier, matcher.group(3));
    }

    @Test
    public void racesRegexTest_shouldProcessSquareBrackets(){
        String legitFormula = "Mg[OH]2";
        String prefix = "Mg";
        String insideBrackets = "OH";
        String suffix = "2";
        Matcher matcher = Pattern.compile(ParseMolecule.BRACKETS_REGEX).matcher(legitFormula);
        assertTrue(matcher.find());

        assertEquals(legitFormula, matcher.group(0));
        assertEquals(prefix, matcher.group(1));
        assertEquals(insideBrackets, matcher.group(2));
        assertEquals(suffix, matcher.group(3));
    }

    @Test
    public void racesRegexTest_shouldProcessCurlyBrackets(){
        String legitFormula = "Mg{OH}2";
        String prefix = "Mg";
        String insideBrackets = "OH";
        String suffix = "2";
        Matcher matcher = Pattern.compile(ParseMolecule.BRACKETS_REGEX).matcher(legitFormula);
        assertTrue(matcher.find());

        assertEquals(legitFormula, matcher.group(0));
        assertEquals(prefix, matcher.group(1));
        assertEquals(insideBrackets, matcher.group(2));
        assertEquals(suffix, matcher.group(3));
    }
}