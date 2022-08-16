class Solution
{
     public static void sortColors(int[] arr) {
        int n = arr.length;
        int low = 0, mid = 0, high = n - 1, temp;
        while (mid <= high) {
            switch (arr[mid]) {
                case 0:
                    temp = arr[mid];
                    arr[mid] = arr[low];
                    arr[low] = temp;
                    low++;
                    mid++;
                    break;
                case 1:
                    mid++;
                    break;
                case 2:
                    temp = arr[mid];
                    arr[mid] = arr[high];
                    arr[high] = temp;
                    high--;
                    break;
            }
        }
    }
}