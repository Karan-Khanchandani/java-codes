package interviewbit;

public class Solution {
    public ArrayList<Integer> stepnum(int A, int B) {
        ArrayList<Integer> res = new ArrayList<>();
        for(int i = 0; i <= 9; i++) bfs(A,B,i,res);
        Collections.sort(res);
        return res;
    }
    
    public void bfs(int A, int B, int num, ArrayList<Integer> res){
        Queue<Integer> q = new LinkedList<>();
        q.add(num);
        while(!q.isEmpty()){
            int stepNum = q.poll();
            
            if(stepNum >= A && stepNum <= B){
                res.add(stepNum);
            }
            
            if(num == 0 || stepNum > B) continue;
            
            
            
            int lastDigit = stepNum%10;
            int upper = stepNum*10 + lastDigit + 1;
            int lower = stepNum*10 + lastDigit - 1;
            
            if(lastDigit == 0) q.add(upper);
            else if(lastDigit == 9) q.add(lower);
            else{
                q.add(lower);
                q.add(upper);
            }
        }
    }
}
