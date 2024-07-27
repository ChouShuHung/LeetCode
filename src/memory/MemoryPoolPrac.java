package memory;

import java.util.LinkedList;
import java.util.Queue;

public class MemoryPoolPrac {
    private final int chunkSize;
    private final int numChunks;
    private byte[] pool;
    private Queue<byte[]> freeList;

    public MemoryPoolPrac(int chunkSize, int numChunks) {
        this.chunkSize = chunkSize;
        this.numChunks = numChunks;
        this.pool = new byte[chunkSize * numChunks];
        this.freeList = new LinkedList<>();

        for (int i = 0; i < numChunks; i++) {
            freeList.offer(getChunk(i));
        }
    }

    private byte[] getChunk(int index) {
        byte[] chunk = new byte[chunkSize];
        System.arraycopy(pool, index * chunkSize, chunk, 0, chunkSize);
        return chunk;
    }

    public byte[] allocate() {
        if (freeList.isEmpty())
            throw new OutOfMemoryError("No free memory chunk");
        return freeList.poll();
    }

    public void deallocate(byte[] chunk) {
        if (chunk.length != chunkSize)
            throw new IllegalArgumentException("Invalid chunk");
        freeList.offer(chunk);
    }

    public static void main(String[] args) {
        MemoryPoolPrac mp = new MemoryPoolPrac(32,10);
        byte[] chunk = mp.allocate();
        mp.deallocate(chunk);
    }
}
