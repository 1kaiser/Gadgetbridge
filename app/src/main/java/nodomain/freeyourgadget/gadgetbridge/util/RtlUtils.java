package nodomain.freeyourgadget.gadgetbridge.util;

import android.util.Log;
import android.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import nodomain.freeyourgadget.gadgetbridge.GBApplication;

class RtlUtils {
    /**
     * Checks the status of right-to-left option
     * @return true if right-to-left option is On, and false, if Off or not exist
     */
    public static boolean contextualSupport()
    {
        return GBApplication.getPrefs().getBoolean("contextualArabic", false);
    }

    //map with brackets chars to change there direction
    private static Map<Character, Character> directionSignsMap = new HashMap<Character, Character>(){
        {
            put('(', ')'); put(')', '('); put('[', ']'); put(']', '['); put('{','}'); put('}','{');


        }
    };

    //list of unicode ranges of rtl chars
    private static ArrayList<Pair<Character, Character>> hebrewRange = new ArrayList<Pair<Character, Character>>() {
        {
            add(new Pair<Character, Character>('\u0590', '\u05F4'));
            add(new Pair<Character, Character>('\uFB1D', '\uFB4F'));
        }
    };

    //list of unicode ranges of rtl chars
    private static ArrayList<Pair<Character, Character>> arabicRange = new ArrayList<Pair<Character, Character>>() {
        {
            add(new Pair<Character, Character>('\u0600', '\u06FF'));
            add(new Pair<Character, Character>('\u0750', '\u077F'));
            add(new Pair<Character, Character>('\u08A0', '\u08FF'));
            add(new Pair<Character, Character>('\uFB50', '\uFDFF'));
            add(new Pair<Character, Character>('\uFE70', '\uFEFF'));
        }
    };

    //list of unicode ranges of rtl chars
    private static ArrayList<Pair<Character, Character>> rtlRange = new ArrayList<Pair<Character, Character>>() {
        {
            addAll(hebrewRange);
            addAll(arabicRange);
        }
    };

    /**
     * @return true if the char is in the rtl range, otherwise false
     */
    static Boolean isHebrew(char c){
        for (Pair<Character, Character> rang: hebrewRange) {
            if (rang.first <= c && c <= rang.second) {
                return true;
            }
        }
        return false;
    }

    /**
     * @return true if the char is in the rtl range, otherwise false
     */
    static Boolean isArabic(char c){
        for (Pair<Character, Character> rang: arabicRange) {
            if (rang.first <= c && c <= rang.second) {
                return true;
            }
        }
        return false;
    }

    /**
     * @return true if the char is in the rtl range, otherwise false
     */
    static Boolean isRtl(char c){
        for (Pair<Character, Character> rang: rtlRange) {
            if (rang.first <= c && c <= rang.second) {
                return true;
            }
        }
        return false;
    }

    //list of unicode ranges of punctuations chars
    private static ArrayList <Pair<Character, Character>> punctuationsRange = new ArrayList<Pair<Character, Character>>() {
        {
            add(new Pair<Character, Character>('\u0021', '\u002F'));
            add(new Pair<Character, Character>('\u003A', '\u0040'));
            add(new Pair<Character, Character>('\u005B', '\u0060'));
            add(new Pair<Character, Character>('\u007B', '\u007E'));
        }
    };

    /**
     * @return true if the char is in the punctuations range, otherwise false
     */
    static Boolean isPunctuations(char c){
        for (Pair<Character, Character> rang: punctuationsRange) {
            if (rang.first <= c && c <= rang.second) {
                return true;
            }
        }
        return false;
    }

    //list of sign that ends a word
    private static ArrayList<Character> wordEndSigns = new ArrayList<Character>() {
        {
            add('\0');
            add('\n');
            add(' ');
        }
    };

    /**
     * @return true if the char is in the end of word list, otherwise false
     */
    static Boolean isWordEndSign(char c){
        for (char sign: wordEndSigns){
            if (c == sign){
                return true;
            }
        }

        return false;
    }

    //list of sign that ends a word
    private static ArrayList<Character> endLineSigns = new ArrayList<Character>() {
        {
            add('\0');
            add('\n');
        }
    };

    /**
     * @return true if the char is in the end of word list, otherwise false
     */
    static Boolean isEndLineSign(char c){
        for (char sign: endLineSigns){
            if (c == sign){
                return true;
            }
        }

        return false;
    }

