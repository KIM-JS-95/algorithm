package ThisCoTe;

import java.util.*;

public class Students_Grades {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        HashMap<String,Integer> map = new HashMap<>();

        Set set = map.keySet();
        Iterator iterator = set.iterator();

        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            String name = sc.next();
            int grade = sc.nextInt();
            arr[i] = grade;
            map.put(name, grade);
        }

        for (int i = 1; i < map.size(); i++) {
            if (arr[i] < arr[i - 1]) {
                int temp = arr[i];
                arr[i] = arr[i - 1];
                arr[i-1] = temp;
            }
        }

        String[] name = new String[n];

        for(int i=0;i<n;i++) {
            name[i] = getSingleKeyFromValue(map, arr[i]);
        }

        for(String val :name)
            System.out.print(val + " ");
    }
    public static <K, V> K getSingleKeyFromValue(Map<K, V> map, V value) {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            if (Objects.equals(value, entry.getValue())) {
                return entry.getKey();
            }
        }
        return null;
    }
}
