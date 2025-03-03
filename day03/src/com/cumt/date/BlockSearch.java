package com.cumt.date;

import java.util.ArrayList;
import java.util.List;

public class BlockSearch {
    private int blockSize;
    private List<Integer> data;
    private List<Integer> indexTable;

    public BlockSearch(List<Integer> data) {
        this.data = data;
        this.blockSize = (int) Math.sqrt(data.size());
        this.indexTable = new ArrayList<>();
        buildIndexTable();
    }

    private void buildIndexTable() {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < data.size(); i++) {
            max = Math.max(max, data.get(i));
            if ((i + 1) % blockSize == 0 || i == data.size() - 1) {
                indexTable.add(max);
                max = Integer.MIN_VALUE;
            }
        }
    }

    public int search(int target) {
        int blockIndex = findBlock(target);
        if (blockIndex == -1) {
            return -1; // Target not found
        }
        return linearSearchInBlock(blockIndex, target);
    }

    private int findBlock(int target) {
        for (int i = 0; i < indexTable.size(); i++) {
            if (indexTable.get(i) >= target) {
                return i;
            }
        }
        return -1; // Target not found
    }

    private int linearSearchInBlock(int blockIndex, int target) {
        int start = blockIndex * blockSize;
        int end = Math.min(start + blockSize, data.size());
        for (int i = start; i < end; i++) {
            if (data.get(i) == target) {
                return i; // Target found
            }
        }
        return -1; // Target not found
    }

    public static void main(String[] args) {
        List<Integer> data = List.of(1, 3, 5, 7, 9, 11, 13, 15, 17, 19, 21, 23, 25, 27, 29);
        BlockSearch blockSearch = new BlockSearch(data);
        int target = 17;
        int index = blockSearch.search(target);
        if (index != -1) {
            System.out.println("Target found at index: " + index);
        } else {
            System.out.println("Target not found");
        }
    }
}
