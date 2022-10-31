package Week2;

public class Majority {
    public int majorityElement(int[] nums) {
        int counter = 1;
        int majorElement = -1;
        for (Integer element : nums) {
            if (majorElement == element) {
                counter++;
            } else {
                counter--;
            }

            if (counter == 0) {
                // time to change the major element
                counter = 1;
                majorElement = element;
            }
        }
        counter = 0;
        for (Integer checkElement : nums) {
            if (checkElement == majorElement)
                counter++;
        }

        return (counter > nums.length/2) ? majorElement : -1;
    }

    public static void main(String[] args) {
        System.out.println(new Majority().majorityElement(new int[]{3,2,3}));
        System.out.println(new Majority().majorityElement(new int[]{2,2,1,1,1,2,2}));
    }
}
