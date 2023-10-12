   public int findPeakElement(int[] arr) {
        int l = 0;
        int h = arr.length - 1;
        if (h == 0) {
            return 0; // base case, return 0 if array has only one element
        }
        while (h >= l) {
            int mid = l + (h - l) / 2;
            if (mid > 0 && mid < arr.length - 1) {
                if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
                    return mid;
                } else if (arr[mid] < arr[mid - 1]) {
                    h = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else if (mid == 0) {
                if (arr[mid] > arr[mid + 1]) {
                    return 0;
                } else {
                    return 1;
                }
            } else if (mid == arr.length - 1) {
                if (arr[mid] > arr[mid - 1]) {
                    return arr.length - 1;
                } else {
                    return arr.length - 2;
                }
            }
        }
        return 0;
