package problem;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/*
Problem Description:
Which buildings can see sunset
*/

public class Problem_9_6{

    public static class Building{
        private Integer id;
        private Integer height;

        public Building(Integer id,Integer height){
            this.id = id;
            this.height =height;
        }
    }

    public static Deque<Building> examineBuildings(Iterator<Integer> sequence){
        int buildingIdx = 0;
        Deque<Building> buildingsWithSunset = new LinkedList<>();
        while(sequence.hasNext()){
            Integer buildingHeight = sequence.next();

            while(!buildingsWithSunset.isEmpty() && (
                Integer.compare(buildingHeight, buildingsWithSunset.getLast().height) >= 0
            )){
                buildingsWithSunset.removeLast();
            }

            buildingsWithSunset.addLast(new Building(buildingIdx++, buildingHeight));
        }

        return buildingsWithSunset;
    }




    public static void main(String[] args) {
        List<Integer> buildings = new LinkedList<>();
        buildings.add(11);
        buildings.add(9);
        buildings.add(2);
        buildings.add(2);
        buildings.add(8);
        buildings.add(3);
        buildings.add(5);
        buildings.add(2);

        Deque<Building> buildingsWithSunset = examineBuildings(buildings.iterator());

        while(!buildingsWithSunset.isEmpty()){
            System.out.print(buildingsWithSunset.removeLast().height);
            System.out.print(" ");
        }
        System.out.println();
    }
}