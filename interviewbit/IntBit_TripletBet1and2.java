package interviewbit;

public class Solution {
    public int solve(ArrayList<String> A) {
        ArrayList<Double> res = new ArrayList<>();
        for(int i = 0; i < A.size(); i++){
            res.add(Double.parseDouble(A.get(i)));
        }
        if(res.size() < 3) return 0;
        double a = res.get(0), b = res.get(1), c = res.get(2);
        for(int i = 3; i < res.size(); i++){
            double sum = a+b+c;
            if(Double.compare(sum, 1) > 0 && Double.compare(sum, 2) < 0)return 1;
            if(Double.compare(sum, 1) < 0){
                if(Double.compare(a, b) < 0 && Double.compare(a, c) < 0) a = res.get(i);
                else if(Double.compare(b, a) < 0 && Double.compare(b, c) < 0) b= res.get(i);
                else c = res.get(i);
            }
            if(Double.compare(sum, 2) > 0){
                if(Double.compare(a, b) > 0 && Double.compare(a, c) > 0) a = res.get(i);
                else if(Double.compare(b, a) > 0 && Double.compare(b, c) > 0) b= res.get(i);
                else c = res.get(i);
            }
        }
        
        double sum  = a + b+ c;
        if(Double.compare(sum, 1) > 0 && Double.compare(sum, 2) < 0)return 1;
        
        return 0;
    }
}
