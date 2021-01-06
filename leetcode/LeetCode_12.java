package leetcode;

class Solution {
    private static Map<Integer, String> symbols;
    
    
    public String intToRoman(int num) {
        symbols = new TreeMap<>();
        symbols.put(1, "I"); symbols.put(4, "IV"); symbols.put(9, "IX"); symbols.put(49, "IL"); symbols.put(99, "IC"); symbols.put(499,                 "ID");       symbols.put(999, "IM");
    symbols.put(5, "V");  symbols.put(45, "VL"); symbols.put(95, "VC"); symbols.put(495, "VD");     symbols.put(995, "VM");
    symbols.put(10, "X"); symbols.put(40, "XL"); symbols.put(90, "XC"); symbols.put(490, "XD");       symbols.put(990, "XM");
    symbols.put(50, "L");  symbols.put(450, "LD");       symbols.put(950, "LM");
    symbols.put(100, "C"); symbols.put(400, "CD");       symbols.put(900, "CM");
    symbols.put(500, "D");
    symbols.put(1000, "M");
        StringBuilder sb = new StringBuilder();
        while(num > 0){
            Map.Entry<Integer,String> e = symbols.floorEntry(num);
            sb.append(e.getValue());
            num =- e.getKey();
        }
        return sb.toString();
    }
}
