package binary_search;

/**
 * { 10, 20, 30, 40, 50, 60, 70, 80, 90 }
 * 3
 */
public class FairWorkload {
    public int getMostWork(int[] folders, int workers) {
        //  Can the workload be spread so that each worker has to examine no more than x folders, with the limited number of workers available?
        int totalFolders = calculateTotalFolder(folders);
        int lo = max(folders);
        int hi = totalFolders;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;

            int required = 0;
            int currentLoad = 1;
            for (int folder : folders) {
                if (currentLoad + folder <= mid) {
                    currentLoad += folder;
                } else {
                    required += 1;
                    currentLoad = folder;
                }
            }
            if (required <= workers) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    private int max(int[] folders) {
        int i = folders[0];
        for (int folder : folders) {
            if (i < folder) {
                i = folder;
            }
        }
        return i;
    }

    private boolean p(int mid) {
        return false;
    }

    private int calculateTotalFolder(int[] folders) {
        int total = 0;
        for (int size : folders) {
            total += size;
        }
        return total;
    }
}