    //map from Arabian characters to their contextual form in the beginning of the word
    private static Map<Character, Character> contextualArabicIsolated = new HashMap<Character, Character>(){
        {
            put('ا', '\uFE8D');
            put('ب', '\uFE8F');
            put('ت', '\uFE95');
            put('ث', '\uFE99');
            put('ج', '\uFE9D');
            put('ح', '\uFEA1');
            put('خ', '\uFEA5');
            put('د', '\uFEA9');
            put('ذ', '\uFEAB');
            put('ر', '\uFEAD');
            put('ز', '\uFEAF');
            put('س', '\uFEB1');
            put('ش', '\uFEB5');
            put('ص', '\uFEB9');
            put('ض', '\uFEBD');
            put('ط', '\uFEC1');
            put('ظ', '\uFEC5');
            put('ع', '\uFEC9');
            put('غ', '\uFECD');
            put('ف', '\uFED1');
            put('ق', '\uFED5');
            put('ك', '\uFED9');
            put('ل', '\uFEDD');
            put('م', '\uFEE1');
            put('ن', '\uFEE5');
            put('ه', '\uFEE9');
            put('و', '\uFEED');
            put('ي', '\uFEF1');
            put('آ', '\uFE81');
            put('ة', '\uFE93');
            put('ى', '\uFEEF');
            put('ئ', '\uFE89');
            put('إ', '\uFE87');
            put('أ', '\uFE83');
            put('ء', '\uFE80');
            put('ؤ', '\uFE85');
            put((char)('ل' + 'آ'), '\uFEF5');
            put((char)('ل' + 'أ'), '\uFEF7');
            put((char)('ل' + 'إ'), '\uFEF9');
            put((char)('ل' + 'ا'), '\uFEFB');

        }
    };

    //map from Arabian characters to their contextual form in the beginning of the word
    private static Map<Character, Character> contextualArabicBeginning = new HashMap<Character, Character>(){
        {
            put('ب', '\uFE91');
            put('ت', '\uFE97');
            put('ث', '\uFE9B');
            put('ج', '\uFE9F');
            put('ح', '\uFEA3');
            put('خ', '\uFEA7');
            put('س', '\uFEB3');
            put('ش', '\uFEB7');
            put('ص', '\uFEBB');
            put('ض', '\uFEBF');
            put('ط', '\uFEC3');
            put('ظ', '\uFEC7');
            put('ع', '\uFECB');
            put('غ', '\uFECF');
            put('ف', '\uFED3');
            put('ق', '\uFED7');
            put('ك', '\uFEDB');
            put('ل', '\uFEDF');
            put('م', '\uFEE3');
            put('ن', '\uFEE7');
            put('ه', '\uFEEB');
            put('ي', '\uFEF3');
            put('ئ', '\uFE8B');
        }
    };

    //map from Arabian characters to their contextual form in the middle of the word
    private static Map<Character, Character> contextualArabicMiddle = new HashMap<Character, Character>(){
        {
            put('ب', '\uFE92');
            put('ت', '\uFE98');
            put('ث', '\uFE9C');
            put('ج', '\uFEA0');
            put('ح', '\uFEA4');
            put('خ', '\uFEA8');
            put('س', '\uFEB4');
            put('ش', '\uFEB8');
            put('ص', '\uFEBC');
            put('ض', '\uFEC0');
            put('ط', '\uFEC4');
            put('ظ', '\uFEC8');
            put('ع', '\uFECC');
            put('غ', '\uFED0');
            put('ف', '\uFED4');
            put('ق', '\uFED8');
            put('ك', '\uFEDC');
            put('ل', '\uFEE0');
            put('م', '\uFEE4');
            put('ن', '\uFEE8');
            put('ه', '\uFEEC');
            put('ي', '\uFEF4');
            put('ئ', '\uFE8C');
        }
    };

