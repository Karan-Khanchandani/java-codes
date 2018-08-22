/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        ArrayList<Interval> res = new ArrayList<>();
        ArrayList<Interval> schedules = new ArrayList<>();
        for(List<Interval> l : schedule){
            schedules.addAll(l);
        }
        Collections.sort(schedules, new Comparator<Interval>(){
            public int compare(Interval a, Interval b){
                return a.start - b.start;
            } 
        });
        
        Interval temp = schedules.get(0);
        for(Interval each : schedules){
            if(temp.end < each.start){
                res.add(new Interval(temp.end, each.start));
                temp = each;
            }else{
                temp = temp.end < each.end ? each : temp;
            }
        }
        
        return res;
        
    }
}
