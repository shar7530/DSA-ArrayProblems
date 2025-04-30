import java.util.*;

// A collection of commonly asked Array problems in DSA (Data Structures & Algorithms)
public class ArraysEasy {

    public static void main(String a[]){
        Scanner sc = new Scanner(System.in);
        ArraysEasy arraysEasy = new ArraysEasy();

        // Example input arrays
        int arr1[]= {1,1,2,3,3,4,4,5,5};
        int arr2[] = {1,3,4,6,7,8,9,100};

        // Sample method call
        System.out.println(arraysEasy.findNumberAppearOnce(arr1));
    }

    // ✅ Find the largest number in the array
    private int largestNumber(int arr[]){
        int max = arr[0];
        for(int i = 1; i< arr.length; i++){
            if(max < arr[i]){
                max = arr[i];
            }
        }
        return max;
    }

    // ✅ Find the second largest number using sorting
    private int secondLargest(int arr[]){
        Arrays.sort(arr);
        int max = arr[arr.length-1];
        for(int i = arr.length-2; i>=0; i--){
            if(arr[i] != max){
                return arr[i];
            }
        }
        return -1; // if no second largest exists
    }

    // ✅ Find second largest without sorting
    private int slargestwithoutsort(int arr[]){
        int max = arr[0];
        for(int i = 1; i< arr.length; i++){
            if(max < arr[i]){
                max = arr[i];
            }
        }
        int slargest = -1;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] > slargest && arr[i] != max){
                slargest = arr[i];
            }
        }
        return slargest;
    }

    // ✅ Check if the array is sorted in ascending order
    public boolean checkSort(int arr[]){
        for(int i = 0 ; i < arr.length-1; i++){
            if(arr[i] > arr[i+1]) return false;
        }
        return true;
    }

    // ✅ Left rotate array by 1 position
    public void leftRotateBy1(int arr[]){
        int temp = arr[0];
        for(int i = 1; i < arr.length; i++){
            arr[i-1] = arr[i];
        }
        arr[arr.length-1] = temp;
        System.out.println(Arrays.toString(arr));
    }

    // ✅ Right rotate array by 1 position
    public void rightRotateBy1(int arr[]){
        int temp = arr[arr.length-1];
        for(int i = arr.length-1; i >= 1; i--){
            arr[i] = arr[i-1];
        }
        arr[0] = temp;
        System.out.println(Arrays.toString(arr));
    }

    // ✅ Left rotate array by d positions using extra array (brute force)
    public void leftRotateByDBrute(int arr[], int d){
        int n = arr.length;
        d = d % n;
        int[] temp = new int[d];        
        for (int i = 0; i < d; i++){
            temp[i] = arr[i];
        }
        for(int i = 0; i < n - d; i++){
            arr[i] = arr[i + d];
        }
        for(int i = 0; i < d; i++){
            arr[n - d + i] = temp[i];
        }
        System.out.println("ARR = " + Arrays.toString(arr));
    }

    // ✅ Move all zeroes to end of array - Brute Force
    public int[] moveZerosToEnd(int[] arr){
        ArrayList<Integer> temp = new ArrayList<>();
        for(int i : arr){
            if(i != 0) temp.add(i);
        }
        for(int i = 0; i < temp.size(); i++){
            arr[i] = temp.get(i);
        }
        for(int i = temp.size(); i < arr.length; i++){
            arr[i] = 0;
        }
        return arr;
    }

    // ✅ Move all zeroes to end - Optimal using two-pointer
    public int[] moveZerosToEndOptimal(int[] arr){
        int j = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] != 0){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j++;
            }
        }
        return arr;
    }

    // ✅ Standard linear search
    public int linearSearch(int[] arr, int num){
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == num){
                return i;
            }
        }
        return -1;
    }

    // ✅ Union of two arrays using HashSet
    public void unionUsingHashset(int[] arr1, int[] arr2){
        HashSet<Integer> set = new HashSet<>();
        for(int i : arr1) set.add(i);
        for(int i : arr2) set.add(i);
        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
        System.out.println(list);
    }

    // ✅ Optimal union using two pointers (sorted arrays)
    public void unionOptimal(int[] arr1, int[] arr2){
        List<Integer> list = new ArrayList<>();
        int i = 0, j = 0;
        while(i < arr1.length && j < arr2.length){
            if(arr1[i] < arr2[j]){
                if(list.isEmpty() || list.get(list.size()-1) != arr1[i])
                    list.add(arr1[i]);
                i++;
            } else if(arr1[i] > arr2[j]){
                if(list.isEmpty() || list.get(list.size()-1) != arr2[j])
                    list.add(arr2[j]);
                j++;
            } else {
                if(list.isEmpty() || list.get(list.size()-1) != arr1[i])
                    list.add(arr1[i]);
                i++; j++;
            }
        }
        while(i < arr1.length){
            if(list.get(list.size()-1) != arr1[i]) list.add(arr1[i]);
            i++;
        }
        while(j < arr2.length){
            if(list.get(list.size()-1) != arr2[j]) list.add(arr2[j]);
            j++;
        }
        System.out.println(list);
    }

    // ✅ Intersection of two sorted arrays
    public void intersectionOptimal(int[] arr1, int[] arr2){
        ArrayList<Integer> intersectionArray = new ArrayList<>();
        int i = 0, j = 0;
        while(i < arr1.length && j < arr2.length){
            if(arr1[i] < arr2[j]) i++;
            else if(arr1[i] > arr2[j]) j++;
            else {
                intersectionArray.add(arr1[i]);
                i++; j++;
            }
        }
        System.out.println(intersectionArray);
    }

    // ✅ Find missing number in 1 to n+1 range using Sum formula
    public int findMisssingNumber(int[] arr){
        int n = arr.length;
        int total = (n + 1) * (n + 2) / 2;
        for(int i : arr) total -= i;
        return total;
    }

    // ✅ Find missing number using XOR method
    public int findMisssingNumberXOR(int[] arr){
        int xor1 = 0, xor2 = 0;
        for(int i = 1; i <= arr.length + 1; i++) xor1 ^= i;
        for(int i : arr) xor2 ^= i;
        return xor1 ^ xor2;
    }

    // ✅ Find maximum number of consecutive 1s
    public int maxConsecutiveOnes(int[] nums){
        int max = 0, count = 0;
        for(int i : nums){
            if(i == 1){
                count++;
                max = Math.max(max, count);
            } else {
                count = 0;
            }
        }
        return max;
    }

    // ✅ Find the number that appears only once (others twice)
    public int findNumberAppearOnce(int[] nums){
        int xor = 0;
        for(int i : nums){
            xor ^= i;
        }
        return xor;
    }

}