    //map from Arabian characters to their contextual form in the end of the word
    private static Map<Character, Character> contextualArabicEnd = new HashMap<Character, Character>(){
        {
            put('ا', '\uFE8E');
            put('ب', '\uFE90');
            put('ت', '\uFE96');
            put('ث', '\uFE9A');
            put('ج', '\uFE9E');
            put('ح', '\uFEA2');
            put('خ', '\uFEA6');
            put('د', '\uFEAA');
            put('ذ', '\uFEAC');
            put('ر', '\uFEAE');
            put('ز', '\uFEB0');
            put('س', '\uFEB2');
            put('ش', '\uFEB6');
            put('ص', '\uFEBA');
            put('ض', '\uFEBE');
            put('ط', '\uFEC2');
            put('ظ', '\uFEC6');
            put('ع', '\uFECA');
            put('غ', '\uFECE');
            put('ف', '\uFED2');
            put('ق', '\uFED6');
            put('ك', '\uFEDA');
            put('ل', '\uFEDE');
            put('م', '\uFEE2');
            put('ن', '\uFEE6');
            put('ه', '\uFEEA');
            put('و', '\uFEEE');
            put('ي', '\uFEF2');
            put('آ', '\uFE82');
            put('ة', '\uFE94');
            put('ى', '\uFEF0');
            put('ئ', '\uFE8A');
            put('إ', '\uFE88');
            put('أ', '\uFE84');
            put('ؤ', '\uFE86');
            put((char)('ل' + 'آ'), '\uFEF6');
            put((char)('ل' + 'أ'), '\uFEF8');
            put((char)('ل' + 'إ'), '\uFEFA');
            put((char)('ل' + 'ا'), '\uFEFC');
        }
    };
    enum contextualState{
        isolate,
        begin,
        middle,
        end
    }

    private static boolean exceptionAfterLam(char c){
        switch (c){
            case '\u0622':
            case '\u0623':
            case '\u0625':
            case '\u0627':
                return true;
            default:
                return false;

        }
    }

    private static char getContextualSymbol(Character c, contextualState state) {
        Character newChar;
        switch (state){
            case begin:
                newChar = contextualArabicBeginning.get(c);
                break;
            case middle:
                newChar = contextualArabicMiddle.get(c);
                break;
            case end:
                newChar = contextualArabicEnd.get(c);
                break;
            case isolate:
            default:
                newChar  = contextualArabicIsolated.get(c);;
        }
        if (newChar != null){
            return newChar;
        } else{
            return c;
        }
    }

    static String converToContextual(String s){
        if (s == null || s.isEmpty() || s.length() == 1){
            return s;
        }

        int length = s.length();
        StringBuilder newWord = new StringBuilder(length);

        Character curChar, nextChar = s.charAt(0);
        contextualState prevState = contextualState.isolate;
        contextualState curState = contextualState.isolate;

        for (int i = 0; i < length - 1; i++){
            curChar = nextChar;
            nextChar = s.charAt(i + 1);

            if (curChar == 'ل' && exceptionAfterLam(nextChar)){
                i++;
                curChar = (char)(nextChar + curChar);
                if (i < length - 1) {
                    nextChar = s.charAt(i + 1);
                }else{
                    nextChar = curChar;
                    prevState = curState;
                    break;
                }

            }

            curState = getCharContextualState(prevState, curChar, nextChar);
            newWord.append(getContextualSymbol(curChar, curState));
            prevState = curState;


        }
        curState = getCharContextualState(prevState, nextChar, null);
        newWord.append(getContextualSymbol(nextChar, curState));

        return newWord.toString();
    }

    private static contextualState getCharContextualState(contextualState prevState, Character curChar, Character nextChar) {
        contextualState curState;
        if ((prevState == contextualState.isolate || prevState == contextualState.end) &&
                contextualArabicBeginning.containsKey(curChar) &&
                contextualArabicEnd.containsKey(nextChar)){

            curState = contextualState.begin;

        } else if ((prevState == contextualState.begin || prevState == contextualState.middle) &&
                contextualArabicEnd.containsKey(curChar)){

            if (contextualArabicMiddle.containsKey(curChar) && contextualArabicEnd.containsKey(nextChar)){
                curState = contextualState.middle;
            }else{
                curState = contextualState.end;
            }
        }else{
            curState = contextualState.isolate;
        }
        return curState;
    }


    /**
     * The function get a string and reverse it.
     * in case of end-of-word sign, it will leave it at the end.
     * in case of sign with direction like brackets, it will change the direction.
     * @param s - the string to reverse
     * @return reversed string
     */
    static String reverse(String s) {
        int j = s.length();
        int isEndLine = 0;
        char[] newWord = new char[j];

        if (j == 0) {
            return s;
        }

        // remain end-of-word sign at the end
        if (isEndLineSign(s.charAt(s.length() - 1))){
            isEndLine = 1;
            newWord[--j] = s.charAt(s.length() - 1);
        }

        for (int i = 0; i < s.length() - isEndLine; i++) {
            if (directionSignsMap.containsKey(s.charAt(i))) {
                newWord[--j] = directionSignsMap.get(s.charAt(i));
            } else {
                newWord[--j] = s.charAt(i);
            }
        }

        return new String(newWord);
    }
}
