package gcr_codebase.stringbuffer_stringbuilder_filereader_inputstreamreader_linearsearch_binarysearch;

//Performance Comparison: StringBuilder vs StringBuffer

public class CompareSBandSBuffer {

    public static void main(String[] args) {

        int count = 1_000_000;

        // StringBuilder timing
        long startSB = System.nanoTime();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < count; i++) {
            sb.append("hello");
        }

        long endSB = System.nanoTime();

        // StringBuffer timing
        long startSBuffer = System.nanoTime();
        StringBuffer sBuffer = new StringBuffer();

        for (int i = 0; i < count; i++) {
            sBuffer.append("hello");
        }

        long endSBuffer = System.nanoTime();

        System.out.println("StringBuilder Time: " + (endSB - startSB));
        System.out.println("StringBuffer Time: " + (endSBuffer - startSBuffer));
    }
}

