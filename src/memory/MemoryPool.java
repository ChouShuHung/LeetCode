package memory;

import java.util.LinkedList;
import java.util.Queue;

public class MemoryPool {
    private final int chunkSize;
    private final int numChunks;
    private final byte[] pool;
    private final Queue<byte[]> freeList;

    public MemoryPool(int chunkSize, int numChunks) {
        this.chunkSize = chunkSize;
        this.numChunks = numChunks;
        this.pool = new byte[chunkSize * numChunks];
        this.freeList = new LinkedList<>();

        // Initialize free list
        for (int i = 0; i < numChunks; i++) {
            freeList.offer(getChunk(i));
        }
    }

    private byte[] getChunk(int index) {
        byte[] chunk = new byte[chunkSize];
        System.arraycopy(pool, index * chunkSize, chunk, 0, chunkSize);
        return chunk;
    }

    public synchronized byte[] allocate() {
        if (freeList.isEmpty()) {
            throw new OutOfMemoryError("No free memory chunks available");
        }
        return freeList.poll();
    }

    public synchronized void deallocate(byte[] chunk) {
        if (chunk.length != chunkSize) {
            throw new IllegalArgumentException("Invalid chunk size");
        }
        freeList.offer(chunk);
    }

    public static void main(String[] args) {
    
        MemoryPool pool = new MemoryPool(32, 10); // Pool with 10 chunks of 32 bytes each

        byte[] chunk1 = pool.allocate();
        byte[] chunk2 = pool.allocate();

        pool.deallocate(chunk1);
        pool.deallocate(chunk2);
    }

}
